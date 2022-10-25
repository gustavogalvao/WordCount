package com.techmahindra.wordcount.model;

import lombok.Data;

import java.util.List;

// list of words request body encapsulation json
@Data
public class SearchText {

    private List<String> searchText;

    public SearchText() {}
}
