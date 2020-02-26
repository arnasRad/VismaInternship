package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CitizenshipDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CountryTaxDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerAddressDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerInfoDTO;
import com.arnasrad.vismainternship.model.entity.customer.Citizenship;
import com.arnasrad.vismainternship.model.entity.customer.CountryTax;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    public DNBCustomerInfoDTO mapToDTO(CustomerInfo entity) {
        DNBCustomerAddressDTO dnbCustomerAddressDTO =
                dnbCustomerAddressMapper.mapToDTO(entity.getAddress());
        List<CitizenshipDTO> citizenshipDTOS = citizenshipMapper.mapToDTOArray(entity.getCitizenship());
        List<CountryTaxDTO> countryTaxDTOS = countryTaxMapper.mapToDTOArray(entity.getCountryTax());
        
        return new DNBCustomerInfoDTO(entity.getCustomerId(), entity.getFirstName(), entity.getLastName(),
                dnbCustomerAddressDTO, entity.getPhone(), entity.getEmail(), entity.getCountryOfBirth(),
                entity.getCustomerType(), citizenshipDTOS, countryTaxDTOS);
    }

    public CustomerInfo mapToEntity(DNBCustomerInfoDTO dto) {
        CustomerAddress customerAddress =
                dnbCustomerAddressMapper.mapToEntity((DNBCustomerAddressDTO) dto.getAddress());
        List<Citizenship> citizenships = citizenshipMapper.mapToEntityList(dto.getCitizenship());
        List<CountryTax> countryTaxes = countryTaxMapper.mapToEntityList(dto.getCountryTax());

        return new CustomerInfo(dto.getCustomerId(), dto.getFirstName(), dto.getLastName(),
                customerAddress, dto.getPhone(), dto.getEmail(), dto.getCountryOfBirth(),
                dto.getCustomerType(), citizenships, countryTaxes);
    }
}
