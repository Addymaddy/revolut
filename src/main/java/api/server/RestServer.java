package api.server;


import api.service.AccountService;
import io.undertow.server.RoutingHandler;
import server.undertow.UndertowServer;
import server.undertow.handlers.Middleware;


public class RestServer {

    public static final RoutingHandler ROUTES = new RoutingHandler()
        .post("/accounts", AccountService::createAccount)
        .get("/accounts/{accountId}", AccountService::getAccount)
        .post("/accounts/transfer", AccountService::transfer);

    public static void main(String[] args) {
        UndertowServer server = UndertowServer.undertowServer(Middleware.common(ROUTES));
        server.start();
    }
}
