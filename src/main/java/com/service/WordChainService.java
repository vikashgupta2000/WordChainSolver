package com.service;

import java.util.List;
import java.util.Set;

public interface WordChainService {
    List<String> evaluate(String startWord, String endWord, Set<String> wordList);
}
