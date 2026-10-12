package com.tatf.adminces.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Suite Smoke")
@SelectPackages("com.adminces.suite.tests")
@IncludeTags("smoke")
public class SmokeSuite {
}

