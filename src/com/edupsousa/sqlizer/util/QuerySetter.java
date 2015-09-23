package com.edupsousa.sqlizer.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class QuerySetter {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
	private SQLGenerator sqlGenerator;

	public void set(String field, String value) {
		this.setQuoted(field, value);
	}

	public void set(String field, int value) {
		this.setUnquoted(field, String.valueOf(value));
	}

	public void set(String field, double value) {
		this.setUnquoted(field, String.valueOf(value));
	}

	public void set(String field, Date value) {
		this.setQuoted(field, sdf.format(value));
	}

	public int size() {
		return fields.size();
	}

	private void setQuoted(String field, String value) {
		fields.put(field, "\"" + value + "\"");
	}

	private void setUnquoted(String field, String value) {
		fields.put(field, value);
	}

	public String getSql(int tipo) {
		if (tipo == 1) {
			sqlGenerator = new SQLSetGenerator();

		} else if (tipo == 2) {
			sqlGenerator = new SQLValuesGenerator();

		} else {
			throw new IncompleteQueryException("O tipo errado");
		}
		return sqlGenerator.gtSQL(fields);
	}

}
