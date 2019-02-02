package com.ranjeetbaba.callbackhell;

import io.vertx.core.AbstractVerticle;

public class Service3 extends AbstractVerticle {
    public static final String ADDRESS = "service3";


    @Override
    public void start() {
        vertx.eventBus().consumer(ADDRESS, event -> {
            String message = (String) event.body();
            event.reply(message + " -[passed through service3]");
        });

    }
}
