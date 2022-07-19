package com.example.rest.training.july2022.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {
 *    name: '',
 *    id: ,
 *    city: '',
 *    salary:
 * }
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "user")
public class User {

    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "name")
    private String userName;

    @XmlElement(name = "city")
    private String city;

    @XmlElement(name = "emp_salary")
    private Integer salary;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
