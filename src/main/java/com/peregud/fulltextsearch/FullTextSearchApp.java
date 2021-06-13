package com.peregud.fulltextsearch;

import com.peregud.fulltextsearch.util.SearchUtil;

public class FullTextSearchApp {
    public static void main(String[] args) {
        SearchUtil.saveData();
        SearchUtil.queryOnSingleField().forEach(System.out::println);
        SearchUtil.queryOnMultipleFields().forEach(System.out::println);
        SearchUtil.wildcardQuery().forEach(System.out::println);
        SearchUtil.rangeQuery().forEach(System.out::println);
        SearchUtil.projectionWithTransformer().forEach(System.out::println);
        System.out.println(SearchUtil.projection());
    }
}
