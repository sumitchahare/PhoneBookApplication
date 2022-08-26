package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer cid);
	
	public boolean updateContact(Contact contact);
}
