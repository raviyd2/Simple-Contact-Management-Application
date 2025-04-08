package com.example.Simple.Contact.Management.Application.dto;

import lombok.Data;

@Data
public class DTO {

	private Long id;
	private String name;
	private String email;
	private Long mob;
	
	public DTO(Long id, String name, String email, Long mob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mob = mob;
	}
	

}
