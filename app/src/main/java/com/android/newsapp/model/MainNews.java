package com.android.newsapp.model;

import java.util.ArrayList;

public class MainNews {

    private String status;
    private int totalResults;
    private ArrayList<Headlines> articles;


    public MainNews(String status, int totalResults, ArrayList<Headlines> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Headlines> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Headlines> articles) {
        this.articles = articles;
    }
}

