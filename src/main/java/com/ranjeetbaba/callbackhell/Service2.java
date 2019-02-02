package com.ranjeetbaba.callbackhell;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Service2 extends AbstractVerticle {

    public static final Logger logger = LoggerFactory.getLogger(Service2.class);
    public static final String ADDRESS = "service2";

    @Override
    public void start() {
        vertx.eventBus().consumer(ADDRESS, event -> event.reply("reply-from-service2"));
    }

}