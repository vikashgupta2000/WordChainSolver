package com.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    String word;
    List<GraphNode> childs;

    public GraphNode(String word) {
        this.word = word;
        childs = new ArrayList<>();
    }

    public String getWord() {
        return this.word;
    }

    public List<GraphNode> getChilds() {
        return this.childs;
    }
}
