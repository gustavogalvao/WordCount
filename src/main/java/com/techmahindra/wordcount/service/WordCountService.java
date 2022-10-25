package com.techmahindra.wordcount.service;

import java.util.List;
import java.util.Map;

public interface WordCountService {

    Map<String,Integer>[] countWords(List<String> words);

    String topWords(Integer topItems );
}
