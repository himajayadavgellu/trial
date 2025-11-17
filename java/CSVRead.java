package de.zeroco.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVRead {

    public static void main(String[] args) throws NumberFormatException, IOException {
        String filePath = "students.csv";
        ArrayList<Student> students = readCSV(filePath);
        // 1. Strength of class 10
        System.out.println("Strength in Class 10: " + getStrength(students, 10));
        // 2. Students born in April
        ArrayList<String> aprilStudents = getStudentsByMonth(students, "04");
        System.out.println("Students born in April:");
        for (String name : aprilStudents) {
            System.out.println(name);
        }
        // 3. Classes with only male students
        ArrayList<Integer> onlyMaleClasses = printClassesWithOnlyGender(students, "male");
        System.out.println("\nClasses with only male students: " + onlyMaleClasses);
        // 4. Students born between 2005 and 2010
        Map<String, String> yearRange = new HashMap<>();
        yearRange.put("startYear", "2005");
        yearRange.put("endYear", "2010");
        ArrayList<Student> res = fieldFilter(students, yearRange);
        System.out.println("\nStudents born between 2005 and 2010:");
        for (Student s : res) {
            System.out.println(s.name + " - " + s.dateOfBirth);
        }
        // 5. Students whose names start with 'pa'
        Map<String, String> strStart = new HashMap<>();
        strStart.put("nameStartsWith", "pa");
        ArrayList<Student> result = fieldFilter(students, strStart);
        System.out.println("\nStudents whose names start with 'pa':");
        for (Student s : result) {
            System.out.println(s.name);
        }
        // 6. Count male/female in class 4
        System.out.println("\nGender count in class 4: " + countGender(students, 4));
    }

    public static ArrayList<Student> readCSV(String filePath) throws NumberFormatException, IOException {
        ArrayList<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    int classNum = Integer.parseInt(data[0].trim());
                    Student s = new Student(
                            classNum,
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim()
                    );
                    list.add(s);
                }
            }
        }
        return list;
    }

    public static int getStrength(ArrayList<Student> list, int classNum) {
        int count = 0;
        for (Student s : list) {
            if (s.classNum == classNum) {
                count++;
            }
        }
        return count;
    }
    
    public static ArrayList<String> getStudentsByMonth(ArrayList<Student> list, String month) {
        ArrayList<String> names = new ArrayList<>();
        for (Student s : list) {
            String dob = s.dateOfBirth.replace("/", "-").trim();
            String[] parts = dob.split("-");
            String dobMonth = "";
            if (parts.length == 3) {
                dobMonth = parts[1].trim();
            }
            if (dobMonth.equals(month)) {
                names.add(s.name);
            }
        }
        return names;
    }

    public static ArrayList<Integer> printClassesWithOnlyGender(ArrayList<Student> list, String gender) {
        ArrayList<Integer> classes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Student s : list) {
            if (!classes.contains(s.classNum)) {
                classes.add(s.classNum);
            }
        }
        for (int c : classes) {   
        	boolean allMatch = false;
            for (Student s : list) {
                if (s.classNum == c && !s.gender.equalsIgnoreCase(gender)) {
                	allMatch = true;
                	result.add(c);
                }
            }
            if(allMatch) return null;  
        }     
        return result;
    }


    public static ArrayList<Student> fieldFilter(ArrayList<Student> list, Map<String, String> filter) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : list) {
            boolean match = true;
            if (filter.containsKey("startYear") && filter.containsKey("endYear")) {
                int startYear = Integer.parseInt(filter.get("startYear"));
                int endYear = Integer.parseInt(filter.get("endYear"));
                int year = extractYear(s.dateOfBirth);
                if (year < startYear || year > endYear) {
                    match = false;
                }
            }
            if (filter.containsKey("nameStartsWith")) {
                String prefix = filter.get("nameStartsWith").toLowerCase();
                if (!s.name.toLowerCase().startsWith(prefix)) {
                    match = false;
                }
            }
            if (match) {
                result.add(s);
            }
        }
        return result;
    }

    public static int extractYear(String dob) {
        dob = dob.replace("/", "-").trim();
        String[] parts = dob.split("-");
        if (parts.length == 3) {
            if (parts[0].length() == 4) { // yyyy-mm-dd
                return Integer.parseInt(parts[0].trim());
            } else if (parts[2].length() == 4) { // dd-mm-yyyy
                return Integer.parseInt(parts[2].trim());
            }
        }
        return 0;
    }

    public static String countGender(ArrayList<Student> list, int classNum) {
        int maleCount = 0;
        int femaleCount = 0;
        for (Student s : list) {
            if (s.classNum == classNum) {
                String gender = s.gender.trim();
                if (gender.equalsIgnoreCase("male"))
                    maleCount++;
                else if (gender.equalsIgnoreCase("female"))
                    femaleCount++;
            }
        }
        return "maleCount = " + maleCount + " femaleCount = " + femaleCount;
    }
}
