package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CitizenshipDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CountryTaxDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerAddressDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerInfoDTO;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.Citizenship;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.CountryTax;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomerAddress;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomerInfo;

import java.util.List;

public class DNBCustomerInfoMapper {
    
    private final DNBCustomerAddressMapper dnbCustomerAddressMapper;
    private final CitizenshipMapper citizenshipMapper;
    private final CountryTaxMapper countryTaxMapper;

    private DNBCustomerInfoMapper(DNBCustomerAddressMapper dnbCustomerAddressMapper,
                                  CitizenshipMapper citizenshipMapper, CountryTaxMapper countryTaxMapper) {
        this.dnbCustomerAddressMapper = dnbCustomerAddressMapper;
        this.citizenshipMapper = citizenshipMapper;
        this.countryTaxMapper = countryTaxMapper;
    }

    public DNBCustomerInfoDTO mapToDTO(DNBCustomerInfo entity) {
        DNBCustomerAddressDTO dnbCustomerAddressDTO =
                dnbCustomerAddressMapper.mapToDTO((DNBCustomerAddress) entity.getAddress());
        List<CitizenshipDTO> citizenshipDTOS = citizenshipMapper.mapToDTOArray(entity.getCitizenship());
        List<CountryTaxDTO> countryTaxDTOS = countryTaxMapper.mapToDTOArray(entity.getCountryTax());
        
        return new DNBCustomerInfoDTO(entity.getCustomerId(), entity.getFirstName(), entity.getLastName(),
                dnbCustomerAddressDTO, entity.getPhone(), entity.getEmail(), entity.getCountryOfBirth(),
                entity.getCustomerType(), citizenshipDTOS, countryTaxDTOS);
    }

    public DNBCustomerInfo mapToEntity(DNBCustomerInfoDTO dto) {
        DNBCustomerAddress dnbCustomerAddress =
                dnbCustomerAddressMapper.mapToEntity((DNBCustomerAddressDTO) dto.getAddress());
        List<Citizenship> citizenships = citizenshipMapper.mapToEntityList(dto.getCitizenship());
        List<CountryTax> countryTaxes = countryTaxMapper.mapToEntityList(dto.getCountryTax());

        return new DNBCustomerInfo(dto.getCustomerId(), dto.getFirstName(), dto.getLastName(),
                dnbCustomerAddress, dto.getPhone(), dto.getEmail(), dto.getCountryOfBirth(),
                dto.getCustomerType(), citizenships, countryTaxes);
    }
}
