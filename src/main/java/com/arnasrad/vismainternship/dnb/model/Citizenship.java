package com.arnasrad.vismainternship.dnb.model;

public class Citizenship {

    private String countryOfCitizenship;

    public Citizenship() {
    }

    public Citizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }
}
