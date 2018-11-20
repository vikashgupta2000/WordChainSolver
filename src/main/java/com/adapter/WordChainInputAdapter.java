package com.adapter;

import com.singleton.WordListSingleton;

import java.util.List;

public class WordChainInputAdapter {
    private WordListSingleton wordListSingleton;
    public WordChainInputAdapter() {
        this.wordListSingleton = WordListSingleton.getInstance();
    }

    private boolean insertData(String word) {
        String updatedWord = word.trim().toLowerCase();
        return wordListSingleton.addWord(updatedWord);
    }

    public void insertData(List<String> wordList) {
        for (String word : wordList) {
            insertData(word);
        }
    }
}
