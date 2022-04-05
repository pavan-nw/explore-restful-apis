package com.example.rest.training;

import com.example.rest.training.controller.GreetController;
import com.example.rest.training.controller.ShapeController;
import com.example.rest.training.controller.UserController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class RestAppConfig extends ResourceConfig {

    public RestAppConfig() {
        register(GreetController.class);
        register(ShapeController.class);
        register(UserController.class);
    }
}
