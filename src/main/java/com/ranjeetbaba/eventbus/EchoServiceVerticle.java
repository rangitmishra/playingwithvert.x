package com.ranjeetbaba.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class EchoServiceVerticle extends AbstractVerticle {

    public static final Logger logger = LoggerFactory.getLogger(WebVerticle.class);
    public static  final String ADDRESS = "echo-service";

    @Override
    public void start() {
        logger.info("Starting echo-service");
        vertx.eventBus().consumer(ADDRESS, message ->  {
            JsonObject messageBody = (JsonObject) message.body();
            logger.info("ECHO-SERVICE: Received message: " + messageBody);
            messageBody.put("passthrough", "echo-service");

            logger.info("ECHO-SERVICE: Reply from echo-service " + messageBody);
            message.reply(messageBody);
        });

    }
}
