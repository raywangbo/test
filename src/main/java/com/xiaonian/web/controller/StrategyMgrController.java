package com.xiaonian.web.controller;

import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.entity.Strategy;
import com.xiaonian.core.service.IStrategyService;
import com.xiaonian.core.utils.CommonUtil;
import com.xiaonian.core.utils.DateUtils;
import com.xiaonian.core.utils.ValidatorUtil;
import com.xiaonian.core.vo.VoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
@Controller
@RequestMapping("/admin/strategy")
public class StrategyMgrController extends CrudController<Strategy, IStrategyService>{
	@Autowired
	private IStrategyService strategyService;
	
	@Override
	public IStrategyService getService()
	{
		return strategyService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody
	PagerBean<Strategy> getAll(PagerBean<Strategy> pager)
	{	
		return super.getAll(pager);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	VoStrategy get(@PathVariable("id") Integer id)
	{
		Strategy strategy = strategyService.getById(id);
		VoStrategy jsonstrategy = new VoStrategy();
		CommonUtil.copyPropertiesIgnoreNull(strategy, jsonstrategy);
		jsonstrategy.setCreateTime(strategy.getCreateTime().getTime());
		return jsonstrategy;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ResponseBean post(Strategy strategy)
	{

		strategy.setCreateTime(DateUtils.getSystemTime());
		strategyService.save(strategy);
		return toResponseJson();
	}


    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseBean put(Strategy strategy)
    {
		strategy.setUpdateTime(DateUtils.getSystemTime());
		strategyService.update(strategy);
        return toResponseJson();
    }


    @RequestMapping(value = "{ids}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseBean del(String ids)
	{
		getService().delete(ids);
		return toResponseJson();
	}
	
	@RequestMapping(value ="/enable", method = RequestMethod.POST)
	public @ResponseBody ResponseBean enable(Integer id)
	{
		strategyService.enable(id);
		return toResponseJson();
	}
	
	@RequestMapping(value ="/disable", method = RequestMethod.POST)
	public @ResponseBody ResponseBean disable(Integer id)
	{
		strategyService.disable(id);
		return toResponseJson();
	}

	/**
	 * 根据角色id获取策略
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getByRoleId")
	public @ResponseBody
	List<VoStrategy> getByRoleId(Integer id)
	{
		List<VoStrategy> voStrategys = new ArrayList<>();
		List<Strategy> ownStrategys = new ArrayList<>();
		if(ValidatorUtil.isNotNull(id))
		{
			ownStrategys = getService().getByRoleId(id);
		}

		for (Strategy Strategy : ownStrategys)
		{
			VoStrategy tempRoels = new VoStrategy();
			CommonUtil.copyPropertiesIgnoreNull(Strategy, tempRoels);
			tempRoels.setOwn(true);
			voStrategys.add(tempRoels);
		}

		List<Strategy> allStrategy = getService().getAllEnable();
		allStrategy.removeAll(ownStrategys);
		for (Strategy Strategy : allStrategy)
		{
			VoStrategy tempRoels = new VoStrategy();
			CommonUtil.copyPropertiesIgnoreNull(Strategy, tempRoels);
			voStrategys.add(tempRoels);
		}
		return voStrategys;
	}
	
}
