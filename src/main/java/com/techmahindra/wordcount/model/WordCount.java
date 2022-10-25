package com.techmahindra.wordcount.model;

import lombok.Data;

import java.util.Map;

// class responsible for encapsulating search results json
@Data
public class WordCount {
    public WordCount() {
    }

    Map<String,Integer>[] counts;
}
