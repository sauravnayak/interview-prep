package com.interview.prep.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPOJO {
    private String name;
    private String email;
    private String gender;
    private String status;
    private Integer id;

    UserPOJO( String name, String email, String gender, String status){
        this.name=name;
        this.email=email;
        this.gender=gender;
        this.status=status;
    }

    UserPOJO() {}
    UserPOJO(String email){
        this.email=email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }

    public String getStatus(){
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
