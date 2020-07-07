package com.android.popmoviespart1.model;

import java.util.List;

public class MovieList {

    private List<String> results = null;
    private String posterPath;
    private Integer totalResults;
    private Integer totalPages;

    //empty Constructor
    public MovieList() {
    }

    //Full Constructor
    public MovieList(List<String> results, String posterPath, Integer totalResults, Integer totalPages) {
        this.results = results;
        this.posterPath = posterPath;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public List<String> getResults(){
        return results;
    }
    public void setResults(List<String> results){
        this.results = results;
    }

    public String getPosterPath(){
        return posterPath;
    }
    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
