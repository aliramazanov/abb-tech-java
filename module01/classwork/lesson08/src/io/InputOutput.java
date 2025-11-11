package io;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// TODO: Check IO, NIO differences.

public class InputOutput {
    
    static void main () throws IOException {
        
        File input = new File("src/io/input.txt");
        File output = new File("/home/ali/Documents/Codebase/abb-tech-java/module01/classwork/lesson08/src/io/output.txt");
        
        StringBuilder content = new StringBuilder();
        
        try (FileInputStream fileInput = new FileInputStream(input)) {
            int data;
            
            while ((data = fileInput.read()) != -1) {
                content.append((char) data);
            }
        }
        
        try (FileOutputStream fileOutput = new FileOutputStream(output, true)) {
            content.setLength(0);
            content.append("New text");
            fileOutput.write(content.toString().getBytes());
        }
        
        try (FileReader fr = new FileReader(input)){
            int character;
            
            while ((character = fr.read()) != -1) {
                System.out.println((char) character);
            }
        }
        
        Path path = input.toPath();
        Files.readAllLines(path);
        
        String line = Files.readString(path);
        System.out.println(line);
        
        List<String> lines = Files.readAllLines(path);
        System.out.println(lines);
    }
}