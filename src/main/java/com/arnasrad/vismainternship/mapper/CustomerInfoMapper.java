package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerAddressDto;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CitizenshipDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CountryTaxDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerInfoDto;
import com.arnasrad.vismainternship.model.entity.customer.Citizenship;
import com.arnasrad.vismainternship.model.entity.customer.CountryTax;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerInfoMapper {

    public CustomerInfoDto mapToCustomerInfoDTO(CustomerInfo entity) {
        CustomerInfoDto customerInfoDTO = new CustomerInfoDto();
        CustomerAddressDto customerAddressDTO = mapToCustomerAddressDTO(entity.getAddress());

        customerInfoDTO.setCustomerId(entity.getCustomerId());
        customerInfoDTO.setFirstName(entity.getFirstName());
        customerInfoDTO.setLastName(entity.getLastName());
        customerInfoDTO.setAddress(customerAddressDTO);
        customerInfoDTO.setPhone(entity.getPhone());
        customerInfoDTO.setEmail(entity.getEmail());
        customerInfoDTO.setCountryOfBirth(entity.getCountryOfBirth());

        return customerInfoDTO;
    }

    public DNBCustomerInfoDto mapToDNBCustomerInfoDTO(CustomerInfo entity) {
        DNBCustomerInfoDto dnbCustomerInfoDTO = new DNBCustomerInfoDto();
        CustomerAddressDto dnbCustomerAddressDto = mapToCustomerAddressDTO(entity.getAddress());
        List<CitizenshipDto> citizenshipDtos = mapToCitizenshipDTOArray(entity.getCitizenship());
        List<CountryTaxDto> countryTaxDtos = mapToCountryTaxDTOArray(entity.getCountryTax());

        dnbCustomerInfoDTO.setCustomerId(entity.getCustomerId());
        dnbCustomerInfoDTO.setFirstName(entity.getFirstName());
        dnbCustomerInfoDTO.setLastName(entity.getLastName());
        dnbCustomerInfoDTO.setAddress(dnbCustomerAddressDto);
        dnbCustomerInfoDTO.setPhone(entity.getPhone());
        dnbCustomerInfoDTO.setEmail(entity.getEmail());
        dnbCustomerInfoDTO.setCountryOfBirth(entity.getCountryOfBirth());
        dnbCustomerInfoDTO.setCustomerType(entity.getCustomerType());
        dnbCustomerInfoDTO.setCitizenship(citizenshipDtos);
        dnbCustomerInfoDTO.setCountryTax(countryTaxDtos);

        return dnbCustomerInfoDTO;
    }

    public CustomerAddressDto mapToCustomerAddressDTO(CustomerAddress entity) {
        CustomerAddressDto customerAddressDTO = new CustomerAddressDto();

        customerAddressDTO.setPostalCodeName(entity.getPostalCodeName());
        customerAddressDTO.setPostalCode(entity.getPostalCode());
        customerAddressDTO.setPostalAddressCountry(entity.getPostalAddressCountry());
        customerAddressDTO.setAddressLine1(entity.getAddressLine1());
        customerAddressDTO.setAddressLine2(entity.getAddressLine2());
        customerAddressDTO.setAddressLine3(entity.getAddressLine3());

        return customerAddressDTO;
    }

    public CitizenshipDto mapToCitizenshipDTO(Citizenship entity) {
        return new CitizenshipDto(entity.getCountryOfCitizenship());
    }

    public CountryTaxDto mapToCountryTaxDTO(CountryTax entity) {
        return new CountryTaxDto(entity.getTaxLiabilityCountry(), entity.getTaxIdentificationNumber());
    }

    public CustomerInfo mapToCustomerInfoEntity(CustomerInfoDto dto) {
        CustomerInfo customerInfo = new CustomerInfo();
        CustomerAddress customerAddress = mapToCustomerAddressEntity(dto.getAddress());

        customerInfo.setCustomerId(dto.getCustomerId());
        customerInfo.setFirstName(dto.getFirstName());
        customerInfo.setLastName(dto.getLastName());
        customerInfo.setAddress(customerAddress);
        customerInfo.setPhone(dto.getPhone());
        customerInfo.setEmail(dto.getEmail());
        customerInfo.setCountryOfBirth(dto.getCountryOfBirth());

        return customerInfo;
    }

    public CustomerInfo mapToCustomerInfoEntity(DNBCustomerInfoDto dto) {
        CustomerInfo customerInfo = new CustomerInfo();
        CustomerAddress customerAddress = mapToCustomerAddressEntity(dto.getAddress());
        List<Citizenship> citizenships = mapToCitizenshipEntityList(dto.getCitizenship());
        List<CountryTax> countryTaxes = mapToCountryTaxEntityList(dto.getCountryTax());

        customerInfo.setCustomerId(dto.getCustomerId());
        customerInfo.setFirstName(dto.getFirstName());
        customerInfo.setLastName(dto.getLastName());
        customerInfo.setAddress(customerAddress);
        customerInfo.setPhone(dto.getPhone());
        customerInfo.setEmail(dto.getEmail());
        customerInfo.setCountryOfBirth(dto.getCountryOfBirth());
        customerInfo.setCustomerType(dto.getCustomerType());
        customerInfo.setCitizenship(citizenships);
        customerInfo.setCountryTax(countryTaxes);

        return customerInfo;
    }

    public CustomerAddress mapToCustomerAddressEntity(CustomerAddressDto dto) {
        CustomerAddress customerAddress = new CustomerAddress();

        customerAddress.setPostalCodeName(dto.getPostalCodeName());
        customerAddress.setPostalCode(dto.getPostalCode());
        customerAddress.setPostalAddressCountry(dto.getPostalAddressCountry());
        customerAddress.setAddressLine1(dto.getAddressLine1());
        customerAddress.setAddressLine2(dto.getAddressLine2());
        customerAddress.setAddressLine3(dto.getAddressLine3());

        return customerAddress;
    }

    public Citizenship mapToCitizenshipEntity(CitizenshipDto dto) {
        return new Citizenship(dto.getCountryOfCitizenship());
    }

    public CountryTax mapToCountryTaxEntity(CountryTaxDto dto) {
        return new CountryTax(dto.getTaxLiabilityCountry(), dto.getTaxIdentificationNumber());
    }

    public List<CitizenshipDto> mapToCitizenshipDTOArray(List<Citizenship> citizenships) {
        List<CitizenshipDto> citizenshipDtos = new ArrayList<>();

        for (Citizenship citizenship : citizenships) {
            citizenshipDtos.add(mapToCitizenshipDTO(citizenship));
        }

        return citizenshipDtos;
    }

    public List<CountryTaxDto> mapToCountryTaxDTOArray(List<CountryTax> countryTaxes) {
        List<CountryTaxDto> countryTaxDtos = new ArrayList<>();

        for (CountryTax countryTax : countryTaxes) {
            countryTaxDtos.add(mapToCountryTaxDTO(countryTax));
        }

        return countryTaxDtos;
    }

    public List<Citizenship> mapToCitizenshipEntityList(List<CitizenshipDto> citizenshipDtos) {
        List<Citizenship> citizenships = new ArrayList<>();

        for (CitizenshipDto citizenshipDTO : citizenshipDtos) {
            citizenships.add(mapToCitizenshipEntity(citizenshipDTO));
        }

        return citizenships;
    }

    public List<CountryTax> mapToCountryTaxEntityList(List<CountryTaxDto> countryTaxDtos) {
        List<CountryTax> countryTaxes = new ArrayList<>();

        for (CountryTaxDto countryTaxDTO : countryTaxDtos) {
            countryTaxes.add(mapToCountryTaxEntity(countryTaxDTO));
        }

        return countryTaxes;
    }
}
