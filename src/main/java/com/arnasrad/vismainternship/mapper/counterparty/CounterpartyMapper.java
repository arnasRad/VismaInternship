package com.arnasrad.vismainternship.mapper.counterparty;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;

import java.util.List;

public class CounterpartyMapper {

    private final CounterpartyAccountMapper counterpartyAccountMapper;

    private CounterpartyMapper(CounterpartyAccountMapper counterpartyAccountMapper) {
        this.counterpartyAccountMapper = counterpartyAccountMapper;
    }

    public CounterpartyDTO mapToDTO(Counterparty entity) {
        List<CounterpartyAccountDTO> counterpartyAccountDTOS =
                counterpartyAccountMapper.mapToDTOArray(entity.getAccounts());

        return new CounterpartyDTO(entity.getCountry(), entity.getCounterpartyId(), entity.getName(),
                entity.getPhone(), counterpartyAccountDTOS);
    }

    public Counterparty mapToEntity(CounterpartyDTO dto) {
        List<CounterpartyAccount> counterpartyAccounts = counterpartyAccountMapper.mapToEntityList(dto.getAccounts());

        return new Counterparty(dto.getCountry(), dto.getId(), dto.getName(), dto.getPhone(), counterpartyAccounts);
    }
}
