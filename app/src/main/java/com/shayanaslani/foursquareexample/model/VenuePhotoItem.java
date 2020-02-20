package com.shayanaslani.foursquareexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VenuePhotoItem {

    @Expose
    @SerializedName("visibility")
    private String visibility;
    @Expose
    @SerializedName("tip")
    private Tip tip;
    @Expose
    @SerializedName("user")
    private User user;
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

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public static class Tip {
        @Expose
        @SerializedName("todo")
        private Todo todo;
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
        @SerializedName("likes")
        private Likes likes;
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

        public Todo getTodo() {
            return todo;
        }

        public void setTodo(Todo todo) {
            this.todo = todo;
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

        public Likes getLikes() {
            return likes;
        }

        public void setLikes(Likes likes) {
            this.likes = likes;
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

    public static class Todo {
        @Expose
        @SerializedName("count")
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Likes {
        @Expose
        @SerializedName("summary")
        private String summary;
        @Expose
        @SerializedName("groups")
        private List<String> groups;
        @Expose
        @SerializedName("count")
        private int count;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

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

    public static class User {
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
}

