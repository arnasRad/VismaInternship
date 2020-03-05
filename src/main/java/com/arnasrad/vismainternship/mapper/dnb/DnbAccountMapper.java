package com.arnasrad.vismainternship.mapper.dnb;

import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbBalance;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbBalanceAmount;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DnbAccountMapper {

    public DnbAccountDto mapToAccountDto(Account entity) {
        DnbAccountDto accountDto = new DnbAccountDto();

        DnbBalanceAmount dnbBalanceAmount = new DnbBalanceAmount();
        dnbBalanceAmount.setAmount(String.valueOf(entity.getBalance()));
        dnbBalanceAmount.setCurrency(entity.getCurrency());

        DnbBalance dnbBalance = new DnbBalance();
        dnbBalance.setBalanceAmount(dnbBalanceAmount);

        accountDto.setName(entity.getName());
        accountDto.setBalances(Collections.singletonList(dnbBalance));
        accountDto.setCurrency(entity.getCurrency());
        accountDto.setName(entity.getName());

        return accountDto;
    }

    public AccountDto mapToAccountDto(DnbAccountDto dnbAccountDto) {
        AccountDto accountDto = new AccountDto();

        accountDto.setIban(dnbAccountDto.getIban());
        DnbBalance balance = dnbAccountDto.getBalances().get(0);
        DnbBalanceAmount balanceAmount = balance.getBalanceAmount();

        accountDto.setBalance(balanceAmount.getAmount());
        accountDto.setCurrency(dnbAccountDto.getCurrency());

        return accountDto;
    }

    public List<AccountDto> mapToAccountDtoList(List<DnbAccountDto> dnbAccountDtoList) {
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(DnbAccountDto dnbAccountDto : dnbAccountDtoList) {
            AccountDto accountDto = mapToAccountDto(dnbAccountDto);
            accountDtoList.add(accountDto);
        }

        return accountDtoList;
    }

    public Account mapToAccountEntity(DnbAccountDto dto) {
        Account account = new Account();

        DnbBalanceAmount dnbBalanceAmount = dto.getBalances().get(0).getBalanceAmount();

        account.setName(dto.getName());
        account.setBalance(Double.valueOf(dnbBalanceAmount.getAmount()));
        account.setCurrency(dnbBalanceAmount.getCurrency());
        account.setState(dto.getStatus().getStatus());

        return account;
    }
}
