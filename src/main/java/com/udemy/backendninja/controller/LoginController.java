package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.model.UserCredential;

@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() PARAMS: error=" + error + " logout=" + logout);
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	// @GetMapping("/login")
	// public ModelAndView showLoginForm(@RequestParam(name = "error",
	// defaultValue = "", required = false) String error) {
	// ModelAndView mav= new ModelAndView(LOGIN);
	// UserCredential uc= new UserCredential();
	// mav.addObject("userCredential", uc);
	// return mav;
	// }

	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredential") UserCredential userCredential) {

		LOG.info("METHOD: loginCheck() PARAMS: userCredential" + userCredential.toString());

		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("Returning to with error");
		return "redirect:/login?error";
	}

}
