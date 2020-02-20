package com.shayanaslani.foursquareexample.network.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.shayanaslani.foursquareexample.model.VenuePhotoItem;

import java.lang.reflect.Type;
import java.util.List;

public class VenuePhotosDeserializer implements JsonDeserializer {
    @Override
    public List<VenuePhotoItem> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject response = json.getAsJsonObject().get("response").getAsJsonObject();
        JsonObject photos = response.get("photos").getAsJsonObject();
        JsonArray items = photos.get("items").getAsJsonArray();

        Type type = new TypeToken<List<VenuePhotoItem>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(items, type);
    }
}
