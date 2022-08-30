package com.server.config.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

	@Autowired
	private Environment env;
	
	@Value("${my.configuration.greeting.person:dummy}")
	private String configGreetingPerson;
	
	
	@RequestMapping("config")
	public void configDetail() {
		
		String str = env.toString();
		System.out.println(str);
		System.out.println(configGreetingPerson);
	}
}
