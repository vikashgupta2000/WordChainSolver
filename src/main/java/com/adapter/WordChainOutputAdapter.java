package com.adapter;

import com.service.WordChainService;
import com.singleton.WordListSingleton;

import java.util.List;
import java.util.Set;

public class WordChainOutputAdapter {
    private WordChainService wordChainService;
    private WordListSingleton wordListSingleton;
    public WordChainOutputAdapter(WordChainService wordChainService) {
        this.wordChainService = wordChainService;
        this.wordListSingleton = WordListSingleton.getInstance();
    }

    public void processWordRelation(List<String> wordRelationList) {
        for(String word : wordRelationList) {
            String[] wordArray = word.split(" ");
            final String startWord = wordArray[0].toLowerCase();
            final String endWord = wordArray[1].toLowerCase();
            Set<String> wordList = wordListSingleton.getWordOfLength(startWord.length());
            List<String> output = wordChainService.evaluate(startWord, endWord, wordList);
            printData(output);
        }
    }

    private void printData(List<String> dataSet) {
        if (null == dataSet || dataSet.size() == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES  =>  " + dataSet);
        }
    }
}
