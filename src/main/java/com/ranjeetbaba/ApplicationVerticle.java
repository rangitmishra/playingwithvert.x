package com.ranjeetbaba;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Hello world!
 *
 */
public class ApplicationVerticle extends AbstractVerticle {

    @Override
    public  void start(Future<Void> startFuture) {
            vertx.createHttpServer()
                    .requestHandler(r -> {
                        r.response().end("<h1>My first vertx application.</h1>");

            })
                    .listen(8888, resp -> {
                if(resp.succeeded()) {
                    startFuture.complete();
                } else {
                    startFuture.fail("Http server didn't start...");
                }
            });
    }
}
