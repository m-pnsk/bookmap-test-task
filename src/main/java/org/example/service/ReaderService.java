package org.example.service;

import org.example.model.FileData;

public interface ReaderService {
    FileData readFromFile(String filePath);
}
