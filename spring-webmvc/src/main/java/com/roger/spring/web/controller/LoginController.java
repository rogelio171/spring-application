package com.roger.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	private static final String info = "\n" +
			"IIIIIIIIII       tttt                                                                                          kkkkkkkk                           !!!  !!! \n" + 
			"I::::::::I    ttt:::t                                                                                          k::::::k                          !!:!!!!:!!\n" + 
			"I::::::::I    t:::::t                                                                                          k::::::k                          !:::!!:::!\n" + 
			"II::::::II    t:::::t                                                                                          k::::::k                          !:::!!:::!\n" + 
			"  I::::Ittttttt:::::ttttttt         wwwwwww           wwwww           wwwwwww ooooooooooo   rrrrr   rrrrrrrrr   k:::::k    kkkkkkk  ssssssssss   !:::!!:::!\n" + 
			"  I::::It:::::::::::::::::t          w:::::w         w:::::w         w:::::woo:::::::::::oo r::::rrr:::::::::r  k:::::k   k:::::k ss::::::::::s  !:::!!:::!\n" + 
			"  I::::It:::::::::::::::::t           w:::::w       w:::::::w       w:::::wo:::::::::::::::or:::::::::::::::::r k:::::k  k:::::kss:::::::::::::s !:::!!:::!\n" + 
			"  I::::Itttttt:::::::tttttt            w:::::w     w:::::::::w     w:::::w o:::::ooooo:::::orr::::::rrrrr::::::rk:::::k k:::::k s::::::ssss:::::s!:::!!:::!\n" + 
			"  I::::I      t:::::t                   w:::::w   w:::::w:::::w   w:::::w  o::::o     o::::o r:::::r     r:::::rk::::::k:::::k   s:::::s  ssssss !:::!!:::!\n" + 
			"  I::::I      t:::::t                    w:::::w w:::::w w:::::w w:::::w   o::::o     o::::o r:::::r     rrrrrrrk:::::::::::k      s::::::s      !:::!!:::!\n" + 
			"  I::::I      t:::::t                     w:::::w:::::w   w:::::w:::::w    o::::o     o::::o r:::::r            k:::::::::::k         s::::::s   !!:!!!!:!!\n" + 
			"  I::::I      t:::::t    tttttt            w:::::::::w     w:::::::::w     o::::o     o::::o r:::::r            k::::::k:::::k  ssssss   s:::::s  !!!  !!! \n" + 
			"II::::::II    t::::::tttt:::::t             w:::::::w       w:::::::w      o:::::ooooo:::::o r:::::r           k::::::k k:::::k s:::::ssss::::::s          \n" + 
			"I::::::::I    tt::::::::::::::t              w:::::w         w:::::w       o:::::::::::::::o r:::::r           k::::::k  k:::::ks::::::::::::::s  !!!  !!! \n" + 
			"I::::::::I      tt:::::::::::tt               w:::w           w:::w         oo:::::::::::oo  r:::::r           k::::::k   k:::::ks:::::::::::ss  !!:!!!!:!!\n" + 
			"IIIIIIIIII        ttttttttttt                  www             www            ooooooooooo    rrrrrrr           kkkkkkkk    kkkkkkksssssssssss     !!!  !!!";
	
	@GetMapping("/")
	public String login() {
		
		
		LOGGER.info(info);

		return "home";

	}
	
	@GetMapping("/table")
	public String datatable() {
		LOGGER.info("Inside datatable method");
		return "table";
	}
	
	@PostMapping("/redirect")
	public ModelAndView buttonAction(Model model) {
		return new ModelAndView("redirect:/table");
	}
	
	/*@GetMapping
	@RequestMapping(value = {"/showMessage/{msg}"})
	public String showMessageByPathVariable(@PathVariable String msg, ModelMap model){
		LOGGER.info("The message by pathVariable is :"+msg);		
		
		model.addAttribute("newMsg", msg);
		
		return indexPage;
	}
	
	@GetMapping
	@RequestMapping(value = {"/showMessage"})
	public String showMessageByRequestParameter(@RequestParam String msg, ModelMap model){
		LOGGER.info("The message by requesParameter is :"+msg);		
		
		model.addAttribute("newMsg", msg);
		
		return indexPage;
	}*/
	

}