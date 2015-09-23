package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public interface SQLGenerator {
	
	public String gtSQL(LinkedHashMap<String, String> fields);
		
}
