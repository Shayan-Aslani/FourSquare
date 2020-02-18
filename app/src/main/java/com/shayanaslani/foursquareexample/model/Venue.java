
package com.shayanaslani.foursquareexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue {
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
}
