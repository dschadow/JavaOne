package de.bit.camel.security;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestAlice.class, TestBob.class, TestEve.class})
public class TestAll {
}
