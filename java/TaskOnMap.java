package com.zerocode.files;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TaskOnMap {
	public static void main(String[] args) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("client_code", "himaja");
		map.put("client_place", "hyderabad");
		try {
			String result = toReplaceKey("C:\\Users\\GELLU HIMAJA YADAV\\Downloads\\licence (1).txt", map);
			System.out.println(result);
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	public static String toReplaceKey(String filePath, Map<Object, Object> map) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(filePath));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = buffer.readLine()) != null) {
			Set<Entry<Object, Object>> s = map.entrySet();
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				line = line.replace("{{" + entry.getKey().toString() + "}}", entry.getValue().toString());
			}
			sb.append(line).append("\n");
		}
		buffer.close();

		FileWriter fw = new FileWriter(filePath);
		fw.write(sb.toString());
		fw.close();
		return sb.toString();
	}
}