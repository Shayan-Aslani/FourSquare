package com.shayanaslani.foursquareexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FourSquareJSON {

    @Expose
    @SerializedName("response")
    private Response response;
    @Expose
    @SerializedName("meta")
    private Meta meta;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Response {
        @Expose
        @SerializedName("groups")
        private List<Groups> groups;
        @Expose
        @SerializedName("suggestedBounds")
        private SuggestedBounds suggestedBounds;
        @Expose
        @SerializedName("totalResults")
        private int totalResults;
        @Expose
        @SerializedName("headerLocationGranularity")
        private String headerLocationGranularity;
        @Expose
        @SerializedName("headerFullLocation")
        private String headerFullLocation;
        @Expose
        @SerializedName("headerLocation")
        private String headerLocation;
        @Expose
        @SerializedName("suggestedRadius")
        private int suggestedRadius;
        @Expose
        @SerializedName("suggestedFilters")
        private SuggestedFilters suggestedFilters;

        public List<Groups> getGroups() {
            return groups;
        }

        public void setGroups(List<Groups> groups) {
            this.groups = groups;
        }

        public SuggestedBounds getSuggestedBounds() {
            return suggestedBounds;
        }

        public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
            this.suggestedBounds = suggestedBounds;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public String getHeaderLocationGranularity() {
            return headerLocationGranularity;
        }

        public void setHeaderLocationGranularity(String headerLocationGranularity) {
            this.headerLocationGranularity = headerLocationGranularity;
        }

        public String getHeaderFullLocation() {
            return headerFullLocation;
        }

        public void setHeaderFullLocation(String headerFullLocation) {
            this.headerFullLocation = headerFullLocation;
        }

        public String getHeaderLocation() {
            return headerLocation;
        }

        public void setHeaderLocation(String headerLocation) {
            this.headerLocation = headerLocation;
        }

        public int getSuggestedRadius() {
            return suggestedRadius;
        }

        public void setSuggestedRadius(int suggestedRadius) {
            this.suggestedRadius = suggestedRadius;
        }

        public SuggestedFilters getSuggestedFilters() {
            return suggestedFilters;
        }

        public void setSuggestedFilters(SuggestedFilters suggestedFilters) {
            this.suggestedFilters = suggestedFilters;
        }
    }

    public static class Groups {
        @Expose
        @SerializedName("items")
        private List<Items> items;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("type")
        private String type;

        public List<Items> getItems() {
            return items;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Items {
        @Expose
        @SerializedName("referralId")
        private String referralId;
        @Expose
        @SerializedName("venue")
        private Venue venue;
        @Expose
        @SerializedName("reasons")
        private Reasons reasons;

        public String getReferralId() {
            return referralId;
        }

        public void setReferralId(String referralId) {
            this.referralId = referralId;
        }

        public Venue getVenue() {
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

        public Reasons getReasons() {
            return reasons;
        }

        public void setReasons(Reasons reasons) {
            this.reasons = reasons;
        }
    }

    public static class Venue {
        @Expose
        @SerializedName("photos")
        private Photos photos;
        @Expose
        @SerializedName("categories")
        private List<Categories> categories;
        @Expose
        @SerializedName("location")
        private Location location;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

        public Photos getPhotos() {
            return photos;
        }

        public void setPhotos(Photos photos) {
            this.photos = photos;
        }

        public List<Categories> getCategories() {
            return categories;
        }

        public void setCategories(List<Categories> categories) {
            this.categories = categories;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Photos {
        @Expose
        @SerializedName("groups")
        private List<String> groups;
        @Expose
        @SerializedName("count")
        private int count;

        public List<String> getGroups() {
            return groups;
        }

        public void setGroups(List<String> groups) {
            this.groups = groups;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Categories {
        @Expose
        @SerializedName("primary")
        private boolean primary;
        @Expose
        @SerializedName("icon")
        private Icon icon;
        @Expose
        @SerializedName("shortName")
        private String shortName;
        @Expose
        @SerializedName("pluralName")
        private String pluralName;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

        public boolean getPrimary() {
            return primary;
        }

        public void setPrimary(boolean primary) {
            this.primary = primary;
        }

        public Icon getIcon() {
            return icon;
        }

        public void setIcon(Icon icon) {
            this.icon = icon;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getPluralName() {
            return pluralName;
        }

        public void setPluralName(String pluralName) {
            this.pluralName = pluralName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Icon {
        @Expose
        @SerializedName("suffix")
        private String suffix;
        @Expose
        @SerializedName("prefix")
        private String prefix;

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }

    public static class Location {
        @Expose
        @SerializedName("formattedAddress")
        private List<String> formattedAddress;
        @Expose
        @SerializedName("country")
        private String country;
        @Expose
        @SerializedName("state")
        private String state;
        @Expose
        @SerializedName("city")
        private String city;
        @Expose
        @SerializedName("cc")
        private String cc;
        @Expose
        @SerializedName("postalCode")
        private String postalCode;
        @Expose
        @SerializedName("distance")
        private int distance;
        @Expose
        @SerializedName("labeledLatLngs")
        private List<LabeledLatLngs> labeledLatLngs;
        @Expose
        @SerializedName("lng")
        private double lng;
        @Expose
        @SerializedName("lat")
        private double lat;
        @Expose
        @SerializedName("crossStreet")
        private String crossStreet;
        @Expose
        @SerializedName("address")
        private String address;

        public List<String> getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(List<String> formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public List<LabeledLatLngs> getLabeledLatLngs() {
            return labeledLatLngs;
        }

        public void setLabeledLatLngs(List<LabeledLatLngs> labeledLatLngs) {
            this.labeledLatLngs = labeledLatLngs;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getCrossStreet() {
            return crossStreet;
        }

        public void setCrossStreet(String crossStreet) {
            this.crossStreet = crossStreet;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class LabeledLatLngs {
        @Expose
        @SerializedName("lng")
        private double lng;
        @Expose
        @SerializedName("lat")
        private double lat;
        @Expose
        @SerializedName("label")
        private String label;

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class Reasons {
        @Expose
        @SerializedName("items")
        private List<ReasonsItems> items;
        @Expose
        @SerializedName("count")
        private int count;

        public List<ReasonsItems> getItems() {
            return items;
        }

        public void setItems(List<ReasonsItems> items) {
            this.items = items;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class ReasonsItems {
        @Expose
        @SerializedName("reasonName")
        private String reasonName;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("summary")
        private String summary;

        public String getReasonName() {
            return reasonName;
        }

        public void setReasonName(String reasonName) {
            this.reasonName = reasonName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }

    public static class SuggestedBounds {
        @Expose
        @SerializedName("sw")
        private Sw sw;
        @Expose
        @SerializedName("ne")
        private Ne ne;

        public Sw getSw() {
            return sw;
        }

        public void setSw(Sw sw) {
            this.sw = sw;
        }

        public Ne getNe() {
            return ne;
        }

        public void setNe(Ne ne) {
            this.ne = ne;
        }
    }

    public static class Sw {
        @Expose
        @SerializedName("lng")
        private double lng;
        @Expose
        @SerializedName("lat")
        private double lat;

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }

    public static class Ne {
        @Expose
        @SerializedName("lng")
        private double lng;
        @Expose
        @SerializedName("lat")
        private double lat;

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }

    public static class SuggestedFilters {
        @Expose
        @SerializedName("filters")
        private List<Filters> filters;
        @Expose
        @SerializedName("header")
        private String header;

        public List<Filters> getFilters() {
            return filters;
        }

        public void setFilters(List<Filters> filters) {
            this.filters = filters;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }

    public static class Filters {
        @Expose
        @SerializedName("key")
        private String key;
        @Expose
        @SerializedName("name")
        private String name;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Meta {
        @Expose
        @SerializedName("requestId")
        private String requestId;
        @Expose
        @SerializedName("code")
        private int code;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
