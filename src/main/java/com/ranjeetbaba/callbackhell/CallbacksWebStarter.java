package com.ranjeetbaba.callbackhell;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class CallbacksWebStarter extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Service1());
        vertx.deployVerticle(new Service2());
        vertx.deployVerticle(new Service3());
        vertx.deployVerticle(new CallbacksWebVerticle());
    }
}
