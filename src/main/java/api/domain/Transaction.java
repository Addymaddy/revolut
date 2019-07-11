package api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by intel on 7/8/2019.
 */
public class Transaction {
    String fromAccountId;
    String toAccountId;
    Double amount;


    public Transaction(@JsonProperty("fromAccountId") String fromAccountId, @JsonProperty("toAccountId") String toAccountId,
                       @JsonProperty("amount") Double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
