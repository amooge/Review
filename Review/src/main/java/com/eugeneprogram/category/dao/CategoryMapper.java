package com.eugeneprogram.category.dao;

import java.util.Map;
import java.util.List;

public interface CategoryMapper {
	public List<Map<String, Object>> getAllCategory() throws Exception;
}
