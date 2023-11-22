package org.example.service.impl;

import java.util.List;
import org.example.service.SolutionService;

public class SolutionServiceImpl implements SolutionService {
    @Override
    public String getSolution(String s, List<String> queries) {
        StringBuilder answers = new StringBuilder();
        char[] charS = s.toCharArray();
        for (String query : queries) {
            String[] queryParameters = query.split(" ");
            int l = Integer.parseInt(queryParameters[0]);
            int r = Integer.parseInt(queryParameters[1]);
            int k = Integer.parseInt(queryParameters[2]);

            int originalK = l + k - 1;
            char charK = charS[originalK - 1];
            int x = 0;
            for (int i = l - 1; i < originalK; i++) {
                if (charS[i] == charK) {
                    x++;
                }
            }
            char oppositeChar = getOpposite(charK);
            for (int i = l - 1; i < r; i++) {
                if (oppositeChar == charS[i]) {
                    x--;
                    if (x == 0) {
                        answers.append(i - l + 2).append(System.lineSeparator());
                        break;
                    }
                }
            }
            if (x != 0) {
                answers.append(-1).append(System.lineSeparator());
            }
        }
        return answers.toString();
    }

    private char getOpposite(char c) {
        if (c == 'A') {
            return 'B';
        }
        return 'A';
    }
}
