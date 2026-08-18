package com.mallow.automation.utils;

import com.mallow.automation.constants.AppConstants;
import com.mallow.automation.models.UserData;

import java.util.UUID;

public class TestDataGenerator {

    private TestDataGenerator() {
    }

    public static UserData generateUser() {

        String uniqueId =
                UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 8);

        String employeeId =
                "EMP" + uniqueId;

        String name =
                AppConstants.DEFAULT_NAME;

        String email = "mallow" + uniqueId + "@gmail.com";

        String phone =
                "9" + String.valueOf(
                        System.currentTimeMillis()
                ).substring(3);

        String password = "Test@12345678";

        String department =
                AppConstants.DEFAULT_DEPARTMENT;

        String office =
                AppConstants.DEFAULT_OFFICE;

        String emailLogin = "deepikajoe99@gmail.com";
        String passwordLogin = "Test@12345678";

        return new UserData(
                employeeId,
                name,
                email,
                phone,
                password,
                department,
                office,
                emailLogin,
                passwordLogin
        );
    }
}