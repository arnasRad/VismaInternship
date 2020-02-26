package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CountryTaxDTO;
import com.arnasrad.vismainternship.model.entity.customer.CountryTax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryTaxMapper {

    public CountryTaxDTO mapToDTO(CountryTax entity) {
        return new CountryTaxDTO(entity.getTaxLiabilityCountry(), entity.getTaxIdentificationNumber());
    }

    public CountryTax mapToEntity(CountryTaxDTO dto) {
        return new CountryTax(dto.getTaxLiabilityCountry(), dto.getTaxIdentificationNumber());
    }

    public List<CountryTaxDTO> mapToDTOArray(List<CountryTax> countryTaxes) {
        List<CountryTaxDTO> countryTaxDTOS = new ArrayList<>();

        for (CountryTax countryTax : countryTaxes) {
            countryTaxDTOS.add(mapToDTO(countryTax));
        }

        return countryTaxDTOS;
    }

    public List<CountryTax> mapToEntityList(List<CountryTaxDTO> countryTaxDTOS) {
        List<CountryTax> countryTaxes = new ArrayList<>();

        for(CountryTaxDTO countryTaxDTO : countryTaxDTOS) {
            countryTaxes.add(mapToEntity(countryTaxDTO));
        }

        return countryTaxes;
    }
}
