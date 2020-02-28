package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionLegsDTO;
import com.arnasrad.vismainternship.model.entity.transaction.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionMapper {

    public TransactionDTO mapToTransactionDTO(Transaction entity) {
        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId(entity.getTransactionId());
        transactionDTO.setType(entity.getType());
        transactionDTO.setState(entity.getState());
        transactionDTO.setCreatedAt(entity.getCreatedAt());
        transactionDTO.setCompletedAt(entity.getCompletedAt());
        transactionDTO.setReference(entity.getReference());

        return transactionDTO;
    }

    public RevolutTransactionDTO mapToRevolutTransactionDTO(Transaction entity) {
        RevolutTransactionDTO revolutTransactionDTO = new RevolutTransactionDTO();
        MerchantDTO merchantDTO = mapToMerchantDTO(entity.getMerchant());
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOList =
                mapToRevolutTransactionLegsDTOArray(entity.getTransactionLegs());
        TransactionCardDTO transactionCardDTO = mapToTransactionCardDTO(entity.getCard());

        revolutTransactionDTO.setId(entity.getRequestId());
        revolutTransactionDTO.setType(entity.getType());
        revolutTransactionDTO.setState(entity.getState());
        revolutTransactionDTO.setCreatedAt(entity.getCreatedAt());
        revolutTransactionDTO.setCompletedAt(entity.getCompletedAt());
        revolutTransactionDTO.setReference(entity.getReference());
        revolutTransactionDTO.setRequestId(entity.getRequestId());
        revolutTransactionDTO.setReasonCode(entity.getReasonCode());
        revolutTransactionDTO.setUpdatedAt(entity.getUpdatedAt());
        revolutTransactionDTO.setScheduledFor(entity.getScheduledFor());
        revolutTransactionDTO.setRelatedTransactionId(entity.getRelatedTransactionId());
        revolutTransactionDTO.setMerchant(merchantDTO);
        revolutTransactionDTO.setRevolutTransactionLegs(revolutTransactionLegsDTOList);
        revolutTransactionDTO.setCard(transactionCardDTO);

        return revolutTransactionDTO;
    }

    public TransactionLegsDTO mapToTransactionLegsDTO(TransactionLegs entity) {
        TransactionLegsDTO transactionLegsDTO = new TransactionLegsDTO();
        LegsCounterpartyDTO legsCounterpartyDTO = mapToLegsCounterpartyDTO(entity.getCounterparty());

        transactionLegsDTO.setId(entity.getTransactionLegsId());
        transactionLegsDTO.setAmount(entity.getAmount());
        transactionLegsDTO.setCurrency(entity.getCurrency());
        transactionLegsDTO.setAccountId(entity.getAccountId());
        transactionLegsDTO.setCounterparty(legsCounterpartyDTO);
        transactionLegsDTO.setDescription(entity.getDescription());
        transactionLegsDTO.setBalance(entity.getBalance());

        return transactionLegsDTO;
    }

    public RevolutTransactionLegsDTO mapToRevolutTransactionLegsDTO(TransactionLegs entity) {
        RevolutTransactionLegsDTO revolutTransactionLegsDTO = new RevolutTransactionLegsDTO();
        LegsCounterpartyDTO legsCounterpartyDTO = mapToLegsCounterpartyDTO(entity.getCounterparty());

        revolutTransactionLegsDTO.setId(entity.getTransactionLegsId());
        revolutTransactionLegsDTO.setAmount(entity.getAmount());
        revolutTransactionLegsDTO.setCurrency(entity.getCurrency());
        revolutTransactionLegsDTO.setAccountId(entity.getAccountId());
        revolutTransactionLegsDTO.setCounterparty(legsCounterpartyDTO);
        revolutTransactionLegsDTO.setDescription(entity.getDescription());
        revolutTransactionLegsDTO.setBalance(entity.getBalance());
        revolutTransactionLegsDTO.setBillAmount(entity.getBillAmount());
        revolutTransactionLegsDTO.setBillCurrency(entity.getBillCurrency());

        return revolutTransactionLegsDTO;
    }

    public TransactionCardDTO mapToTransactionCardDTO(TransactionCard entity) {
        if (entity == null) {
            return null;
        }

        TransactionCardDTO transactionCardDTO = new TransactionCardDTO();

        transactionCardDTO.setCardNumber(entity.getCardNumber());
        transactionCardDTO.setFirstName(entity.getFirstName());
        transactionCardDTO.setLastName(entity.getLastName());
        transactionCardDTO.setPhone(entity.getPhone());

        return transactionCardDTO;
    }

    public MerchantDTO mapToMerchantDTO(Merchant entity) {
        if (entity == null) {
            return null;
        }

        MerchantDTO merchantDTO = new MerchantDTO();

        merchantDTO.setName(entity.getName());
        merchantDTO.setCity(entity.getCity());
        merchantDTO.setCategoryCode(entity.getCategoryCode());
        merchantDTO.setCountry(entity.getCountry());

        return merchantDTO;
    }

    public LegsCounterpartyDTO mapToLegsCounterpartyDTO(LegsCounterparty entity) {
        LegsCounterpartyDTO legsCounterpartyDTO = new LegsCounterpartyDTO();

        legsCounterpartyDTO.setId(entity.getAccountId());
        legsCounterpartyDTO.setAccountId(entity.getAccountId());
        legsCounterpartyDTO.setType(entity.getType());

        return legsCounterpartyDTO;
    }

    public Transaction mapToTransactionEntity(TransactionDTO dto) {
        Transaction transaction = new Transaction();

        transaction.setTransactionId(dto.getId());
        transaction.setType(dto.getType());
        transaction.setState(dto.getState());
        transaction.setCreatedAt(dto.getCreatedAt());
        transaction.setCompletedAt(dto.getCompletedAt());
        transaction.setReference(dto.getReference());

        return transaction;
    }

    public Transaction mapToTransactionEntity(RevolutTransactionDTO dto) {
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

    public TransactionLegs mapToTransactionLegsEntity(TransactionLegsDTO dto) {
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

    public TransactionLegs mapToTransactionLegsEntity(RevolutTransactionLegsDTO dto) {
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

    public TransactionCard mapToTransactionCardEntity(TransactionCardDTO dto) {
        if (dto == null) {
            return null;
        }

        return new TransactionCard(dto.getCardNumber(), dto.getFirstName(), dto.getLastName(), dto.getPhone());
    }

    public Merchant mapToMerchantEntity(MerchantDTO dto) {
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

    public LegsCounterparty mapToLegsCounterpartyEntity(LegsCounterpartyDTO dto) {
        LegsCounterparty legsCounterparty = new LegsCounterparty();

        legsCounterparty.setLegsCounterpartyId(dto.getId());
        legsCounterparty.setAccountId(dto.getAccountId());
        legsCounterparty.setType(dto.getType());

        return legsCounterparty;
    }

    public List<RevolutTransactionLegsDTO> mapToRevolutTransactionLegsDTOArray(List<TransactionLegs> revolutTransactionLegs) {
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS = new ArrayList<>();

        for (TransactionLegs revolutCounterpartyAccount : revolutTransactionLegs) {
            revolutTransactionLegsDTOS.add(mapToRevolutTransactionLegsDTO(revolutCounterpartyAccount));
        }

        return revolutTransactionLegsDTOS;
    }

    public List<TransactionLegs> mapToTransactionLegsEntityList(List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS) {
        List<TransactionLegs> revolutTransactionLegs = new ArrayList<>();

        for (RevolutTransactionLegsDTO revolutTransactionLegsDTO : revolutTransactionLegsDTOS) {
            revolutTransactionLegs.add(mapToTransactionLegsEntity(revolutTransactionLegsDTO));
        }

        return revolutTransactionLegs;
    }
}
