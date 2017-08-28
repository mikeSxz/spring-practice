package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contacts/showcontacts";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/contactform")
    String redirectContactForm(@RequestParam(name = "id", required = false, defaultValue = "0") int id, Model model) {
        ContactModel cm = new ContactModel();
        if (id != 0) {
            cm = contactService.findContacById(id);
        }

        model.addAttribute("contactModel", cm);
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    String addContact(Model model, @ModelAttribute(name = "contactModel") ContactModel contactModel) {
        LOG.info("METHOD: addContact() PARAMS: contactModel" + contactModel.toString());
        if (null != contactService.addContact(contactModel)) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }

        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    ModelAndView showContacts() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        mav.addObject("username", user.getUsername());        
        mav.addObject("contacts", contactService.listaAllContacts());
        return mav;
    }

    @GetMapping("/removecontact")
    ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
        contactService.removeContact(id);
        return showContacts();
    }

}
