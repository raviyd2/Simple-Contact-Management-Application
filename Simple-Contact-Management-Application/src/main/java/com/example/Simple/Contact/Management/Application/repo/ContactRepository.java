package com.example.Simple.Contact.Management.Application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Simple.Contact.Management.Application.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findAll();

}
