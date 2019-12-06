package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.MachineDAO;
import net.codejava.spring.model.Machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private MachineDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Machine> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Machine newContact = new Machine();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Machine contact) {
		contactDAO.saveOrUpdate(contact);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Machine contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		
		return model;
	}
}
