package com.codeabra.entities;

public enum Weekday {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    Weekday(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
