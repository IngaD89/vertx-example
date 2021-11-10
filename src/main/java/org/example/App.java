package org.example;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import org.example.verticles.VerticalToDeploy;


public class App {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new VerticalToDeploy(),
                new DeploymentOptions()
                        .setConfig(new JsonObject()
                                .put("port", 3000)
                        )
        );
}
}
