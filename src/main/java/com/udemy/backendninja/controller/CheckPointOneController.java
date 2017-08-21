package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.service.CheckPointOneService;


@Controller
@RequestMapping("/ejercicio")
public class CheckPointOneController {
	public static final String URL1 = "checkpoint1-1";
	public static final String URL2 = "checkpoint1-2";
	private static final Log LOGGER = LogFactory.getLog(PeticionesPostController.class);

	@Autowired
	@Qualifier("checkPointOneService")
	private CheckPointOneService checkPointOneService;

	@GetMapping("/checkpointone1")
	public String showForm() {
		return URL1;
	}

	@PostMapping("/checkpointone2")
	public ModelAndView getForm() {
		long timeinit= System.currentTimeMillis();
		ModelAndView mav = new ModelAndView(URL2);
		checkPointOneService.printLog();
		mav.addObject("mensaje", "Este es el mensaje desde el metodo 2");
		LOGGER.info("este controller tardó: "+ (System.currentTimeMillis()-timeinit)+ "ms en procesar");
		return mav;
	}

}
