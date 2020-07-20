package com.example.demo.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person1 {

	private final UUID id;
	@NotBlank
	private final String name;
	public Person1(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
