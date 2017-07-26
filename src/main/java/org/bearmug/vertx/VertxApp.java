package org.bearmug.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.bearmug.FibonacciCalc;

public class VertxApp {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);

        router.get("/fibonacci-vertx").handler(rc -> {
            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("res",
                            new FibonacciCalc().fibonacci(Integer.parseInt(rc.request().getParam("base")))).encode());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8070, event -> {
            if (event.succeeded()) {
                System.out.println("Started VertxApp");
            }
        });
    }

}
