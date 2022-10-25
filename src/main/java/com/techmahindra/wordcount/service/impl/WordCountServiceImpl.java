package com.techmahindra.wordcount.service.impl;

import com.techmahindra.wordcount.service.WordCountService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class WordCountServiceImpl implements WordCountService {

    private static final TreeMap<String,Integer> wordsCountMap = new TreeMap<>();							//Map with the word as the key and the count as the value

    private static final List<String> wordsCountOccurrence = new ArrayList<>();

    public WordCountServiceImpl() throws Exception {
        if (wordsCountMap.isEmpty())
            populateCount();
    }

    // method responsible dor the task 1
    public Map<String,Integer>[] countWords(List<String> words) {

        List<Map<String, Integer>> list = new ArrayList<>();
        int number = 0;

        for (String word : words) {
            HashMap<String,Integer> countMap = new HashMap<>();
            word = word.toLowerCase();

            if (wordsCountMap.containsKey(word))
                number = wordsCountMap.get(word);
            else
                number = 0;

            countMap.put(StringUtils.capitalize(word),number);
            list.add(countMap);
        }

        return list.toArray(new HashMap[list.size()]);
    }

    // method responsible dor the task 2
    public String topWords(Integer topItems) {
        buildTopWords();

        int index = 0;
        StringBuilder resultBuffer = new StringBuilder();
        if(topItems < 1)
            return resultBuffer.toString();

        for(String temp : wordsCountOccurrence) {
            resultBuffer.append(temp);
            index++;
            if (index >= topItems) {
                return resultBuffer.toString();
            }
        }

        return resultBuffer.toString();
    }

    //method responsible to build top words
    public static void buildTopWords() {

        List<Map.Entry<String, Integer>> tempList = new ArrayList<>(wordsCountMap.entrySet());

        tempList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String,Integer> temp : tempList) {
            wordsCountOccurrence.add(temp.getValue() + "|" + temp.getKey() + "\r\n");
        }
    }

    // method responsible for populate the file into a map
    private void  populateCount() throws Exception  {
        InputStream input = getClass().getClassLoader().getResourceAsStream("sample_paragraphs.txt");
        if(input==null)
            throw new Exception("File sample_paragraphs.txt not found");

        int count = 0;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            String[] words;
            while (line != null) {
                words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordsCountMap.containsKey(word)) {
                        count = wordsCountMap.get(word) +1;
                    }
                    else {
                        count =1;
                    }
                    wordsCountMap.put(word, count);
                }
                line = reader.readLine();
            }
        }
        catch(Exception e) {
            throw new Exception("exception " + e.getMessage());
        }
    }
}
