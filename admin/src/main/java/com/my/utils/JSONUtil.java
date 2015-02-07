package com.my.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtil {

	/**
	 * user gson format object to json
	 * @param object
	 * @return json
	 */
	public static String toJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	/**
	 * user gson format object to json
	 * and Without Expose
	 * @param object
	 * @return json string 
	 */
	public static String toJsonWithoutExpose(Object object) {
		Gson gson = new Gson();
		GsonBuilder gb = new GsonBuilder();
		gb.excludeFieldsWithoutExposeAnnotation();
		gson = gb.create();
		return gson.toJson(object);
	}
}
