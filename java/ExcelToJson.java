package com.example.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcelToJson {

	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\GELLU HIMAJA YADAV\\Downloads\\locations.xlsx";
		System.out.println(toConvertJson(filePath));
	}

	public static String toConvertJson(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		Map<String, Object> result = new LinkedHashMap<>();
		List<Map<String, Object>> countries = new ArrayList<>();
		Map<String, Map<String, Object>> countryMap = new HashMap<>();

		for (Row row : sheet) {
			if (row.getRowNum() == 0)
				continue;
			String countryName = row.getCell(0).toString();
			String countryCode = row.getCell(1).toString();
			String stateName = row.getCell(2).toString();
			String stateCode = row.getCell(3).toString();
			String districtName = row.getCell(4).toString();	
			String districtCode = row.getCell(5).toString();
			String cityName = row.getCell(6).toString();
			String cityCode = row.getCell(7).toString();
			Map<String, Object> country = countryMap.get(countryCode);
			if (country == null) {
				country = new LinkedHashMap<>();
				country.put("name", countryName);
				country.put("code", countryCode);
				country.put("state", new ArrayList<Map<String, Object>>());
				countries.add(country);
				countryMap.put(countryCode, country);
			}
			List<Map<String, Object>> states = (List<Map<String, Object>>) country.get("state");
			Map<String, Object> state = null;
			for (Map<String, Object> s : states) {
				if (s.get("code").equals(stateCode)) {
					state = s;
					break;
				}
			}
			if (state == null) {
				state = new LinkedHashMap<>();
				state.put("name", stateName);
				state.put("code", stateCode);
				state.put("district", new ArrayList<Map<String, Object>>());
				states.add(state);
			}
			List<Map<String, Object>> districts = (List<Map<String, Object>>) state.get("district");
			Map<String, Object> district = null;
			for (Map<String, Object> d : districts) {
				if (d.get("code").equals(districtCode)) {
					district = d;
					break;
				}
			}
			if (district == null) {
				district = new LinkedHashMap<>();
				district.put("name", districtName);
				district.put("code", districtCode);
				district.put("city", new ArrayList<Map<String, Object>>());
				districts.add(district);
			}
			List<Map<String, Object>> cities = (List<Map<String, Object>>) district.get("city");
			Map<String, Object> city = new LinkedHashMap<>();
			city.put("name", cityName);
			city.put("code", cityCode);
			cities.add(city);
		}
		result.put("country", countries);
		wb.close();	
		fis.close();
		ObjectMapper ob = new ObjectMapper();
		return ob.writer().writeValueAsString(result);
	}
}
