package com.java.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> listOfLogs = new ArrayList<>();
		try (FileInputStream inputStream = new FileInputStream("files/input.csv")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.err.print((char) data);
                listOfLogs.add(String.valueOf((char)data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example of writing to a file using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream("files/output.txt")) {
            String content = "Hello, this is an example of file output stream.";
            byte[] contentBytes = content.getBytes();
            byte[] contentBytesNew = listOfLogs.toString().getBytes();
            outputStream.write(contentBytes);
            outputStream.write('\n');
            outputStream.write(contentBytesNew);

            System.err.println("\nData has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}