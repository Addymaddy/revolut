package api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by intel on 7/8/2019.
 */
public class Account {
    private String accountName;
    private String accountId;
    private Double accountBalance;


    public Account(@JsonProperty("name") String accountName,
                   @JsonProperty("id") String accountId,
                   @JsonProperty("balance") Double accountBalance) {
        this.accountName = accountName;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
