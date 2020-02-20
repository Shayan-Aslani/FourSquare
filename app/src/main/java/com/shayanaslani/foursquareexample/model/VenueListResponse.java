package com.shayanaslani.foursquareexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VenueListResponse {
    @SerializedName("warning")
    private String warning ;

    @SerializedName("totalResults")
    private int totalResults ;

    private List<Venue> venueList ;

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Venue> getVenueList() {
        return venueList;
    }

    public void setVenueList(List<Venue> venueList) {
        this.venueList = venueList;
    }
}
