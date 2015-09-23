package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public class SQLValuesGenerator implements SQLGenerator {

	@Override
	public String gtSQL(LinkedHashMap<String, String> fields) {
		String sqlFields = "";
		String sqlValues = "";
		
		for (String key : fields.keySet()) {
			String value = fields.get(key);
			if (sqlFields.equals("")) {
				sqlFields += "(" + key;
				sqlValues += " VALUES (" + value;
			} else {
				sqlFields += ", " + key;
				sqlValues += ", " + value;
			}
		}
		
		sqlFields += ")";
		sqlValues += ")";
		
		return sqlFields + sqlValues;
	}

}
