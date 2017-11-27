package com.xiaonian.core.service.impl;

import com.xiaonian.core.entity.Generator;
import com.xiaonian.core.mapper.GeneratorMapper;
import com.xiaonian.core.service.IGeneratorService;
import com.xiaonian.core.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorService extends BaseService<Generator,GeneratorMapper> implements IGeneratorService{

    private static Logger log = LoggerFactory.getLogger(GeneratorService.class);
    @Autowired
    private GeneratorMapper generatorMapper;

	@Override
	public GeneratorMapper getMapper()
	{
		return generatorMapper;
	}

	@Override
	public byte[] generatorCode(String[] tableNames) throws Exception
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		
		for(String tableName : tableNames){
			//查询表信息
			Map table = getTableByName(tableName);
			//查询列信息
			List<Map> columns = queryColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	private List<Map> queryColumns(String tableName)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", tableName);
		return generatorMapper.queryColumns(params);
	}

	private Map getTableByName(String tableName)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", tableName);
		return generatorMapper.queryTable(params);
	}
}
