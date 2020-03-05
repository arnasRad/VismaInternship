package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.TransactionDto;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.*;
import com.arnasrad.vismainternship.model.entity.transaction.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevolutTransactionMapper {

    public RevolutTransactionDto mapToRevolutTransactionDto(Transaction entity) {
        RevolutTransactionDto transactionDto = new RevolutTransactionDto();
        MerchantDto merchantDto = mapToMerchantDto(entity.getMerchant());
        List<TransactionLegsDto> transactionLegsDtoList =
                mapToTransactionLegsDtoArray(entity.getTransactionLegs());
        TransactionCardDto transactionCardDto = mapToTransactionCardDto(entity.getCard());

        transactionDto.setId(entity.getRequestId());
        transactionDto.setType(entity.getType());
        transactionDto.setState(entity.getState());
        transactionDto.setCreatedAt(entity.getCreatedAt());
        transactionDto.setCompletedAt(entity.getCompletedAt());
        transactionDto.setReference(entity.getReference());
        transactionDto.setRequestId(entity.getRequestId());
        transactionDto.setReasonCode(entity.getReasonCode());
        transactionDto.setUpdatedAt(entity.getUpdatedAt());
        transactionDto.setScheduledFor(entity.getScheduledFor());
        transactionDto.setRelatedTransactionId(entity.getRelatedTransactionId());
        transactionDto.setMerchant(merchantDto);
        transactionDto.setTransactionLegs(transactionLegsDtoList);
        transactionDto.setCard(transactionCardDto);

        return transactionDto;
    }

    public TransactionDto mapToTransactionDto(RevolutTransactionDto revolutTransactionDto) {
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId(revolutTransactionDto.getId());
        TransactionLegsDto transactionLegsDto = revolutTransactionDto.getTransactionLegs().get(0);

        transactionDto.setDebtor(transactionLegsDto.getAccountId());

        LegsCounterpartyDto legsCounterpartyDto = transactionLegsDto.getCounterparty();
        transactionDto.setCreditorIban(legsCounterpartyDto.getAccountId());
        String amount = String.valueOf(transactionLegsDto.getAmount());

        transactionDto.setAmount(amount);
        transactionDto.setCurrency(transactionLegsDto.getCurrency());
        transactionDto.setStatus(transactionDto.getStatus());
        transactionDto.setCompletedAt(transactionDto.getCompletedAt());
        transactionDto.setReference(transactionDto.getReference());

        return transactionDto;
    }

    public List<TransactionDto> mapToTransactionDtoList(List<RevolutTransactionDto> revolutTransactionDtoList) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();

        for(RevolutTransactionDto revolutTransactionDto : revolutTransactionDtoList) {
            TransactionDto transactionDto = mapToTransactionDto(revolutTransactionDto);
            transactionDtoList.add(transactionDto);
        }

        return transactionDtoList;
    }

    public Transaction mapToTransactionEntity(RevolutTransactionDto dto) {
        Transaction transaction = new Transaction();
        Merchant merchant = mapToMerchantEntity(dto.getMerchant());
        List<TransactionLegs> transactionLegs =
                mapToTransactionLegsEntityList(dto.getTransactionLegs());
        TransactionCard transactionCard = mapToTransactionCardEntity(dto.getCard());

        transaction.setTransactionId(dto.getId());
        transaction.setType(dto.getType());
        transaction.setState(dto.getState());
        transaction.setCreatedAt(dto.getCreatedAt());
        transaction.setCompletedAt(dto.getCompletedAt());
        transaction.setReference(dto.getReference());
        transaction.setRequestId(dto.getRequestId());
        transaction.setReasonCode(dto.getReasonCode());
        transaction.setUpdatedAt(dto.getUpdatedAt());
        transaction.setScheduledFor(dto.getScheduledFor());
        transaction.setRelatedTransactionId(dto.getRelatedTransactionId());
        transaction.setMerchant(merchant);
        transaction.setTransactionLegs(transactionLegs);
        transaction.setCard(transactionCard);

        return transaction;
    }

    private TransactionLegsDto mapToTransactionLegsDto(TransactionLegs entity) {
        TransactionLegsDto transactionLegsDto = new TransactionLegsDto();
        LegsCounterpartyDto legsCounterpartyDto = mapToLegsCounterpartyDto(entity.getCounterparty());

        transactionLegsDto.setId(entity.getTransactionLegsId());
        transactionLegsDto.setAmount(entity.getAmount());
        transactionLegsDto.setCurrency(entity.getCurrency());
        transactionLegsDto.setAccountId(entity.getAccountId());
        transactionLegsDto.setCounterparty(legsCounterpartyDto);
        transactionLegsDto.setDescription(entity.getDescription());
        transactionLegsDto.setBalance(entity.getBalance());
        transactionLegsDto.setBillAmount(entity.getBillAmount());
        transactionLegsDto.setBillCurrency(entity.getBillCurrency());

        return transactionLegsDto;
    }

    private TransactionCardDto mapToTransactionCardDto(TransactionCard entity) {
        if (entity == null) {
            return null;
        }

        TransactionCardDto transactionCardDto = new TransactionCardDto();

        transactionCardDto.setCardNumber(entity.getCardNumber());
        transactionCardDto.setFirstName(entity.getFirstName());
        transactionCardDto.setLastName(entity.getLastName());
        transactionCardDto.setPhone(entity.getPhone());

        return transactionCardDto;
    }

    private MerchantDto mapToMerchantDto(Merchant entity) {
        if (entity == null) {
            return null;
        }

        MerchantDto merchantDto = new MerchantDto();

        merchantDto.setName(entity.getName());
        merchantDto.setCity(entity.getCity());
        merchantDto.setCategoryCode(entity.getCategoryCode());
        merchantDto.setCountry(entity.getCountry());

        return merchantDto;
    }

    private LegsCounterpartyDto mapToLegsCounterpartyDto(LegsCounterparty entity) {
        LegsCounterpartyDto legsCounterpartyDto = new LegsCounterpartyDto();

        legsCounterpartyDto.setId(entity.getAccountId());
        legsCounterpartyDto.setAccountId(entity.getAccountId());
        legsCounterpartyDto.setType(entity.getType());

        return legsCounterpartyDto;
    }

    private TransactionLegs mapToTransactionLegsEntity(TransactionLegsDto dto) {
        TransactionLegs transactionLegs = new TransactionLegs();
        LegsCounterparty legsCounterparty = mapToLegsCounterpartyEntity(dto.getCounterparty());

        transactionLegs.setTransactionLegsId(dto.getId());
        transactionLegs.setAmount(dto.getAmount());
        transactionLegs.setCurrency(dto.getCurrency());
        transactionLegs.setAccountId(dto.getAccountId());
        transactionLegs.setCounterparty(legsCounterparty);
        transactionLegs.setDescription(dto.getDescription());
        transactionLegs.setBalance(dto.getBalance());
        transactionLegs.setBillAmount(dto.getBillAmount());
        transactionLegs.setBillCurrency(dto.getBillCurrency());

        return transactionLegs;
    }

    private TransactionCard mapToTransactionCardEntity(TransactionCardDto dto) {
        if (dto == null) {
            return null;
        }

        TransactionCard transactionCard = new TransactionCard();

        transactionCard.setCardNumber(dto.getCardNumber());
        transactionCard.setFirstName(dto.getFirstName());
        transactionCard.setLastName(dto.getLastName());
        transactionCard.setPhone(dto.getPhone());

        return transactionCard;
    }

    private Merchant mapToMerchantEntity(MerchantDto dto) {
        if (dto == null) {
            return null;
        }

        Merchant merchant = new Merchant();

        merchant.setName(dto.getName());
        merchant.setCity(dto.getCity());
        merchant.setCategoryCode(dto.getCategoryCode());
        merchant.setCountry(dto.getCountry());

        return merchant;
    }

    private LegsCounterparty mapToLegsCounterpartyEntity(LegsCounterpartyDto dto) {
        LegsCounterparty legsCounterparty = new LegsCounterparty();

        legsCounterparty.setLegsCounterpartyId(dto.getId());
        legsCounterparty.setAccountId(dto.getAccountId());
        legsCounterparty.setType(dto.getType());

        return legsCounterparty;
    }

    private List<TransactionLegsDto> mapToTransactionLegsDtoArray(List<TransactionLegs> transactionLegs) {
        List<TransactionLegsDto> transactionLegsDtos = new ArrayList<>();

        for (TransactionLegs transactionLeg : transactionLegs) {
            transactionLegsDtos.add(mapToTransactionLegsDto(transactionLeg));
        }

        return transactionLegsDtos;
    }

    private List<TransactionLegs> mapToTransactionLegsEntityList(List<TransactionLegsDto> transactionLegsDtos) {
        List<TransactionLegs> transactionLegs = new ArrayList<>();

        for (TransactionLegsDto transactionLegsDto : transactionLegsDtos) {
            transactionLegs.add(mapToTransactionLegsEntity(transactionLegsDto));
        }

        return transactionLegs;
    }
}
