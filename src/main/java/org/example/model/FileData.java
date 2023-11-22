package org.example.model;

import java.util.List;

public class FileData {
    private String word;
    private List<String> queries;

    public String getWord() {
        return word;
    }

    public List<String> getQueries() {
        return queries;
    }

    public FileData(String word, List<String> queries) {
        this.word = word;
        this.queries = queries;
    }
}
