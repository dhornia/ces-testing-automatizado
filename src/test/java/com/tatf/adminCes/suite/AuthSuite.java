package com.tatf.adminces.suite;

import com.tatf.adminces.suite.tests.LoginTest;
import com.tatf.adminces.suite.tests.PasswordResetTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Suite Autenticación")
@SelectClasses({
        LoginTest.class,
        PasswordResetTest.class
})
public class AuthSuite {
}
