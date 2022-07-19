package com.example.rest.training.july2022.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/shape/")
public class ShapeController {

    // http://localhost:8080/july2022/shape/areaOfCircle
    @GET
    @Path("areaOfCircle")
    public String areaOfCircle(@QueryParam("rad") Double radius, @QueryParam("display") String displayString) {
        System.out.println("Computing area of circle with radius " + radius);
        return displayString + " : "  + Math.PI * radius * radius;
    }

    // http://localhost:8080/july2022/shape/areaOfSquare/12?display=AreaOfSquare
    @GET
    @Path("areaOfSquare/{side}")
    public String areaOfSquare(@PathParam("side") Double side, @QueryParam("display") String displayString) {
        System.out.println("Computing area of square with side " + side);
        return displayString + " : "  + (side * side);
    }
}
