package com.xiaonian.core.service;

import com.xiaonian.core.entity.Generator;

/**
 * 代码生成服务类接口
 * 
 * @author qqjbest
 * @since 2017年5月24日 上午10:49:53
 */
public interface IGeneratorService extends IBaseService<Generator>
{
	/**
	 * 代码生成
	 *  
	 * @author qqjbest
	 * @since 2017年5月24日 上午10:58:13
	 * @param tableNames
	 * @return
	 */
	byte[] generatorCode(String[] tableNames)  throws Exception;
}
