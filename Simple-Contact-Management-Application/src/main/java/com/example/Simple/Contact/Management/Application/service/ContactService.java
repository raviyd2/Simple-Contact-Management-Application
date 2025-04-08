package com.example.Simple.Contact.Management.Application.service;

import java.util.List;
import java.util.Optional;

import com.example.Simple.Contact.Management.Application.Entity.Contact;
import com.example.Simple.Contact.Management.Application.dto.DTO;

public interface ContactService {
	List<DTO> getAllContact();
	Optional<DTO> getContact(Long id);
	Contact saveContact(Contact contact);
	void deleteContact(Long id);
	Contact updateContact(Long id, Contact upContact);

}
