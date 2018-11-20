package com.service.impl;

import com.model.GraphNode;
import com.service.WordChainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordChainServiceImpl implements WordChainService{

    private boolean isNextWord(String actualWord, String nextWord) {
        int count = 0;
        String[] actualWordArr = actualWord.split("");
        String[] nextWordArr = nextWord.split("");
        for(int index=0; index< actualWord.length(); index++) {
            if (!actualWordArr[index].equals(nextWordArr[index])) {
                ++count;
            }
        }
        return count == 1;
    }

    private Map<String, GraphNode> createGraph(Set<String> wordListSet) {
        List<String> wordList = new ArrayList<>(wordListSet);
        Map<String, GraphNode> nodeGraph = new HashMap<>();
        for(String word : wordList) {
            nodeGraph.put(word, new GraphNode(word));
        }
        for(int index=0; index<wordListSet.size()-1; index++) {
            for(int nextIndex=index+1; nextIndex<wordListSet.size(); nextIndex++) {
                if(isNextWord(wordList.get(index), wordList.get(nextIndex))) {
                    nodeGraph.get(wordList.get(index)).getChilds().add(nodeGraph.get(wordList.get(nextIndex)));
                    nodeGraph.get(wordList.get(nextIndex)).getChilds().add(nodeGraph.get(wordList.get(index)));
                }
            }
        }
        return nodeGraph;
    }

    @Override
    public List<String> evaluate(String startWord, String endWord, Set<String> wordList) {
        if(wordList.contains(endWord)) {
            Map<String, GraphNode> graph = createGraph(wordList);
            Map<String, Integer> visitedNodeIndicator = new HashMap();
            Map<String, List<String>> wordToVisitedPathMap = new HashMap();

            for (final String key : graph.keySet()) {
                visitedNodeIndicator.put(key, 0);
                wordToVisitedPathMap.put(key, new ArrayList<String>() {{ add(key); }});
            }
            List<String> nodeNameList = new ArrayList<>();
            nodeNameList.add(startWord);
            visitedNodeIndicator.put(startWord, 1);
            boolean breakFlag = false;
            while (!nodeNameList.isEmpty()) {
                String queueData = nodeNameList.remove(0);
                GraphNode graphNode = graph.get(queueData);
                for(GraphNode graphNodeChild : graphNode.getChilds()) {
                    if (visitedNodeIndicator.get(graphNodeChild.getWord()) == 0) {
                        visitedNodeIndicator.put(graphNodeChild.getWord(), 1);

                        List<String> wordRelationsPath = new ArrayList<>();
                        wordRelationsPath.addAll(wordToVisitedPathMap.get(queueData));
                        wordRelationsPath.add(graphNodeChild.getWord());

                        wordToVisitedPathMap.put(graphNodeChild.getWord(), wordRelationsPath);
                        nodeNameList.add(graphNodeChild.getWord());
                    }
                    if(graphNodeChild.getWord().equals(endWord)) {
                        breakFlag = true;
                        break;
                    }
                }
                if(breakFlag) {
                    return wordToVisitedPathMap.get(endWord);
                }
            }
        }
        return null;
    }
}
