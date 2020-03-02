package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDto;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDto;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDto;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.TransactionCardDto;
import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDto;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionDto;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionLegsDto;
import com.arnasrad.vismainternship.model.entity.transaction.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionMapper {

    public TransactionDto mapToTransactionDto(Transaction entity) {
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId(entity.getTransactionId());
        transactionDto.setType(entity.getType());
        transactionDto.setState(entity.getState());
        transactionDto.setCreatedAt(entity.getCreatedAt());
        transactionDto.setCompletedAt(entity.getCompletedAt());
        transactionDto.setReference(entity.getReference());

        return transactionDto;
    }

    public RevolutTransactionDto mapToRevolutTransactionDto(Transaction entity) {
        RevolutTransactionDto revolutTransactionDto = new RevolutTransactionDto();
        MerchantDto merchantDto = mapToMerchantDto(entity.getMerchant());
        List<RevolutTransactionLegsDto> revolutTransactionLegsDtoList =
                mapToRevolutTransactionLegsDtoArray(entity.getTransactionLegs());
        TransactionCardDto transactionCardDto = mapToTransactionCardDto(entity.getCard());

        revolutTransactionDto.setId(entity.getRequestId());
        revolutTransactionDto.setType(entity.getType());
        revolutTransactionDto.setState(entity.getState());
        revolutTransactionDto.setCreatedAt(entity.getCreatedAt());
        revolutTransactionDto.setCompletedAt(entity.getCompletedAt());
        revolutTransactionDto.setReference(entity.getReference());
        revolutTransactionDto.setRequestId(entity.getRequestId());
        revolutTransactionDto.setReasonCode(entity.getReasonCode());
        revolutTransactionDto.setUpdatedAt(entity.getUpdatedAt());
        revolutTransactionDto.setScheduledFor(entity.getScheduledFor());
        revolutTransactionDto.setRelatedTransactionId(entity.getRelatedTransactionId());
        revolutTransactionDto.setMerchant(merchantDto);
        revolutTransactionDto.setRevolutTransactionLegs(revolutTransactionLegsDtoList);
        revolutTransactionDto.setCard(transactionCardDto);

        return revolutTransactionDto;
    }

    public TransactionLegsDto mapToTransactionLegsDto(TransactionLegs entity) {
        TransactionLegsDto transactionLegsDto = new TransactionLegsDto();
        LegsCounterpartyDto legsCounterpartyDto = mapToLegsCounterpartyDto(entity.getCounterparty());

        transactionLegsDto.setId(entity.getTransactionLegsId());
        transactionLegsDto.setAmount(entity.getAmount());
        transactionLegsDto.setCurrency(entity.getCurrency());
        transactionLegsDto.setAccountId(entity.getAccountId());
        transactionLegsDto.setCounterparty(legsCounterpartyDto);
        transactionLegsDto.setDescription(entity.getDescription());
        transactionLegsDto.setBalance(entity.getBalance());

        return transactionLegsDto;
    }

    public RevolutTransactionLegsDto mapToRevolutTransactionLegsDto(TransactionLegs entity) {
        RevolutTransactionLegsDto revolutTransactionLegsDto = new RevolutTransactionLegsDto();
        LegsCounterpartyDto legsCounterpartyDto = mapToLegsCounterpartyDto(entity.getCounterparty());

        revolutTransactionLegsDto.setId(entity.getTransactionLegsId());
        revolutTransactionLegsDto.setAmount(entity.getAmount());
        revolutTransactionLegsDto.setCurrency(entity.getCurrency());
        revolutTransactionLegsDto.setAccountId(entity.getAccountId());
        revolutTransactionLegsDto.setCounterparty(legsCounterpartyDto);
        revolutTransactionLegsDto.setDescription(entity.getDescription());
        revolutTransactionLegsDto.setBalance(entity.getBalance());
        revolutTransactionLegsDto.setBillAmount(entity.getBillAmount());
        revolutTransactionLegsDto.setBillCurrency(entity.getBillCurrency());

        return revolutTransactionLegsDto;
    }

    public TransactionCardDto mapToTransactionCardDto(TransactionCard entity) {
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

    public MerchantDto mapToMerchantDto(Merchant entity) {
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

    public LegsCounterpartyDto mapToLegsCounterpartyDto(LegsCounterparty entity) {
        LegsCounterpartyDto legsCounterpartyDto = new LegsCounterpartyDto();

        legsCounterpartyDto.setId(entity.getAccountId());
        legsCounterpartyDto.setAccountId(entity.getAccountId());
        legsCounterpartyDto.setType(entity.getType());

        return legsCounterpartyDto;
    }

    public Transaction mapToTransactionEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();

        transaction.setTransactionId(dto.getId());
        transaction.setType(dto.getType());
        transaction.setState(dto.getState());
        transaction.setCreatedAt(dto.getCreatedAt());
        transaction.setCompletedAt(dto.getCompletedAt());
        transaction.setReference(dto.getReference());

        return transaction;
    }

    public Transaction mapToTransactionEntity(RevolutTransactionDto dto) {
        Transaction transaction = new Transaction();
        Merchant merchant = mapToMerchantEntity(dto.getMerchant());
        List<TransactionLegs> revolutTransactionLegs =
                mapToTransactionLegsEntityList(dto.getRevolutTransactionLegs());
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
        transaction.setTransactionLegs(revolutTransactionLegs);
        transaction.setCard(transactionCard);

        return transaction;
    }

    public TransactionLegs mapToTransactionLegsEntity(TransactionLegsDto dto) {
        TransactionLegs transactionLegs = new TransactionLegs();
        LegsCounterparty legsCounterparty = mapToLegsCounterpartyEntity(dto.getCounterparty());

        transactionLegs.setTransactionLegsId(dto.getId());
        transactionLegs.setAmount(dto.getAmount());
        transactionLegs.setCurrency(dto.getCurrency());
        transactionLegs.setAccountId(dto.getAccountId());
        transactionLegs.setCounterparty(legsCounterparty);
        transactionLegs.setDescription(dto.getDescription());
        transactionLegs.setBalance(dto.getBalance());

        return transactionLegs;
    }

    public TransactionLegs mapToTransactionLegsEntity(RevolutTransactionLegsDto dto) {
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

    public TransactionCard mapToTransactionCardEntity(TransactionCardDto dto) {
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

    public Merchant mapToMerchantEntity(MerchantDto dto) {
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

    public LegsCounterparty mapToLegsCounterpartyEntity(LegsCounterpartyDto dto) {
        LegsCounterparty legsCounterparty = new LegsCounterparty();

        legsCounterparty.setLegsCounterpartyId(dto.getId());
        legsCounterparty.setAccountId(dto.getAccountId());
        legsCounterparty.setType(dto.getType());

        return legsCounterparty;
    }

    public List<RevolutTransactionLegsDto> mapToRevolutTransactionLegsDtoArray(List<TransactionLegs> revolutTransactionLegs) {
        List<RevolutTransactionLegsDto> revolutTransactionLegsDtos = new ArrayList<>();

        for (TransactionLegs revolutCounterpartyAccount : revolutTransactionLegs) {
            revolutTransactionLegsDtos.add(mapToRevolutTransactionLegsDto(revolutCounterpartyAccount));
        }

        return revolutTransactionLegsDtos;
    }

    public List<TransactionLegs> mapToTransactionLegsEntityList(List<RevolutTransactionLegsDto> revolutTransactionLegsDtos) {
        List<TransactionLegs> revolutTransactionLegs = new ArrayList<>();

        for (RevolutTransactionLegsDto revolutTransactionLegsDto : revolutTransactionLegsDtos) {
            revolutTransactionLegs.add(mapToTransactionLegsEntity(revolutTransactionLegsDto));
        }

        return revolutTransactionLegs;
    }
}
