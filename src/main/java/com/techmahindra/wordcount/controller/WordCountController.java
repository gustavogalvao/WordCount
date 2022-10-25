package com.techmahindra.wordcount.controller;

import com.techmahindra.wordcount.model.WordCount;
import com.techmahindra.wordcount.model.SearchText;
import com.techmahindra.wordcount.service.WordCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// word count controller class
@Slf4j
@RestController
public class WordCountController {
    @Autowired
    WordCountService wordCountService;

    // count the word occurrences on the paragraphs taking the words passing by parameter fo search - task 1
    @PostMapping(path = "counter-api/search", produces = "application/json", consumes = "application/json")
    public @ResponseBody WordCount returnCount(@RequestBody SearchText searchText) {
        WordCount wordCount = new WordCount();
        wordCount.setCounts(wordCountService.countWords(searchText.getSearchText()));
        return wordCount;
    }

    //@RequestMapping(value = "{howMany}", method = RequestMethod.GET, produces = "text/csv"  )
    @GetMapping(path = "counter-api/top/{quantity}", produces = "application/json")
    public @ResponseBody String returnTop(@PathVariable String quantity) {

        int count = 0;
        try {
            count = Integer.parseInt(quantity);
        }
        catch(NumberFormatException nfe) {
            count = 1;
        }

        String wordCount = wordCountService.topWords(count);
        return wordCount;
    }
}
