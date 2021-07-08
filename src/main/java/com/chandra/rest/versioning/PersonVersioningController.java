package com.chandra.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/Person")
	public PersonV1 personV1() {
		return new PersonV1("chandra pradeep");
	}
	
	@GetMapping("/v2/Person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("chandra","pradeep"));
	}
	
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 personV11() {
		return new PersonV1("chandra pradeep");
	}
	
	@GetMapping(path="/person/param", params="version=2")
	public PersonV2 personV21() {
		return new PersonV2(new Name("chandra","pradeep"));
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("chandra pradeep");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("chandra","pradeep"));
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producerV1() {
		return new PersonV1("chandra pradeep");
	}
	
	@GetMapping(path="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producerV2() {
		return new PersonV2(new Name("chandra","pradeep"));
	}
}
