package com.example.rest.training.july2022.controller;

import com.example.rest.training.july2022.entity.Employee;
import com.example.rest.training.july2022.model.User;
import com.example.rest.training.july2022.repo.EmployeeDBRepo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/users/")
public class UserController {

    @Autowired
    EmployeeDBRepo employeeDBRepo;

    // http://localhost:8080/july2022/users/1
    @GET
    @Path("{id}")
    @Produces("application/json")
    public User getUser(@PathParam("id") Integer id) {
        Employee emp = employeeDBRepo.getById(id);
        User user = new User();
        user.setId(emp.getId());
        user.setUserName(emp.getName());
        user.setCity(emp.getCity());
        user.setSalary(emp.getSalary());
        return user;
    }

    // http://localhost:8080/july2022/users/all
    @GET
    @Path("all")
    @Produces("application/json")
    public List<User> getAllUsers() {

        List<Employee> employees = employeeDBRepo.findAll();
        List<User> users = new ArrayList<>();
        for (Employee emp : employees) {
            User user = new User();
            user.setId(emp.getId());
            user.setUserName(emp.getName());
            user.setCity(emp.getCity());
            user.setSalary(emp.getSalary());
            users.add(user);
        }
        return users;
    }

    //    http://localhost:8080/july2022/users/
    @POST
    @Path("")
    @Produces("text/plain")
    @Consumes("application/json")
    public String saveUser(User user) {
        Employee emp = new Employee();
        emp.setId(user.getId());
        emp.setName(user.getUserName());
        emp.setCity(user.getCity());
        emp.setSalary(user.getSalary());
        emp.setDepartment(112);
        employeeDBRepo.save(emp);
        return "Saved successfully.";
    }

    //    http://localhost:8080/july2022/users/
    @PUT
    @Path("")
    @Produces("text/plain")
    @Consumes("application/json")
    public String updateUser(User user) {
        Employee emp = employeeDBRepo.getById(user.getId());
        emp.setSalary(user.getSalary());
        employeeDBRepo.save(emp);
        return "Updated successfully.";
    }

    //    http://localhost:8080/july2022/users/
    @DELETE
    @Path("{id}")
    @Produces("text/plain")
    @Consumes("application/json")
    public String deleteUser(@PathParam("id") Integer id) {
        employeeDBRepo.deleteById(id);
        return "Deleted successfully.";
    }
}
