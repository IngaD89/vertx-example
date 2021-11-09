package org.example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


public class App {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

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

        httpServer
                .requestHandler(router)
                .listen(8080);
    }
}
