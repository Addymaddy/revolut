package api.dao;

import api.domain.Account;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by intel on 7/8/2019.
 */
public class AccountDao {
    private final ConcurrentMap<String, Account> accountRepo;

    public AccountDao() {
        this.accountRepo = new ConcurrentHashMap<>();
    }

    public Account createAccount(Account account) {
        if(!accountRepo.containsKey(account.getAccountId()))
        {
            accountRepo.put(account.getAccountId(), account);
            return account;
        }
        return null;
    }

    public Account getAccount(String accountId) {
        if(accountRepo.containsKey(accountId))
        {
            return accountRepo.get(accountId);
        }
        return null;
    }
}
