package com.xiaonian.service;

import com.xiaonian.baseTest.SpringTestCase;
import com.xiaonian.core.entity.Strategy;
import com.xiaonian.core.service.IStrategyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 角色服务类测试
 * 
 * @author qqjbest
 * @since 2016年7月8日 下午5:30:22
 */
public class TestStrategyService extends SpringTestCase
{
	@Autowired
	private IStrategyService strategyService;
	
	@Test
	public void testDelete()
	{
	strategyService.delete("1");
	 Strategy strategy = strategyService.getById(1);
	 Assert.assertNull(strategy);
	}
}
