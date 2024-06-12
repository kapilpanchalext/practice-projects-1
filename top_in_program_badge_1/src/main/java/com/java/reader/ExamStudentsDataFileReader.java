package com.java.reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.StudentStudentPortalBean;

public class ExamStudentsDataFileReader {
	public List<StudentStudentPortalBean> readInputsFromFile(String filePath) {
        List<StudentStudentPortalBean> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0].trim().replace("'", "");
                    String program = parts[1].trim().replace("'", "");
                    String month = parts[2].trim().replace("'", "");
                    String year = parts[3].trim().replace("'", "");
                    String programCleared = parts[4].trim().replace("'", "");
                    String cpsId = parts[5].trim().replace("'", "");
                    StudentStudentPortalBean student = new StudentStudentPortalBean();
                    student.setSapid(id);
                    student.setProgram(program);
                    student.setEnrollmentMonth(month);
                    student.setEnrollmentYear(Integer.valueOf(year));
                    student.setProgramCleared(programCleared);
                    student.setConsumerProgramStructureId(Integer.valueOf(cpsId));
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
	}
}
