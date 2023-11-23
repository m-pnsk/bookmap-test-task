package org.example.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.example.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFromFile(String filePath) {
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
