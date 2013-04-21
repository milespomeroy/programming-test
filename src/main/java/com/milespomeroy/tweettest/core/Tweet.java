package com.milespomeroy.tweettest.core;

import com.yammer.dropwizard.json.JsonSnakeCase;

@JsonSnakeCase
public class Tweet {
    private String fromUser;
    private String text;
    private String profileImageUrl;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
