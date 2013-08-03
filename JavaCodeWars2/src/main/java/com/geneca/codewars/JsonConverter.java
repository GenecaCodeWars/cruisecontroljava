package com.geneca.codewars;

import java.util.List;

import com.geneca.codewars.data.Command;
import com.geneca.codewars.data.BoardStatus;
import com.google.gson.Gson;

/**
 * Convert Game Objects to/from Json objects - this is refactored into a
 * separate class for conversion so that if the implementation of json
 * conversion changes clients won't care
 */
public class JsonConverter {

	/**
	 * convert java object to JSON format and returned as JSON formatted string
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToJson(List<Command> obj) {
		Gson gson = new Gson();

		return gson.toJson(obj);
	}

	/**
	 * convert the json string back to object
	 * 
	 * @param json
	 * @return
	 */
	public static BoardStatus convertFromJson(String json) {
		Gson gson = new Gson();

		return gson.fromJson(json, BoardStatus.class);
	}
}
