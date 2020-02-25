package com.arnasrad.vismainternship.model.entity.counterparty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Counterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String counterpartyId;
    private String country;
    private String name;
    private String phone;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CounterpartyAccount> accounts;

    public Counterparty() {
    }

    public Counterparty(String country, String counterpartyId, String name, String phone,
                        List<? extends CounterpartyAccount> accounts) {
        this.country = country;
        this.counterpartyId = counterpartyId;
        this.name = name;
        this.phone = phone;
        this.accounts = new ArrayList<>(accounts);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
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
}
