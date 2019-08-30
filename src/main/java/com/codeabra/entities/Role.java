package com.codeabra.entities;

public enum Role {
    LEADER("Leader"),
    FOLLOWER("Follower");

    Role(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
