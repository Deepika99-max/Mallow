package com.mallow.automation.utils;

import com.mallow.automation.models.UserData;

import java.util.UUID;

public class TestDataGenerator {

    public static UserData generateUser() {

        String uniqueId =
                UUID.randomUUID().toString().replace("-", "").substring(0, 8);

        String employeeId = "EMP" + uniqueId;

        String name = "Mallow Test";

        String email =
                "mallow" + uniqueId + "@gmail.com";

        String phone =
                "9" + String.valueOf(
                        System.currentTimeMillis()
                ).substring(3);

        String password = "Test@12345";

        return new UserData(
                employeeId,
                name,
                email,
                phone,
                password
        );
    }
}