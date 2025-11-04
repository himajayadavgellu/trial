package com.example.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ZCUtil {

	public static Map<String, Object> convertJsonToString(String json) {
		try {
			// ObjectMapper mapper = new ObjectMapper();
			return new ObjectMapper().readValue(json, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getBlankStringIfNull(String s) {
		return (s != null) ? s : "";
	}

	public static String getCommaSeperatedString(List<String> list) {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			// result += list.get(i);
			result += list.get(i) + ((i < list.size() - 1) ? "," : "");
		}
		return result;
	}

	public static List<String> getCommaSeperatedListToString(String str) {
//		List<String> list = new ArrayList<String>();
//		for (String s : str.split(",")) {
//			list.add(s);
//		}
//		return list;
		return Arrays.asList(str.split(","));
	}

	public static void main(String[] args) {
		String json = "{\"name\":\"Himaja\",\"age\":22}";
		Map<String, Object> map = ZCUtil.convertJsonToString(json);
		System.out.println(map);
		System.out.println(map.get("name"));
		System.out.println(getBlankStringIfNull(null));
		List<String> s = new ArrayList<>();
		s.add("apple");
		s.add("banana");
		s.add("cherry");
		String a = getCommaSeperatedString(s);
		System.out.println(a);
		List<String> newList = getCommaSeperatedListToString("apple,banana,cherry,");
		System.out.println(newList);
	}

}
