package org.example.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.example.service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
