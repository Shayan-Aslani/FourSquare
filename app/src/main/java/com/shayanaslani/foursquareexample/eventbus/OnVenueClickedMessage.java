package com.shayanaslani.foursquareexample.eventbus;

public class OnVenueClickedMessage {
    private String venueId ;

    public OnVenueClickedMessage(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueId() {
        return venueId;
    }
}
