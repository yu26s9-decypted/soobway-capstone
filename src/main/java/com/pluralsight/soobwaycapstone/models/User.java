package com.pluralsight.soobwaycapstone.models;

public class User {
    String uuid;
    String username;
    String joinedAt;
    String membershipTier;

    public User(String uuid, String username, String joinedAt, String membershipTier) {
        this.uuid = uuid;
        this.username = username;
        this.joinedAt = joinedAt;
        this.membershipTier = membershipTier;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }

    public void setJoinedAt(String createdAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", joinedAt='" + joinedAt + '\'' +
                '}';
    }


}



