package server.undertow;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;

public class UndertowServer {
    private static final int DEFAULT_PORT = 8080;
    private static final String DEFAULT_HOST = "0.0.0.0";

    private final Undertow.Builder undertowBuilder;
    private UndertowServer(Undertow.Builder undertow) {
        this.undertowBuilder = undertow;
    }

    public Undertow.Builder getUndertow() {
        return undertowBuilder;
    }

    public Undertow start() {
        Undertow undertow = undertowBuilder.build();
        undertow.start();
        return undertow;
    }

    public static UndertowServer undertowServer(HttpHandler handler) {
        Undertow.Builder undertow = Undertow.builder()
            .setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true)
            .addHttpListener(DEFAULT_PORT, DEFAULT_HOST, handler)
        ;
        return new UndertowServer(undertow);
    }
}
