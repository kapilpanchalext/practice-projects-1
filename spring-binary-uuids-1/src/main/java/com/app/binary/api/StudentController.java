package com.app.binary.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.binary.bean.StudentBean;
import com.app.binary.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> addStudentData(@RequestBody StudentBean student){	
		
		student.setId(student.getId().replace("-", ""));
		System.err.println("STUDENT UUID: " + student);
		service.addStudentData(student);		
		return ResponseEntity.status(HttpStatus.OK).body("Successful!");
	}
	
	@GetMapping(path = "/get-all")
	public ResponseEntity<List<StudentBean>> getAllStudentsList() {
		List<StudentBean> studentsList = service.getAllStudentsList();		
		return ResponseEntity.status(HttpStatus.OK).body(studentsList);
	}
	
	@GetMapping(path = "/get-student")
	public ResponseEntity<StudentBean> getStudentDataByName(@RequestBody StudentBean student){
		StudentBean studentStatus = service.getStudentDataByName(student);
		return ResponseEntity.status(HttpStatus.OK).body(studentStatus);
	}
	
//	@GetMapping(path = "/binary")
//	public ResponseEntity<String> convertUUIDToBinary(@RequestBody StudentBean student){
//		System.err.println("UUID: " + student.getId());
//		final String normalizedUUIDHexString = student.getId().replace("-", "");
//
//        assert normalizedUUIDHexString.length() == 32;
//		
//        System.err.println("UUID HEX: " + normalizedUUIDHexString);
//        
//        final byte[] bytes = new byte[16];
//        for (int i = 0; i < 16; i++) {
//            final byte b = hexToByte(normalizedUUIDHexString.substring(i * 2, i * 2 + 2));            
//            bytes[i] = b;
//            System.err.println("CONVERSION: " + b);
//        }
//        
//        System.err.println("Bytes array: " + Arrays.toString(bytes));
//        
//		
//        StringBuilder formattedString = new StringBuilder();
//        for (byte b : bytes) {
//            // Convert each byte to a two-character hexadecimal string
//            String hex = String.format("%02X", b);
//            // Append it to the formattedString
//            formattedString.append(hex);
//        }
//
//        // Print the formatted string
//        System.err.println("Formatted string: " + formattedString.toString());
//        
//        
//        return ResponseEntity.status(HttpStatus.OK).body("Successful");
//		
//		
//	}
//	
//	public static byte hexToByte(String hexString) {
//        final int firstDigit = Character.digit(hexString.charAt(0), 16);
//        final int secondDigit = Character.digit(hexString.charAt(1), 16);
//        return (byte) ((firstDigit << 4) + secondDigit);
//    }
}
