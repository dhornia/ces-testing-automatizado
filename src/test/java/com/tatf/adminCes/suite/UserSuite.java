package com.tatf.adminces.suite;

import com.tatf.adminces.suite.tests.AdminCreateTest;
import com.tatf.adminces.suite.tests.TesterCreateTest;
import com.tatf.adminces.suite.tests.TesterDeleteTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Suite Usuario")
@SelectClasses({
        AdminCreateTest.class,
        TesterCreateTest.class,
        TesterDeleteTest.class
})
public class UserSuite {
}
