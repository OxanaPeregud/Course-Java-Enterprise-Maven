package com.peregud.fulltextsearch;

import com.peregud.fulltextsearch.util.SearchUtil;

public class FullTextSearchApp {
    public static void main(String[] args) {
        SearchUtil.saveData();
        SearchUtil.queryOnSingleField();
        SearchUtil.queryOnMultipleFields();
        SearchUtil.wildcardQuery();
        SearchUtil.rangeQuery();
    }
}
