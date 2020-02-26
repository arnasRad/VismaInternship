package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.entity.transaction.Merchant;
import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionCard;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionLegs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RevolutTransactionMapper {

    private final MerchantMapper merchantMapper;
    private final RevolutTransactionLegsMapper revolutTransactionLegsMapper;
    private final TransactionCardMapper transactionCardMapper;

    public RevolutTransactionMapper(MerchantMapper merchantMapper, RevolutTransactionLegsMapper revolutTransactionLegsMapper, TransactionCardMapper transactionCardMapper) {
        this.merchantMapper = merchantMapper;
        this.revolutTransactionLegsMapper = revolutTransactionLegsMapper;
        this.transactionCardMapper = transactionCardMapper;
    }

    public RevolutTransactionDTO mapToDTO(Transaction entity) {
        MerchantDTO merchantDTO = merchantMapper.mapToDTO(entity.getMerchant());
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOList =
                revolutTransactionLegsMapper.mapToDTOArray(entity.getTransactionLegs());
        TransactionCardDTO transactionCardDTO = transactionCardMapper.mapToDTO(entity.getCard());

        return new RevolutTransactionDTO(entity.getRequestId(), entity.getType(), entity.getState(),
                entity.getCreatedAt(), entity.getCompletedAt(), entity.getReference(), entity.getRequestId(),
                entity.getReasonCode(), entity.getUpdatedAt(), entity.getScheduledFor(),
                entity.getRelatedTransactionId(), merchantDTO, revolutTransactionLegsDTOList, transactionCardDTO);
    }

    public Transaction mapToEntity(RevolutTransactionDTO dto) {
        Merchant merchant = merchantMapper.mapToEntity(dto.getMerchant());
        List<TransactionLegs> revolutTransactionLegs =
                revolutTransactionLegsMapper.mapToEntityList(dto.getRevolutTransactionLegs());
        TransactionCard transactionCard = transactionCardMapper.mapToEntity(dto.getCard());

        return new Transaction(dto.getRequestId(), dto.getType(), dto.getState(), dto.getCreatedAt(),
                dto.getCompletedAt(), dto.getReference(), dto.getRequestId(), dto.getReasonCode(),
                dto.getUpdatedAt(), dto.getScheduledFor(), dto.getRelatedTransactionId(), merchant,
                revolutTransactionLegs, transactionCard);
    }
}
