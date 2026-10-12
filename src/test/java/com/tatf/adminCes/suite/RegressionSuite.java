package com.tatf.adminces.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Suite Regresión")
@SelectPackages("com.adminces.suite.tests")
@IncludeTags("regression")
public class RegressionSuite {
}
