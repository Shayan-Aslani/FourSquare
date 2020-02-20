package com.shayanaslani.foursquareexample.network.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.shayanaslani.foursquareexample.model.Venue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VenueListDeserializer implements JsonDeserializer {
    @Override
    public List deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        List<Venue> venues = new ArrayList();
        JsonObject response = jsonObject.get("response").getAsJsonObject();
        JsonArray groups = response.get("groups").getAsJsonArray();
        JsonArray items = groups.get(0).getAsJsonObject().get("items").getAsJsonArray();

        for (JsonElement itemsJsonElement : items) {
            JsonObject venueJsonObject = itemsJsonElement.getAsJsonObject().get("venue").getAsJsonObject();

            Gson gson = new Gson();
            Venue venue = gson.fromJson(venueJsonObject, Venue.class);

            venues.add(venue);
        }
        return venues;
    }
}
