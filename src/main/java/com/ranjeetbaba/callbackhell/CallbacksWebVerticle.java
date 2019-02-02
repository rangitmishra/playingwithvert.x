package com.ranjeetbaba.callbackhell;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class CallbacksWebVerticle extends AbstractVerticle {
    public static final Logger log = LoggerFactory.getLogger(Service1.class);

    public void start() {
        log.info("Starting callbacks verticle..");

        vertx.createHttpServer().requestHandler(new RequestHandler(this.vertx)).listen(8080);

    }

}

