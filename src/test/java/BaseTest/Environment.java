package com.test.utilities;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
	"file:${env}.properties",
	"classpath:${env}.properties"
	})
public interface Environment extends Config{
	
	String url();

    String username();

    @Key("password")
    String getPassword();

}
