package server.undertow.handlers;


import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.BlockingHandler;

public class Middleware {

    public static HttpHandler common(HttpHandler root) {
        return
        MiddlewareBuilder.begin(BlockingHandler::new)
                .complete(root);
    }
}
