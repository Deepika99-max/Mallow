package com.mallow.automation.models;

public class UserData {

    private final String employeeId;
    private final String name;
    private final String email;
    private final String phone;
    private final String password;
    private final String department;
    private final String office;

    public UserData(
            String employeeId,
            String name,
            String email,
            String phone,
            String password,
            String department,
            String office
    ) {

        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.department = department;
        this.office = office;
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

    public String getDepartment() {
        return department;
    }

    public String getOffice() {
        return office;
    }
}