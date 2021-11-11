package org.example.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class VerticalToDeploy extends AbstractVerticle {

    public void start() {
        Router router = Router.router(vertx);
        HttpServer server = vertx.createHttpServer();

        Route handler1 = router
                .get("/hello")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Hello from vertx\n");
                    response.end("ended");
                });
        Route handler2 = router
                .post("/hello")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Hello from vertx\n");
                    response.end("posted");
                });

        server.requestHandler(router).listen(config().getInteger("port"));
    }
}

