package com.example.rest.training;

import com.example.rest.training.july2022.controller.GreetingController;
import com.example.rest.training.july2022.controller.ShapeController;
import com.example.rest.training.july2022.controller.UserController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/july2022")
public class RestAppConfig extends ResourceConfig {

    public RestAppConfig() {
        register(GreetingController.class);
        register(ShapeController.class);
        register(UserController.class);
    }
}
