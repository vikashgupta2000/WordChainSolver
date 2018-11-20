package com.handler;

import com.exception.WordChainException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderHandler {

    public List<String> read (String filePath) throws WordChainException {
        List<String> wordList = new ArrayList<>();
        BufferedReader br = null;
        try {
            String currentLineData;
            br = new BufferedReader(new java.io.FileReader(filePath));
            while ((currentLineData = br.readLine()) != null) {
                wordList.add(currentLineData);
            }
        } catch (IOException e) {
            throw new WordChainException(e);
        }
        finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                throw new WordChainException(ex);
            }
        }
        return wordList;
    }
}
