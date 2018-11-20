package com.singleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Singleton is just for storing data.
 * Making sure that there is only one instance of the class
 */
public class WordListSingleton {
    private WordListSingleton(){}
    private static WordListSingleton wordListSingleton;
    private Map<Integer,Set<String>> data = new HashMap<>();

    public static WordListSingleton getInstance() {
        if(null == wordListSingleton) {
            synchronized (WordListSingleton.class) {
                if(null == wordListSingleton) {
                    wordListSingleton = new WordListSingleton();
                }
            }
        }
        return wordListSingleton;
    }

    public boolean addWord(String word) {
        int wordCount = word.length();
        if (!data.containsKey(wordCount)) {
            Set<String> uniqueData = new HashSet<>();
            data.put(wordCount, uniqueData);
        }
        return data.get(wordCount).add(word);
    }

    public Set<String> getWordOfLength(int wordLength) {
        return data.get(wordLength);
    }
}
