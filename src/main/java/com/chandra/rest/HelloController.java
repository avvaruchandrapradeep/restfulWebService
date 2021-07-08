package com.chandra.rest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@Autowired
	private MessageSource messageSource;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping(path="/hello")
	public String helloMethod() {
		return "Hello world";
	}
	
	@GetMapping(path="/helloBean")
	public Bean helloBean() {
		return new Bean("Hel	lo entti");
	}
	//helloBean/path/chandra
	@GetMapping(path="/helloBean/path/{name}")
	public Bean helloBeanPath(@PathVariable String name) {
		return new Bean(String.format("Hello entti ,%s",name));
	}

	@GetMapping(path="/helloworld-internationalized")
	public String helloInternationalized(
			//@RequestHeader(name="Accept-Language", required=false) Locale locale
			) {
		return messageSource.getMessage("good.morning.message", null, "Default Message" ,
				//locale);
				LocaleContextHolder.getLocale());
		//return "Hello world";
	}
}
