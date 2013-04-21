package com.milespomeroy.tweettest.core;

import java.util.List;

public class TwitterSearchResponse {
    private List<Tweet> results;

    public List<Tweet> getResults() {
        return results;
    }

    public void setResults(List<Tweet> results) {
        this.results = results;
    }
}
