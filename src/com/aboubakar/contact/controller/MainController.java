package com.aboubakar.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aboubakar.contact.dao.ContactDao;
import com.aboubakar.contact.model.Contact;

@Controller
public class MainController {
	
	@Autowired
	private ContactDao contactDao;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) {
		
		List<Contact> listContact =contactDao.list();
		
		model.addObject("listContact", listContact);
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contactForm");
		
		return model;
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		
		if(contact.getId()==null) {
			contactDao.save(contact);
		}
		else {
			contactDao.update(contact);
		}
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDao.get(id);
		
		ModelAndView mv = new ModelAndView("contactForm");
		mv.addObject("contact", contact);
		
		return mv;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		
		contactDao.delete(id);
		return new ModelAndView("redirect:/");
		
	}
	
}
