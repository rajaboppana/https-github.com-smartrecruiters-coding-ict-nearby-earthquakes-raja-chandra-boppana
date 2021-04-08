package com.smartrec.nbeq.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;

/**
 * @author RajaBoppana
 *
 */
public class JsonConverter {

	private ObjectMapper objectMapper;

	public JsonConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public <T> T jsonToObject(String json, Class<T> classType) {
		try {
			return objectMapper.readValue(json, classType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String prettifyPrintJson(String json) {
		try {
			Object objectJson = objectMapper.readValue(json, Object.class);
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectJson);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
