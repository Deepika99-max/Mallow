package com.mallow.automation.models;

public class UserData {

    private final String employeeId;
    private final String name;
    private final String email;
    private final String phone;
    private final String password;

    public UserData(
            String employeeId,
            String name,
            String email,
            String phone,
            String password) {

        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}