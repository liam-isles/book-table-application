package com.santander.util;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class JSONUtil {

	private static final Logger LOGGER = Logger.getLogger(JSONUtil.class);

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object object) {
		LOGGER.info("JSONUtil + getJSONForObject");
		return gson.toJson(object);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		LOGGER.info("JSONUtil + getObjectForJSON");
		return gson.fromJson(jsonString, clazz);
	}

}
