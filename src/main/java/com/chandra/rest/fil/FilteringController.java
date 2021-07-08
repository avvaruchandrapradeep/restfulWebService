package com.chandra.rest.fil;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//only field1
/*	@GetMapping("/filter")
	public Beanfi retrieve()
	{
		return new Beanfi("value1", "value2");
	}
	*/
	@GetMapping("/filter")
	public MappingJacksonValue retrieve()
	{
	Beanfi beanfi = new Beanfi("value1", "value2");
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1");
	
	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	MappingJacksonValue mapping = new MappingJacksonValue(beanfi);
	mapping.setFilters(filters);
	return mapping;
	}
	//only field2
	/*@GetMapping("/filterlist")
	public List<Beanfi> retrieveList()
	{
		return Arrays.asList(new Beanfi("value1", "value2"),
				new Beanfi("value1", "value2"));
	}
	
	*/
	@GetMapping("/filterlist")
	public MappingJacksonValue retrieveList()
	{
	List<Beanfi> beanfi = Arrays.asList(new Beanfi("value1", "value2"), new Beanfi("value3", "value4"));
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2");
	
	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	MappingJacksonValue mapping = new MappingJacksonValue(beanfi);
	mapping.setFilters(filters);
	return mapping;
	}
}
