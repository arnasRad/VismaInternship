package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.BeneficiaryAddressDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.EstimatedTimeDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDto;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;
import com.arnasrad.vismainternship.model.entity.account.BeneficiaryAddress;
import com.arnasrad.vismainternship.model.entity.account.EstimatedTime;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsMapper {

    public AccountDetailsDto mapToAccountDetailsDTO(AccountDetails entity) {
        AccountDetailsDto accountDetailsDTO = new AccountDetailsDto();

        accountDetailsDTO.setAccountNo(entity.getAccountNo());
        accountDetailsDTO.setIban(entity.getIban());
        accountDetailsDTO.setSchemas(entity.getSchemas());
        accountDetailsDTO.setBankCountry(entity.getBankCountry());

        return accountDetailsDTO;
    }

    public RevolutAccountDetailsDto mapToRevolutAccountDetailsDTO(AccountDetails entity) {
        RevolutAccountDetailsDto revolutAccountDetailsDTO = new RevolutAccountDetailsDto();
        BeneficiaryAddressDto beneficiaryAddressDTO = mapToBeneficiaryAddressDTO(entity.getBeneficiaryAddress());
        EstimatedTimeDto estimatedTimeDTO = mapToEstimatedTimeDTO(entity.getEstimatedTime());

        revolutAccountDetailsDTO.setAccountNo(entity.getAccountNo());
        revolutAccountDetailsDTO.setIban(entity.getIban());
        revolutAccountDetailsDTO.setSchemas(entity.getSchemas());
        revolutAccountDetailsDTO.setBankCountry(entity.getBankCountry());
        revolutAccountDetailsDTO.setBic(entity.getBic());
        revolutAccountDetailsDTO.setPooled(entity.getPooled());
        revolutAccountDetailsDTO.setUniqueReference(entity.getUniqueReference());
        revolutAccountDetailsDTO.setSortCode(entity.getSortCode());
        revolutAccountDetailsDTO.setRoutingNumber(entity.getRoutingNumber());
        revolutAccountDetailsDTO.setBeneficiary(entity.getBeneficiary());
        revolutAccountDetailsDTO.setBeneficiaryAddress(beneficiaryAddressDTO);
        revolutAccountDetailsDTO.setEstimatedTime(estimatedTimeDTO);

        return revolutAccountDetailsDTO;
    }

    public BeneficiaryAddressDto mapToBeneficiaryAddressDTO(BeneficiaryAddress entity) {
        BeneficiaryAddressDto beneficiaryAddressDTO = new BeneficiaryAddressDto();

        beneficiaryAddressDTO.setStreetLine1(entity.getStreetLine1());
        beneficiaryAddressDTO.setStreetLine2(entity.getStreetLine2());
        beneficiaryAddressDTO.setRegion(entity.getRegion());
        beneficiaryAddressDTO.setCity(entity.getCity());
        beneficiaryAddressDTO.setCountry(entity.getCountry());
        beneficiaryAddressDTO.setPostcode(entity.getPostcode());

        return beneficiaryAddressDTO;
    }

    public EstimatedTimeDto mapToEstimatedTimeDTO(EstimatedTime entity) {
        EstimatedTimeDto estimatedTimeDTO = new EstimatedTimeDto();

        entity.setUnit(entity.getUnit());
        entity.setMin(entity.getMin());
        entity.setMax(entity.getMax());

        return estimatedTimeDTO;
    }

    public AccountDetails mapToAccountDetailsEntity(AccountDetailsDto dto) {
        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setAccountNo(dto.getAccountNo());
        accountDetails.setIban(dto.getIban());
        accountDetails.setSchemas(dto.getSchemas());
        accountDetails.setBankCountry(dto.getBankCountry());

        return accountDetails;
    }

    public AccountDetails mapToAccountDetailsEntity(RevolutAccountDetailsDto dto) {
        AccountDetails accountDetails = new AccountDetails();
        BeneficiaryAddress beneficiaryAddress = mapToBeneficiaryAddressEntity(dto.getBeneficiaryAddress());
        EstimatedTime estimatedTime = mapToEstimatedTimeEntity(dto.getEstimatedTime());

        accountDetails.setAccountNo(dto.getAccountNo());
        accountDetails.setIban(dto.getIban());
        accountDetails.setSchemas(dto.getSchemas());
        accountDetails.setBankCountry(dto.getBankCountry());
        accountDetails.setBic(dto.getBic());
        accountDetails.setPooled(dto.getPooled());
        accountDetails.setUniqueReference(dto.getUniqueReference());
        accountDetails.setSortCode(dto.getSortCode());
        accountDetails.setRoutingNumber(dto.getRoutingNumber());
        accountDetails.setBeneficiary(dto.getBeneficiary());
        accountDetails.setBeneficiaryAddress(beneficiaryAddress);
        accountDetails.setEstimatedTime(estimatedTime);

        return accountDetails;
    }

    public BeneficiaryAddress mapToBeneficiaryAddressEntity(BeneficiaryAddressDto dto) {
        BeneficiaryAddress beneficiaryAddress = new BeneficiaryAddress();

        beneficiaryAddress.setStreetLine1(dto.getStreetLine1());
        beneficiaryAddress.setStreetLine2(dto.getStreetLine2());
        beneficiaryAddress.setRegion(dto.getRegion());
        beneficiaryAddress.setCity(dto.getCity());
        beneficiaryAddress.setCountry(dto.getCountry());
        beneficiaryAddress.setPostcode(dto.getPostcode());

        return beneficiaryAddress;
    }

    public EstimatedTime mapToEstimatedTimeEntity(EstimatedTimeDto dto) {
        EstimatedTime estimatedTime = new EstimatedTime();

        estimatedTime.setUnit(dto.getUnit());
        estimatedTime.setMin(dto.getMin());
        estimatedTime.setMax(dto.getMax());

        return estimatedTime;
    }
}
