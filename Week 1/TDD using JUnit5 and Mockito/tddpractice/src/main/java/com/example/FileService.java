package com.example;
public class FileService {
    private final FileReader fileReader;
    @SuppressWarnings("unused")
    private final FileWriter fileWriter;

    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public String processFile() {
        return "Processed " + fileReader.read();
    }
}