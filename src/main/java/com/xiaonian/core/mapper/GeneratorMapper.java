package com.xiaonian.core.mapper;

import java.util.List;
import java.util.Map;

import com.xiaonian.core.entity.Generator;

public interface GeneratorMapper extends BaseMapper<Generator>{

	List<Map> queryColumns(Map<String, Object> params);

	Map queryTable(Map<String, Object> params);
}