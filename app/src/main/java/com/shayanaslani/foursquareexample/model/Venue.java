
package com.shayanaslani.foursquareexample.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shayanaslani.foursquareexample.database.FoursquareTypeConverters;

import java.util.List;

@Entity(tableName = "venue")
@TypeConverters(FoursquareTypeConverters.class)
public class Venue {
    @PrimaryKey(autoGenerate = true)
    private int roomId;
    @Ignore
    @SerializedName("photos")
    private Photos photos;
    @Embedded
    @SerializedName("location")
    private Location location;
    @SerializedName("categories")
    private List<Categories> categories;
    @Ignore
    @SerializedName("contact")
    private Contact contact;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @Ignore
    @SerializedName("likes")
    private Likes likes;
    @Ignore
    @SerializedName("tips")
    private Tips tips;
    @SerializedName("rating")
    private String rating;
    @SerializedName("ratingColor")
    private String ratingColor;

    public Tips getTips() {
        return tips;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public static class Photos {
        @SerializedName("groups")
        private List<Groups> groups;
        @SerializedName("count")
        private int count;

        public List<Groups> getGroups() {
            return groups;
        }

        public void setGroups(List<Groups> groups) {
            this.groups = groups;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Groups {

        @Expose
        @SerializedName("items")
        private List<PhotoItems> items;
        @Expose
        @SerializedName("count")
        private int count;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("type")
        private String type;

        public List<PhotoItems> getItems() {
            return items;
        }

        public void setItems(List<PhotoItems> items) {
            this.items = items;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
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

    public static class PhotoItems {
        @Expose
        @SerializedName("visibility")
        private String visibility;
        @Expose
        @SerializedName("height")
        private int height;
        @Expose
        @SerializedName("width")
        private int width;
        @Expose
        @SerializedName("suffix")
        private String suffix;
        @Expose
        @SerializedName("prefix")
        private String prefix;
        @Expose
        @SerializedName("source")
        private Source source;
        @Expose
        @SerializedName("createdAt")
        private int createdAt;
        @Expose
        @SerializedName("id")
        private String id;

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

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

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public int getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(int createdAt) {
            this.createdAt = createdAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Source {
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("name")
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Location {
        public Location() {
        }

        @Ignore
        @SerializedName("formattedAddress")
        private List<String> formattedAddress;
        @Ignore
        @SerializedName("country")
        private String country;
        @Ignore
        @SerializedName("state")
        private String state;
        @Ignore
        @SerializedName("city")
        private String city;
        @Ignore
        @SerializedName("cc")
        private String cc;
        @Ignore
        @SerializedName("labeledLatLngs")
        private List<LabeledLatLngs> labeledLatLngs;
        @Ignore
        @SerializedName("lng")
        private double lng;
        @Ignore
        @SerializedName("lat")
        private double lat;
        @Ignore
        @SerializedName("crossStreet")
        private String crossStreet;
        @Ignore
        @SerializedName("address")
        private String address;
        @SerializedName("distance")
        private String distance;

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }


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
        public LabeledLatLngs() {
        }

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

    public static class Contact {
        @Expose
        @SerializedName("twitter")
        private String twitter;
        @Expose
        @SerializedName("formattedPhone")
        private String formattedPhone;
        @Expose
        @SerializedName("phone")
        private String phone;

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getFormattedPhone() {
            return formattedPhone;
        }

        public void setFormattedPhone(String formattedPhone) {
            this.formattedPhone = formattedPhone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class Categories {
        @SerializedName("primary")
        private boolean primary;
        @SerializedName("icon")
        private Icon icon;
        @SerializedName("shortName")
        private String shortName;
        @SerializedName("pluralName")
        private String pluralName;
        @SerializedName("name")
        private String name;
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
        @SerializedName("suffix")
        private String suffix;
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

    public static class Likes {
        @SerializedName("summary")
        private String summary;
        @SerializedName("count")
        private int count;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Tips {
        @SerializedName("groups")
        private List<Groups> groups;
        @SerializedName("count")
        private int count;

        public List<Groups> getGroups() {
            return groups;
        }

        public void setGroups(List<Groups> groups) {
            this.groups = groups;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public static class Groups {
            @Expose
            @SerializedName("items")
            private List<Items> items;
            @Expose
            @SerializedName("count")
            private int count;
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
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
            @SerializedName("authorInteractionType")
            private String authorInteractionType;
            @Expose
            @SerializedName("user")
            private User user;
            @Expose
            @SerializedName("disagreeCount")
            private int disagreeCount;
            @Expose
            @SerializedName("agreeCount")
            private int agreeCount;
            @Expose
            @SerializedName("logView")
            private boolean logView;
            @Expose
            @SerializedName("lang")
            private String lang;
            @Expose
            @SerializedName("canonicalUrl")
            private String canonicalUrl;
            @Expose
            @SerializedName("type")
            private String type;
            @Expose
            @SerializedName("text")
            private String text;
            @Expose
            @SerializedName("createdAt")
            private int createdAt;
            @Expose
            @SerializedName("id")
            private String id;

            public String getAuthorInteractionType() {
                return authorInteractionType;
            }

            public void setAuthorInteractionType(String authorInteractionType) {
                this.authorInteractionType = authorInteractionType;
            }

            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }

            public int getDisagreeCount() {
                return disagreeCount;
            }

            public void setDisagreeCount(int disagreeCount) {
                this.disagreeCount = disagreeCount;
            }

            public int getAgreeCount() {
                return agreeCount;
            }

            public void setAgreeCount(int agreeCount) {
                this.agreeCount = agreeCount;
            }

            public boolean getLogView() {
                return logView;
            }

            public void setLogView(boolean logView) {
                this.logView = logView;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getCanonicalUrl() {
                return canonicalUrl;
            }

            public void setCanonicalUrl(String canonicalUrl) {
                this.canonicalUrl = canonicalUrl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(int createdAt) {
                this.createdAt = createdAt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class User {
            public User() {
            }

            @Expose
            @SerializedName("photo")
            private Photo photo;
            @Expose
            @SerializedName("lastName")
            private String lastName;
            @Expose
            @SerializedName("firstName")
            private String firstName;
            @Expose
            @SerializedName("id")
            private String id;

            public Photo getPhoto() {
                return photo;
            }

            public void setPhoto(Photo photo) {
                this.photo = photo;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class Photo {
            public Photo() {
            }

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
    }
}
