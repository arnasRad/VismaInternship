package com.arnasrad.vismainternship.mapper.revolut.account;

import com.arnasrad.vismainternship.model.dto.revolut.account.BeneficiaryAddressDTO;
import com.arnasrad.vismainternship.model.dto.revolut.account.EstimatedTimeDTO;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDTO;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;
import com.arnasrad.vismainternship.model.entity.account.BeneficiaryAddress;
import com.arnasrad.vismainternship.model.entity.account.EstimatedTime;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RevolutAccountDetailsMapper {
    
    private final BeneficiaryAddressMapper beneficiaryAddressMapper;
    private final EstimatedTimeMapper estimatedTimeMapper;

    public RevolutAccountDetailsMapper(BeneficiaryAddressMapper beneficiaryAddressMapper, EstimatedTimeMapper estimatedTimeMapper) {
        this.beneficiaryAddressMapper = beneficiaryAddressMapper;
        this.estimatedTimeMapper = estimatedTimeMapper;
    }

    public RevolutAccountDetailsDTO mapToDTO(AccountDetails entity) {
        List<String> schemas = entity.getSchemas();
        BeneficiaryAddressDTO beneficiaryAddressDTO = beneficiaryAddressMapper.mapToDTO(entity.getBeneficiaryAddress());
        EstimatedTimeDTO estimatedTimeDTO = estimatedTimeMapper.mapToDTO(entity.getEstimatedTime());
        
        return new RevolutAccountDetailsDTO(entity.getIban(), schemas, entity.getAccountNo(), entity.getBankCountry()
                , entity.getBic(), entity.getPooled(), entity.getUniqueReference(), entity.getSortCode(),
                entity.getRoutingNumber(), entity.getBeneficiary(), beneficiaryAddressDTO, estimatedTimeDTO);
    }

    public AccountDetails mapToEntity(RevolutAccountDetailsDTO dto) {
        List<String> schemas = dto.getSchemas();
        BeneficiaryAddress beneficiaryAddress = beneficiaryAddressMapper.mapToEntity(dto.getBeneficiaryAddress());
        EstimatedTime estimatedTime = estimatedTimeMapper.mapToEntity(dto.getEstimatedTime());
        
        return new AccountDetails(dto.getAccountNo(), dto.getIban(), schemas, dto.getBankCountry(),
                dto.getBic(), dto.getPooled(), dto.getUniqueReference(), dto.getSortCode(), dto.getRoutingNumber(),
                dto.getBeneficiary(), beneficiaryAddress, estimatedTime);
    }
}
