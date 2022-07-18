package com.example.rest.training.apr2022.controller;

import com.example.rest.training.apr2022.entity.Employee;
import com.example.rest.training.apr2022.model.User;
import com.example.rest.training.apr2022.repo.EmployeeRepo;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

@Path("users")
public class UserController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // http://localhost:8080/api/users/new
    @GET
    @Path("/new")
    @Produces("application/json")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("Rahul");
        user.setCity("Delhi");
        return user;
    }

    // http://localhost:8080/api/users/
    @GET
    @Path("/")
    @Produces("application/json")
    public List<User> getUsers(){
        List<Employee> employees = employeeRepo.findAll();
        System.out.println("Got rows from DB: " + employees.size());
        List<User> users = employees.parallelStream().map(e -> {
            User user = new User();
            user.setId(e.getId());
            user.setName("Mr. "+e.getName());
            user.setCity(e.getCity());
            user.setSalary(e.getSalary());
            user.setDept(e.getDepartment());
            user.setIncentive(e.getIncentive());
            return user;
        }).collect(Collectors.toList());
        return users;
    }

    // http://localhost:8080/api/users/
    @POST
    @Path("/")
    @Produces("application/json")
    public User saveUser(User user){
        Employee emp = new Employee();
        emp.setId(user.getId());
        emp.setName(user.getName());
        emp.setCity(user.getCity());
        emp.setSalary(user.getSalary());
        emp.setDepartment(user.getDept());
        emp.setIncentive(user.getIncentive());
        employeeRepo.save(emp);
        return user;
    }

    // http://localhost:8080/api/users/
    @DELETE
    @Path("/{id}")
    public String saveUser(@PathParam("id") Integer id){
        employeeRepo.deleteById(id);
        return "User deleted with id " + id;
    }

}
