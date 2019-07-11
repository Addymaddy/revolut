package api.request;

import api.domain.Account;
import api.domain.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import io.undertow.server.HttpServerExchange;
import server.undertow.exchange.Exchange;

/**
 * Created by intel on 7/8/2019.
 */
public class TransferRequest {

    public static Transaction getTransaction(HttpServerExchange exchange) {
        return Exchange.body().parseJson(exchange, new TypeReference<Transaction>() {});
    }
}
