package com.test.utilities;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEnv {
	
	Environment testEnvironment;

    @Test
    public void functionalTest() {
        System.out.println(testEnvironment.url());
        System.out.println(testEnvironment.username());
        System.out.println(testEnvironment.getPassword());
    }

    @BeforeTest
    @Parameters({"environment"})
    public void beforeTest(String environemnt) {
    	ConfigFactory.setProperty("env", environemnt);
    	testEnvironment=ConfigFactory.create(Environment.class);
    }

}
