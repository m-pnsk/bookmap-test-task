package org.example;

import org.example.model.FileData;
import org.example.service.ReaderService;
import org.example.service.SolutionService;
import org.example.service.WriterService;
import org.example.service.impl.ReaderServiceImpl;
import org.example.service.impl.SolutionServiceImpl;
import org.example.service.impl.WriterServiceImpl;

public class Main {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        FileData fileData = readerService.readFromFile(INPUT_FILE);

        SolutionService solution = new SolutionServiceImpl();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE,
                solution.getSolution(fileData.getWord(), fileData.getQueries()));
    }
}