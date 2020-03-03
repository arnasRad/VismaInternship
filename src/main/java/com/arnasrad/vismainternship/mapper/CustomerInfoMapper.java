package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerAddressDto;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.CitizenshipDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.CountryTaxDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.DnbCustomerInfoDto;
import com.arnasrad.vismainternship.model.entity.customer.Citizenship;
import com.arnasrad.vismainternship.model.entity.customer.CountryTax;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerInfoMapper {

    public CustomerInfoDto mapToCustomerInfoDto(CustomerInfo entity) {
        CustomerInfoDto customerInfoDto = new CustomerInfoDto();
        CustomerAddressDto customerAddressDto = mapToCustomerAddressDto(entity.getAddress());

        customerInfoDto.setCustomerId(entity.getCustomerId());
        customerInfoDto.setFirstName(entity.getFirstName());
        customerInfoDto.setLastName(entity.getLastName());
        customerInfoDto.setAddress(customerAddressDto);
        customerInfoDto.setPhone(entity.getPhone());
        customerInfoDto.setEmail(entity.getEmail());
        customerInfoDto.setCountryOfBirth(entity.getCountryOfBirth());

        return customerInfoDto;
    }

    public DnbCustomerInfoDto mapToDNBCustomerInfoDto(CustomerInfo entity) {
        DnbCustomerInfoDto dnbCustomerInfoDto = new DnbCustomerInfoDto();
        CustomerAddressDto dnbCustomerAddressDto = mapToCustomerAddressDto(entity.getAddress());
        List<CitizenshipDto> citizenshipDtos = mapToCitizenshipDtoArray(entity.getCitizenship());
        List<CountryTaxDto> countryTaxDtos = mapToCountryTaxDtoArray(entity.getCountryTax());

        dnbCustomerInfoDto.setCustomerId(entity.getCustomerId());
        dnbCustomerInfoDto.setFirstName(entity.getFirstName());
        dnbCustomerInfoDto.setLastName(entity.getLastName());
        dnbCustomerInfoDto.setAddress(dnbCustomerAddressDto);
        dnbCustomerInfoDto.setPhone(entity.getPhone());
        dnbCustomerInfoDto.setEmail(entity.getEmail());
        dnbCustomerInfoDto.setCountryOfBirth(entity.getCountryOfBirth());
        dnbCustomerInfoDto.setCustomerType(entity.getCustomerType());
        dnbCustomerInfoDto.setCitizenship(citizenshipDtos);
        dnbCustomerInfoDto.setCountryTax(countryTaxDtos);

        return dnbCustomerInfoDto;
    }

    public CustomerAddressDto mapToCustomerAddressDto(CustomerAddress entity) {
        CustomerAddressDto customerAddressDto = new CustomerAddressDto();

        customerAddressDto.setPostalCodeName(entity.getPostalCodeName());
        customerAddressDto.setPostalCode(entity.getPostalCode());
        customerAddressDto.setPostalAddressCountry(entity.getPostalAddressCountry());
        customerAddressDto.setAddressLine1(entity.getAddressLine1());
        customerAddressDto.setAddressLine2(entity.getAddressLine2());
        customerAddressDto.setAddressLine3(entity.getAddressLine3());

        return customerAddressDto;
    }

    public CitizenshipDto mapToCitizenshipDto(Citizenship entity) {
        CitizenshipDto citizenshipDto = new CitizenshipDto();

        citizenshipDto.setCountryOfCitizenship(entity.getCountryOfCitizenship());

        return citizenshipDto;
    }

    public CountryTaxDto mapToCountryTaxDto(CountryTax entity) {
        CountryTaxDto countryTaxDto = new CountryTaxDto();

        countryTaxDto.setTaxLiabilityCountry(entity.getTaxLiabilityCountry());
        countryTaxDto.setTaxIdentificationNumber(entity.getTaxIdentificationNumber());

        return countryTaxDto;
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

    public CustomerInfo mapToCustomerInfoEntity(DnbCustomerInfoDto dto) {
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
        Citizenship citizenship = new Citizenship();

        citizenship.setCountryOfCitizenship(dto.getCountryOfCitizenship());

        return citizenship;
    }

    public CountryTax mapToCountryTaxEntity(CountryTaxDto dto) {
        CountryTax countryTax = new CountryTax();

        countryTax.setTaxLiabilityCountry(dto.getTaxLiabilityCountry());
        countryTax.setTaxIdentificationNumber(dto.getTaxIdentificationNumber());

        return countryTax;
    }

    public List<CitizenshipDto> mapToCitizenshipDtoArray(List<Citizenship> citizenships) {
        List<CitizenshipDto> citizenshipDtos = new ArrayList<>();

        for (Citizenship citizenship : citizenships) {
            citizenshipDtos.add(mapToCitizenshipDto(citizenship));
        }

        return citizenshipDtos;
    }

    public List<CountryTaxDto> mapToCountryTaxDtoArray(List<CountryTax> countryTaxes) {
        List<CountryTaxDto> countryTaxDtos = new ArrayList<>();

        for (CountryTax countryTax : countryTaxes) {
            countryTaxDtos.add(mapToCountryTaxDto(countryTax));
        }

        return countryTaxDtos;
    }

    public List<Citizenship> mapToCitizenshipEntityList(List<CitizenshipDto> citizenshipDtos) {
        List<Citizenship> citizenships = new ArrayList<>();

        for (CitizenshipDto citizenshipDto : citizenshipDtos) {
            citizenships.add(mapToCitizenshipEntity(citizenshipDto));
        }

        return citizenships;
    }

    public List<CountryTax> mapToCountryTaxEntityList(List<CountryTaxDto> countryTaxDtos) {
        List<CountryTax> countryTaxes = new ArrayList<>();

        for (CountryTaxDto countryTaxDto : countryTaxDtos) {
            countryTaxes.add(mapToCountryTaxEntity(countryTaxDto));
        }

        return countryTaxes;
    }
}
