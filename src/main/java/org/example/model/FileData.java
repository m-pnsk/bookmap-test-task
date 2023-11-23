package org.example.model;

public class FileData {
    private String word;
    private int[][] queries;

    public String getWord() {
        return word;
    }

    public int[][] getQueries() {
        return queries;
    }

    public FileData(String word, int[][] queries) {
        this.word = word;
        this.queries = queries;
    }
}
