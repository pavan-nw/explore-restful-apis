package com.example.rest.training;

import com.example.rest.training.apr2022.controller.GreetController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class RestAppConfig extends ResourceConfig {

    public RestAppConfig() {
        register(GreetController.class);
    }
}
