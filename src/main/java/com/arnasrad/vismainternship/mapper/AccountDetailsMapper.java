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

    public AccountDetailsDto mapToAccountDetailsDto(AccountDetails entity) {
        AccountDetailsDto accountDetailsDto = new AccountDetailsDto();

        accountDetailsDto.setAccountNo(entity.getAccountNo());
        accountDetailsDto.setIban(entity.getIban());
        accountDetailsDto.setSchemas(entity.getSchemas());
        accountDetailsDto.setBankCountry(entity.getBankCountry());

        return accountDetailsDto;
    }

    public RevolutAccountDetailsDto mapToRevolutAccountDetailsDto(AccountDetails entity) {
        RevolutAccountDetailsDto revolutAccountDetailsDto = new RevolutAccountDetailsDto();
        BeneficiaryAddressDto beneficiaryAddressDto = mapToBeneficiaryAddressDto(entity.getBeneficiaryAddress());
        EstimatedTimeDto estimatedTimeDto = mapToEstimatedTimeDto(entity.getEstimatedTime());

        revolutAccountDetailsDto.setAccountNo(entity.getAccountNo());
        revolutAccountDetailsDto.setIban(entity.getIban());
        revolutAccountDetailsDto.setSchemas(entity.getSchemas());
        revolutAccountDetailsDto.setBankCountry(entity.getBankCountry());
        revolutAccountDetailsDto.setBic(entity.getBic());
        revolutAccountDetailsDto.setPooled(entity.getPooled());
        revolutAccountDetailsDto.setUniqueReference(entity.getUniqueReference());
        revolutAccountDetailsDto.setSortCode(entity.getSortCode());
        revolutAccountDetailsDto.setRoutingNumber(entity.getRoutingNumber());
        revolutAccountDetailsDto.setBeneficiary(entity.getBeneficiary());
        revolutAccountDetailsDto.setBeneficiaryAddress(beneficiaryAddressDto);
        revolutAccountDetailsDto.setEstimatedTime(estimatedTimeDto);

        return revolutAccountDetailsDto;
    }

    public BeneficiaryAddressDto mapToBeneficiaryAddressDto(BeneficiaryAddress entity) {
        BeneficiaryAddressDto beneficiaryAddressDto = new BeneficiaryAddressDto();

        beneficiaryAddressDto.setStreetLine1(entity.getStreetLine1());
        beneficiaryAddressDto.setStreetLine2(entity.getStreetLine2());
        beneficiaryAddressDto.setRegion(entity.getRegion());
        beneficiaryAddressDto.setCity(entity.getCity());
        beneficiaryAddressDto.setCountry(entity.getCountry());
        beneficiaryAddressDto.setPostcode(entity.getPostcode());

        return beneficiaryAddressDto;
    }

    public EstimatedTimeDto mapToEstimatedTimeDto(EstimatedTime entity) {
        EstimatedTimeDto estimatedTimeDto = new EstimatedTimeDto();

        entity.setUnit(entity.getUnit());
        entity.setMin(entity.getMin());
        entity.setMax(entity.getMax());

        return estimatedTimeDto;
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
