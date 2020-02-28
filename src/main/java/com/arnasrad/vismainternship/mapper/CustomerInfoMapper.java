package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerAddressDTO;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CitizenshipDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CountryTaxDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerInfoDTO;
import com.arnasrad.vismainternship.model.entity.customer.Citizenship;
import com.arnasrad.vismainternship.model.entity.customer.CountryTax;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerInfoMapper {

    public CustomerInfoDTO mapToCustomerInfoDTO(CustomerInfo entity) {
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        CustomerAddressDTO customerAddressDTO = mapToCustomerAddressDTO(entity.getAddress());

        customerInfoDTO.setCustomerId(entity.getCustomerId());
        customerInfoDTO.setFirstName(entity.getFirstName());
        customerInfoDTO.setLastName(entity.getLastName());
        customerInfoDTO.setAddress(customerAddressDTO);
        customerInfoDTO.setPhone(entity.getPhone());
        customerInfoDTO.setEmail(entity.getEmail());
        customerInfoDTO.setCountryOfBirth(entity.getCountryOfBirth());

        return customerInfoDTO;
    }

    public DNBCustomerInfoDTO mapToDNBCustomerInfoDTO(CustomerInfo entity) {
        DNBCustomerInfoDTO dnbCustomerInfoDTO = new DNBCustomerInfoDTO();
        CustomerAddressDTO dnbCustomerAddressDTO = mapToCustomerAddressDTO(entity.getAddress());
        List<CitizenshipDTO> citizenshipDTOS = mapToCitizenshipDTOArray(entity.getCitizenship());
        List<CountryTaxDTO> countryTaxDTOS = mapToCountryTaxDTOArray(entity.getCountryTax());

        dnbCustomerInfoDTO.setCustomerId(entity.getCustomerId());
        dnbCustomerInfoDTO.setFirstName(entity.getFirstName());
        dnbCustomerInfoDTO.setLastName(entity.getLastName());
        dnbCustomerInfoDTO.setAddress(dnbCustomerAddressDTO);
        dnbCustomerInfoDTO.setPhone(entity.getPhone());
        dnbCustomerInfoDTO.setEmail(entity.getEmail());
        dnbCustomerInfoDTO.setCountryOfBirth(entity.getCountryOfBirth());
        dnbCustomerInfoDTO.setCustomerType(entity.getCustomerType());
        dnbCustomerInfoDTO.setCitizenship(citizenshipDTOS);
        dnbCustomerInfoDTO.setCountryTax(countryTaxDTOS);

        return dnbCustomerInfoDTO;
    }

    public CustomerAddressDTO mapToCustomerAddressDTO(CustomerAddress entity) {
        CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();

        customerAddressDTO.setPostalCodeName(entity.getPostalCodeName());
        customerAddressDTO.setPostalCode(entity.getPostalCode());
        customerAddressDTO.setPostalAddressCountry(entity.getPostalAddressCountry());
        customerAddressDTO.setAddressLine1(entity.getAddressLine1());
        customerAddressDTO.setAddressLine2(entity.getAddressLine2());
        customerAddressDTO.setAddressLine3(entity.getAddressLine3());

        return customerAddressDTO;
    }

    public CitizenshipDTO mapToCitizenshipDTO(Citizenship entity) {
        return new CitizenshipDTO(entity.getCountryOfCitizenship());
    }

    public CountryTaxDTO mapToCountryTaxDTO(CountryTax entity) {
        return new CountryTaxDTO(entity.getTaxLiabilityCountry(), entity.getTaxIdentificationNumber());
    }

    public CustomerInfo mapToCustomerInfoEntity(CustomerInfoDTO dto) {
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

    public CustomerInfo mapToCustomerInfoEntity(DNBCustomerInfoDTO dto) {
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

    public CustomerAddress mapToCustomerAddressEntity(CustomerAddressDTO dto) {
        CustomerAddress customerAddress = new CustomerAddress();

        customerAddress.setPostalCodeName(dto.getPostalCodeName());
        customerAddress.setPostalCode(dto.getPostalCode());
        customerAddress.setPostalAddressCountry(dto.getPostalAddressCountry());
        customerAddress.setAddressLine1(dto.getAddressLine1());
        customerAddress.setAddressLine2(dto.getAddressLine2());
        customerAddress.setAddressLine3(dto.getAddressLine3());

        return customerAddress;
    }

    public Citizenship mapToCitizenshipEntity(CitizenshipDTO dto) {
        return new Citizenship(dto.getCountryOfCitizenship());
    }

    public CountryTax mapToCountryTaxEntity(CountryTaxDTO dto) {
        return new CountryTax(dto.getTaxLiabilityCountry(), dto.getTaxIdentificationNumber());
    }

    public List<CitizenshipDTO> mapToCitizenshipDTOArray(List<Citizenship> citizenships) {
        List<CitizenshipDTO> citizenshipDTOS = new ArrayList<>();

        for (Citizenship citizenship : citizenships) {
            citizenshipDTOS.add(mapToCitizenshipDTO(citizenship));
        }

        return citizenshipDTOS;
    }

    public List<CountryTaxDTO> mapToCountryTaxDTOArray(List<CountryTax> countryTaxes) {
        List<CountryTaxDTO> countryTaxDTOS = new ArrayList<>();

        for (CountryTax countryTax : countryTaxes) {
            countryTaxDTOS.add(mapToCountryTaxDTO(countryTax));
        }

        return countryTaxDTOS;
    }

    public List<Citizenship> mapToCitizenshipEntityList(List<CitizenshipDTO> citizenshipDTOS) {
        List<Citizenship> citizenships = new ArrayList<>();

        for (CitizenshipDTO citizenshipDTO : citizenshipDTOS) {
            citizenships.add(mapToCitizenshipEntity(citizenshipDTO));
        }

        return citizenships;
    }

    public List<CountryTax> mapToCountryTaxEntityList(List<CountryTaxDTO> countryTaxDTOS) {
        List<CountryTax> countryTaxes = new ArrayList<>();

        for (CountryTaxDTO countryTaxDTO : countryTaxDTOS) {
            countryTaxes.add(mapToCountryTaxEntity(countryTaxDTO));
        }

        return countryTaxes;
    }
}
