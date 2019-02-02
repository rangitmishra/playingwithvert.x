package com.ranjeetbaba.callbackhell;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;

public class RequestHandler implements Handler<HttpServerRequest> {

    private Vertx vertx;

    public RequestHandler(Vertx vertex) {
        this.vertx = vertex;
    }

    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        vertx.eventBus().send(Service1.ADDRESS, "message to service1", reply1 -> {
            String replyFromService1 = (String) reply1.result().body();
            vertx.eventBus().send(Service2.ADDRESS, "message to service2", reply2 -> {
                String replyFromService2 = (String) reply2.result().body();
                String combinedResult = replyFromService1 + "  " + replyFromService2;
                vertx.eventBus().send(Service3.ADDRESS, combinedResult, reply3 -> {
                    httpServerRequest.response().end("Response from callback web verticle: " + reply3.result().body());
                });
            });
        });
    }
}
