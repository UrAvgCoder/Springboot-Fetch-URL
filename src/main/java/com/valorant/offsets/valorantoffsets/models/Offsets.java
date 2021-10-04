package com.valorant.offsets.valorantoffsets.models;

public class Offsets {
    private String lastUpdated;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String toString() {
        return "Offsets{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
