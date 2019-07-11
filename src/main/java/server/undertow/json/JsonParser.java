package server.undertow.json;

import com.fasterxml.jackson.core.type.TypeReference;
import io.undertow.server.HttpServerExchange;

public interface JsonParser {

    default <T> T parseJson(HttpServerExchange exchange, TypeReference<T> typeRef) {
        return Json.serializer().fromInputStream(exchange.getInputStream(), typeRef);
    }
}
