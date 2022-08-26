package com.BikkadIT.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Contact;
import com.BikkadIT.service.ContactServiceI;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value="/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
	boolean saveContact = contactServiceI.saveContact(contact);
	
	if(saveContact == true) {
		String msg="Contact save successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}else {
		String msg="Contact not save Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}
}
	
	@GetMapping(value="/getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		
		List<Contact> allContact = contactServiceI.getAllContact();
		
		if(allContact != null) {
			return new ResponseEntity<List<Contact>>(allContact, HttpStatus.OK);
		}else {
		String msg="Data not found";
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/getContactById/{cid}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cid){
		Contact contactById = contactServiceI.getContactById(cid);		
		return new ResponseEntity<Contact>(contactById, HttpStatus.OK);
	}
	
	@PutMapping(value="/updateContact", consumes = "application/json")
	public ResponseEntity<String> UpdateContact(@RequestBody Contact contact){
	boolean saveContact = contactServiceI.saveContact(contact);
	
	if(saveContact == true) {
		String msg="Contact Updated successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}else {
		String msg="Contact not Updated Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}
}
	
}
