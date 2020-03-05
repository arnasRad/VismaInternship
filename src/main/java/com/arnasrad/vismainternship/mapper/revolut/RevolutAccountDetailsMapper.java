package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.revolut.account.BeneficiaryAddressDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.EstimatedTimeDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDto;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;
import com.arnasrad.vismainternship.model.entity.account.BeneficiaryAddress;
import com.arnasrad.vismainternship.model.entity.account.EstimatedTime;
import org.springframework.stereotype.Component;

@Component
public class RevolutAccountDetailsMapper {

    public RevolutAccountDetailsDto mapToAccountDetailsDto(AccountDetails entity) {
        RevolutAccountDetailsDto accountDetailsDto = new RevolutAccountDetailsDto();
        BeneficiaryAddressDto beneficiaryAddressDto = mapToBeneficiaryAddressDto(entity.getBeneficiaryAddress());
        EstimatedTimeDto estimatedTimeDto = mapToEstimatedTimeDto(entity.getEstimatedTime());

        accountDetailsDto.setAccountNo(entity.getAccountNo());
        accountDetailsDto.setIban(entity.getIban());
        accountDetailsDto.setSchemas(entity.getSchemas());
        accountDetailsDto.setBankCountry(entity.getBankCountry());
        accountDetailsDto.setBic(entity.getBic());
        accountDetailsDto.setPooled(entity.getPooled());
        accountDetailsDto.setUniqueReference(entity.getUniqueReference());
        accountDetailsDto.setSortCode(entity.getSortCode());
        accountDetailsDto.setRoutingNumber(entity.getRoutingNumber());
        accountDetailsDto.setBeneficiary(entity.getBeneficiary());
        accountDetailsDto.setBeneficiaryAddress(beneficiaryAddressDto);
        accountDetailsDto.setEstimatedTime(estimatedTimeDto);

        return accountDetailsDto;
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
