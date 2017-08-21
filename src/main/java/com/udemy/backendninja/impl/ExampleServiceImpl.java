package com.udemy.backendninja.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Mike",30));
		people.add(new Person("Enrique",31));
		people.add(new Person("Luis",32));
		people.add(new Person("Francisco",35));
		people.add(new Person("Omar",33));
		people.add(new Person("Alejandro",34));
		people.add(new Person("Gabriel",29));
		people.add(new Person("Lidia",35));
		people.add(new Person("Brianda",27));
		people.add(new Person("Karla",29));
		LOG.info("HELLO FROM SERVICE::: EXAMPLESERVICE");
		return people;
	}

}
