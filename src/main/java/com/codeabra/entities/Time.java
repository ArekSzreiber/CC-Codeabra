package com.codeabra.entities;

public enum Time {

    TEN ("10.00"),
    TWELVE ("12.00"),
    FOURTEEN("14.00"),
    SIXTEEN("16.00"),
    EIGHTEEN("18.00"),
    TWENTY("20.00");

    private final String hour;

    Time(String hour) {
        this.hour = hour;
    }

    public String getTime() {
        return hour;
    }

}
