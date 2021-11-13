package com.etpl.common.util;

import java.lang.reflect.Field;

public class ETPLUtil {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
		try {
			Class<?> clazz = first.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Object returnValue = clazz.newInstance();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value1 = field.get(first);
				Object value2 = field.get(second);
				Object value = (value2 != null) ? value1 : value2;
				System.out.println("After Change the Value" + value);
				field.set(returnValue, value);
			}
			return (T) returnValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
