package com.arnasrad.vismainternship.model.entity.customer;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postalCode;
    private String addressLine1;

    public CustomerAddress() {
    }

    public CustomerAddress(String postalCode, String addressLine1) {
        this.postalCode = postalCode;
        this.addressLine1 = addressLine1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
}
