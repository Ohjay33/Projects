package com.ohjay.currency;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //allows me to make a request and get a  response

//@RequestMapping("/joke")    //makes every route start with "joke"
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to Proctor & Moore Application!";
	} 
	
	@RequestMapping("/joke/jokes")
	public String funny() {
		return "Sike no Joke, Fuck You!!!";
	}
	
	@RequestMapping("/joke/facts")
	public String fact() {
		return "Obama used to live in Chi Town! !!!";
	}
	
	@RequestMapping("/name")
	public String name(@RequestParam(value="q", required=false)String info) {
		System.out.println("This is the name of our newest member: " + info);
		return "Hello there !!!";
	}
	

}
