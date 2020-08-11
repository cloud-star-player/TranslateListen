package com.systop.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	private String datePattern = "yyyy-MM-dd HH:mm:ss";
	@Override
	public Date convert(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			throw new IllegalArgumentException("无效日期");
		}
	}
}
