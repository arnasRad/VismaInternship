package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class DNBCustomerInfo extends CustomerInfo {
    private String customerType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Citizenship> citizenship;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CountryTax> countryTax;

    public DNBCustomerInfo() {
    }

    public DNBCustomerInfo(String customerId, String firstName, String lastName, DNBCustomerAddress address,
                           String phone, String email, String countryOfBirth, String customerType,
                           List<Citizenship> citizenship, List<CountryTax> countryTax) {
        super(customerId, firstName, lastName, address, phone, email, countryOfBirth);
        this.customerType = customerType;
        this.citizenship = citizenship;
        this.countryTax = countryTax;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<Citizenship> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<Citizenship> citizenship) {
        this.citizenship = citizenship;
    }

    public List<CountryTax> getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(List<CountryTax> countryTax) {
        this.countryTax = countryTax;
    }
}
