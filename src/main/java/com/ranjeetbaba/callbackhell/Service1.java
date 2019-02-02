package com.ranjeetbaba.callbackhell;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Service1 extends AbstractVerticle {

    public static final Logger logger = LoggerFactory.getLogger(Service1.class);
    public static final String ADDRESS = "service1";

    @Override
    public void start() {
        vertx.eventBus().consumer(ADDRESS, event -> event.reply("reply-from-service1"));
    }

}
