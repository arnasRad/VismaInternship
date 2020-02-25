package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer;

import javax.persistence.*;

@Entity
public class Citizenship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String countryOfCitizenship;
    @ManyToOne
    private DNBCustomerInfo dnbCustomerInfo;

    public Citizenship() {
    }

    public Citizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }
}
