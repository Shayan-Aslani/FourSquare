package com.shayanaslani.foursquareexample.network.deserializer;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.shayanaslani.foursquareexample.model.Venue;
import com.shayanaslani.foursquareexample.model.VenueListResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VenueListResponseDeserializer implements JsonDeserializer {
    @Override
    public VenueListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject response = json.getAsJsonObject().get("response").getAsJsonObject();
        JsonArray groups = response.get("groups").getAsJsonArray() ;
        JsonArray items = groups.get(0).getAsJsonObject().get("items").getAsJsonArray() ;
        List<Venue> venueList = new ArrayList<>();

        for (JsonElement itemsJsonElement : items) {
            JsonObject venueJsonObject = itemsJsonElement.getAsJsonObject().get("venue").getAsJsonObject();
            Gson gson = new Gson();
            Venue venue = gson.fromJson(venueJsonObject, Venue.class);

            venueList.add(venue);
        }
        Gson gson = new Gson();
        VenueListResponse venueListResponse = gson.fromJson(response, VenueListResponse.class);
        venueListResponse.setVenueList(venueList);

        return venueListResponse;
    }
}
