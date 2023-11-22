package org.example.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.model.FileData;
import org.example.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public FileData readFromFile(String filePath) {
        String word = null;
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String s = br.readLine();
            String[] wordLengthAndNumOfQueries = s.split(" ");
            StringBuilder sb = new StringBuilder();
            int wordLength = Integer.parseInt(wordLengthAndNumOfQueries[0]);
            word = br.readLine().substring(0, wordLength);
            for (int i = 0; i < Integer.parseInt(wordLengthAndNumOfQueries[1]); i++) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileData(word, list);
    }
}
