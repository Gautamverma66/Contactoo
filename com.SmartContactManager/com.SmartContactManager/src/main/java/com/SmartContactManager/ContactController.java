package com.SmartContactManager;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ContactController {
	
//	@Autowired
	ServiceContact serviceContact = new ServiceContact();
//	showing all the contacts
	@GetMapping("/showContact")
	public List<Contact> showContact() throws ClassNotFoundException, SQLException
	{
		return serviceContact.getContact();
	}
	
	@PostMapping("/addContact")
	public Map addContact(Contact contact) throws ClassNotFoundException, SQLException
	{
		return serviceContact.addContact(contact);
	}
	
	@PostMapping("/deleteContact")
	public Map deleteContact(String mobile_number) throws ClassNotFoundException, SQLException
	{
		return serviceContact.delete(mobile_number);
	}
	
	
	
	@PostMapping("/updateContact")
	public Map updateContact(Contact contact) throws ClassNotFoundException, SQLException
	{
		return serviceContact.updateContact(contact);
	}

////	Delete Contact from contact list
//		
//		@GetMapping("/deleteContact/{contactId}")
//		public ResponseEntity<HttpStatus> deleteContact(@PathVariable String contactId)
//		{
//			try {
//				return serviceContact.delete(mobile_number);
//			     return new ResponseEntity<>(HttpStatus.OK);
//			}
//			catch(Exception e)
//			{
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
	
	@PostMapping("/feedback")
	public Map feedbackForm(Contact contact) throws ClassNotFoundException, SQLException
	{
		return serviceContact.feedbackForm(contact);
	}
	
//	search api
	
	@PostMapping("/search")
	public  Map search(Contact mobile_number) throws ClassNotFoundException, SQLException
	{
		return serviceContact.search(mobile_number);
	}
}
