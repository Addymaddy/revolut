package api.request;

import api.domain.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import io.undertow.server.HttpServerExchange;
import server.undertow.exchange.Exchange;

import java.lang.reflect.Type;

/**
 * Created by intel on 7/8/2019.
 */
public class AccountRequest {

    public static Account getAccount(HttpServerExchange exchange) {
        return Exchange.body().parseJson(exchange, new TypeReference<Account>() {});
    }


    public static String accountid(HttpServerExchange exchange) {
        return Exchange.pathParams().pathParam(exchange, "accountId").orElse(null);
    }
}
