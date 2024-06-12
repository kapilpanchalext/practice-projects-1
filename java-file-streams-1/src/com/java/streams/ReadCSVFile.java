package com.java.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSVFile {
	public static void main(String[] args) {
		List<StudentData> listOfStudents = new ArrayList<>();

		try (FileInputStream fileInputStream = new FileInputStream("files/input.csv");
             Scanner scanner = new Scanner(fileInputStream)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                // Create a new StudentData object
                StudentData student = new StudentData();

                // Extract data from CSV values
                if (values.length >= 3) {
                    student.setFirstName(values[0].trim());
                    student.setLastName(values[1].trim());
                    student.setAge(Integer.parseInt(values[2].trim()));
                }

                // Add the created StudentData object to the list
                listOfStudents.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the list of StudentData objects
        for (StudentData student : listOfStudents) {
            System.err.println(student);
        }
	}
}
