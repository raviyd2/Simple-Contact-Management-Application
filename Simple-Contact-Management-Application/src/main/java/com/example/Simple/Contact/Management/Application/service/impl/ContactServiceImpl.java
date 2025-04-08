package com.example.Simple.Contact.Management.Application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Simple.Contact.Management.Application.Entity.Contact;
import com.example.Simple.Contact.Management.Application.dto.DTO;
import com.example.Simple.Contact.Management.Application.repo.ContactRepository;
import com.example.Simple.Contact.Management.Application.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public List<DTO> getAllContact() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<DTO> getContact(Long id) {
		Optional<Contact> contactOptional = contactRepository.findById(id);
		if(contactOptional.isPresent()) {
			return Optional.of(convertToDTO(contactOptional.get()));
		}
		return Optional.empty();
	}

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact updateContact(Long id, Contact upContact) {
		Optional<Contact>  updateContact = contactRepository.findById(id);
		if(updateContact.isPresent()) {
			Contact existingContact = updateContact.get();
			existingContact.setName(upContact.getName());
			existingContact.setEmail(upContact.getEmail());
			existingContact.setMob(upContact.getMob());
			
			return contactRepository.save(existingContact);
		}
		return null;
		
	}

	@Override
	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
		
	}
	
	private DTO convertToDTO(Contact contact) {
        return new DTO(contact.getId(),contact.getName(), contact.getEmail(), contact.getMob());
    }

}
