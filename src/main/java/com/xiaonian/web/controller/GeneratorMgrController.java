package com.xiaonian.web.controller;
import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.entity.Generator;
import com.xiaonian.core.service.IGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 * 
 * 
 * @author qqjbest
 * @since 2017年5月24日 上午10:47:19
 */
@Controller
@RequestMapping("/admin/generator")
public class GeneratorMgrController extends CrudController<Generator, IGeneratorService>{
	@Autowired
	private IGeneratorService generatorService;
	
	@RequestMapping(value = "/all")
	public @ResponseBody PagerBean<Generator> getAll(PagerBean<Generator> pager)
	{	
		return super.getAll(pager);
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String tables, HttpServletResponse response) throws Exception{
		String[] tableNames = new String[]{};
		tableNames = tables.trim().split(",");
		byte[] data = generatorService.generatorCode(tableNames);
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"xiaonian.zip\"");  
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
        IOUtils.write(data, response.getOutputStream());  
	}

	@Override
	public IGeneratorService getService()
	{
		return generatorService;
	}
}
