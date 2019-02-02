package com.ranjeetbaba.rxjava;


import com.ranjeetbaba.callbackhell.Service1;
import com.ranjeetbaba.callbackhell.Service2;
import com.ranjeetbaba.callbackhell.Service3;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class RxJavaVertxStarter extends AbstractVerticle {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Service1());
        vertx.deployVerticle(new Service2());
        vertx.deployVerticle(new Service3());
        vertx.deployVerticle(new RxJavaWebVerticle());
    }

}