package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.mapper.transaction.TransactionCardMapper;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.Merchant;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.RevolutTransaction;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.RevolutTransactionLegs;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionCard;

import java.util.List;


public class RevolutTransactionMapper {

    private final MerchantMapper merchantMapper;
    private final RevolutTransactionLegsMapper revolutTransactionLegsMapper;
    private final TransactionCardMapper transactionCardMapper;

    public RevolutTransactionMapper(MerchantMapper merchantMapper, RevolutTransactionLegsMapper revolutTransactionLegsMapper, TransactionCardMapper transactionCardMapper) {
        this.merchantMapper = merchantMapper;
        this.revolutTransactionLegsMapper = revolutTransactionLegsMapper;
        this.transactionCardMapper = transactionCardMapper;
    }

    public RevolutTransactionDTO mapToDTO(RevolutTransaction entity) {
        MerchantDTO merchantDTO = merchantMapper.mapToDTO(entity.getMerchant());
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOList =
                revolutTransactionLegsMapper.mapToDTOArray(entity.getRevolutTransactionLegs());
        TransactionCardDTO transactionCardDTO = transactionCardMapper.mapToDTO(entity.getCard());

        return new RevolutTransactionDTO(entity.getRequestId(), entity.getType(), entity.getState(),
                entity.getCreatedAt(), entity.getCompletedAt(), entity.getReference(), entity.getRequestId(),
                entity.getReasonCode(), entity.getUpdatedAt(), entity.getScheduledFor(),
                entity.getRelatedTransactionId(), merchantDTO, revolutTransactionLegsDTOList, transactionCardDTO);
    }

    public RevolutTransaction mapToEntity(RevolutTransactionDTO dto) {
        Merchant merchant = merchantMapper.mapToEntity(dto.getMerchant());
        List<RevolutTransactionLegs> revolutTransactionLegs =
                revolutTransactionLegsMapper.mapToEntityList(dto.getRevolutTransactionLegs());
        TransactionCard transactionCard = transactionCardMapper.mapToEntity(dto.getCard());

        return new RevolutTransaction(dto.getRequestId(), dto.getType(), dto.getState(), dto.getCreatedAt(),
                dto.getCompletedAt(), dto.getReference(), dto.getRequestId(), dto.getReasonCode(),
                dto.getUpdatedAt(), dto.getScheduledFor(), dto.getRelatedTransactionId(), merchant,
                revolutTransactionLegs, transactionCard);
    }
}
