package com.tw.lambda;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		Optional<String> optionalName = Optional.of("Sam");
		
		String city = null;
	    Optional<String> optionalCity = Optional.ofNullable(city); // optionalCity will be empty
	    
	    Optional<String> emptyName = Optional.empty();

	    if (optionalName.isPresent()) {
	        System.out.println("Name is present: " + optionalName.get());
	    }

	    optionalName.ifPresent(name -> System.out.println("Name: " + name));

	    String defaultName = emptyName.orElse("Guest");
	    System.out.println("Default name: " + defaultName);

	    String generatedName = optionalCity.orElseGet(() -> "Unknown City");
	    System.out.println("Generated name: " + generatedName);

	    String requiredName = emptyName.orElseThrow(() ->
				new IllegalStateException("Name not found"));
	    System.out.println("Required name: " + requiredName);
	    
	    
	}
}
