package org.example.service.impl;

import org.example.model.FileData;
import org.example.service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int CAPACITY_PARAMETER_INDEX = 0;
    private static final int WORD_INDEX = 1;
    private static final int FIRST_QUERY_INDEX = 2;
    private static final int WORD_LENGTH_INDEX = 0;
    private static final int QUERIES_COUNT_INDEX = 1;
    private static final int QUERY_SIZE = 3;

    @Override
    public FileData parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        String[] wordAndQueriesSizes = lines[CAPACITY_PARAMETER_INDEX].split(" ");
        String word = lines[WORD_INDEX].substring(0, Integer.parseInt(wordAndQueriesSizes[WORD_LENGTH_INDEX]));
        int numOfQueries = Integer.parseInt(wordAndQueriesSizes[QUERIES_COUNT_INDEX]);

        int[][] queries = new int[numOfQueries][QUERY_SIZE];
        for (int i = 0; i < numOfQueries; i++) {
            String[] query = lines[FIRST_QUERY_INDEX + i].split(" ");
            for (int j = 0; j < QUERY_SIZE; j++) {
                queries[i][j] = Integer.parseInt(query[j]);
            }
        }
        return new FileData(word, queries);
    }
}
