package com.android.popmoviespart1.model;

public class Movie {

    private String posterPath;
    private String overview;
    private String releaseDate;
    private String originalTitle;
    private Integer voteCount;
    private Integer voteAverage;

    //public Boolean video;

    //empty Constructor
    public Movie() {
    }

    //Full Constructor
    public Movie(String posterPath, String overview, String releaseDate,
                     String originalTitle, Integer voteCount, Integer voteAverage) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public String getPosterPath(){
        return posterPath;
    }
    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }

    public String getOverview (){
        return overview;
    }
    public void setOverview (String overview){
        this.overview = overview;
    }

    public String getReleaseDate(){
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle(){
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public Integer getVoteCount(){
        return voteCount;
    }
    public void setVoteCount(Integer voteCount){
        this.voteCount = voteCount;
    }

    public Integer getVoteAverage(){
        return voteAverage;
    }
    public void setVoteAverage(Integer voteAverage){
        this.voteAverage = voteAverage;
    }

}
