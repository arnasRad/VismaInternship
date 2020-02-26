package com.arnasrad.vismainternship.model.entity.counterparty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Counterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String counterpartyId;
    private String country;
    private String name;
    private String phone;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CounterpartyAccount> accounts;
    private String profileType;
    private String state;
    private Date createdAt;
    private Date updatedAt;

    public Counterparty() {
    }

    public Counterparty(String counterpartyId, String country, String name, String phone, List<CounterpartyAccount> accounts, String profileType, String state, Date createdAt, Date updatedAt) {
        this.counterpartyId = counterpartyId;
        this.country = country;
        this.name = name;
        this.phone = phone;
        this.accounts = accounts;
        this.profileType = profileType;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CounterpartyAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CounterpartyAccount> accounts) {
        this.accounts = accounts;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
