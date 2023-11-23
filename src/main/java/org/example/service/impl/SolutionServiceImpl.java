package org.example.service.impl;

import org.example.model.FileData;
import org.example.service.SolutionService;

public class SolutionServiceImpl implements SolutionService {

    @Override
    public String getSolution(FileData data) {
        StringBuilder answers = new StringBuilder();
        char[] charsWord = data.getWord().toCharArray();

        int[] mainIndexes = new int[charsWord.length];
        int[] secondaryIndexes = new int[charsWord.length];

        for (int i = 0; i < charsWord.length; i++) {
            if (charsWord[i] == 'A') {
                mainIndexes[i] = i;
                secondaryIndexes[i] = -1;
            } else {
                secondaryIndexes[i] = i;
                mainIndexes[i] = -1;
            }
        }

        for (int[] query : data.getQueries()) {
            int[] mutableMainIndexes = mainIndexes;
            int[] mutableSecondaryIndexes = secondaryIndexes;

            int l = query[0];
            int r = query[1];
            int k = query[2];

            char letter = charsWord[l + k - 2];
            if (letter == 'B') {
                mutableMainIndexes = secondaryIndexes;
                mutableSecondaryIndexes = mainIndexes;
            }

            int entrance = findIndex(mutableMainIndexes, l - 1, l+k-2);
            int match = getMatch(mutableSecondaryIndexes, l-1, r-1, entrance);
            if (match != -1) {
                answers.append(match - l + 2).append(System.lineSeparator());
            } else {
                answers.append(-1).append(System.lineSeparator());
            }
        }
        return answers.toString();
    }

    private int findIndex(int[] indexes, int leftBorder, int key) {
        int counter = -1;
        for (int i = leftBorder; i <= key; i++) {
            if (indexes[i] != -1) {
                counter++;
            }
        }
        return counter;
    }

    private int getMatch(int[] indexes, int leftBorder,  int rightBorder, int entrance) {
        int counter = -1;
        for (int i = leftBorder; i <= rightBorder; i++) {
            if (indexes[i] != -1) {
                counter++;
            }
            if (entrance == counter) {
                return i;
            }
        }
        return -1;
    }

//    @Override
//    public String getSolution(FileData data) {
//        StringBuilder answers = new StringBuilder();
//        char[] charS = data.getWord().toCharArray();
//        for (int[] query : data.getQueries()) {
//            int l = query[0];
//            int r = query[1];
//            int k = query[2];
//
//            int originalK = l + k - 1;
//            char charK = charS[originalK - 1];
//            int x = 0;
//            for (int i = l - 1; i < originalK; i++) {
//                if (charS[i] == charK) {
//                    x++;
//                }
//            }
//            char oppositeChar = charK == 'A' ? 'B' : 'A';
//            for (int i = l - 1; i < r; i++) {
//                if (oppositeChar == charS[i]) {
//                    x--;
//                    if (x == 0) {
//                        answers.append(i - l + 2).append(System.lineSeparator());
//                        break;
//                    }
//                }
//            }
//            if (x != 0) {
//                answers.append(-1).append(System.lineSeparator());
//            }
//        }
//        return answers.toString();
//    }
}
