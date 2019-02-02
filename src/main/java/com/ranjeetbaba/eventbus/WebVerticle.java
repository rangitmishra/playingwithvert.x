package com.ranjeetbaba.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;



public class WebVerticle extends AbstractVerticle {
    public static final Logger logger = LoggerFactory.getLogger(WebVerticle.class);

    @Override
    public void start() {
        logger.info("Starting web verticle..");
        vertx.createHttpServer().requestHandler(request -> {
            JsonObject message = new JsonObject().put("text", "Hello world").put("querystring", request.query());

            logger.info("WEB-VERTICLE: Sending message from Web-Verticle" + message);
            vertx.eventBus().send(EchoServiceVerticle.ADDRESS, message, reply -> {
                JsonObject replyBody = (JsonObject) reply.result().body();
                logger.info("WEB-VERTICLE: Received reply from echo service " + replyBody);
                request.response().end(replyBody.encodePrettily());
            });

        }).listen(8080);

    }
}
