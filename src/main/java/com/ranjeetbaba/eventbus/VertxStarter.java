package com.ranjeetbaba.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class VertxStarter extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new EchoServiceVerticle());
        vertx.deployVerticle(new WebVerticle());
    }
}
