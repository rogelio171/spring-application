package com.roger.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roger.spring.model.Book;
import com.roger.spring.repository.BookRepository;

@Controller
public class BookController {
	private static final String HOME = "\n..:: Home ::..\n";
	private static final String BUTTON_ACTION_METHOD_MSG = "\n>> Redirecting to table view...\n";
	private static final String DATATABLE_METHOD_MSG = "\n>> Refreshing table view...\n";
	private static final String GETBOOKGRID_METHOD_MSG = "\n>> Loading data into table...\n";
	private static final String SAVEBOOK_METHOD_MSG = "\n>> Saving book...\n";

	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	protected BookRepository bookRepository;
	
	@GetMapping("/")
	public String home() {		
		LOGGER.info(HOME);

		return "home";

	}
	
	@GetMapping("/table")
	public ModelAndView datatable(ModelAndView model) {
		LOGGER.info(DATATABLE_METHOD_MSG);
		model.setViewName("table");
		
		return model;
	}
	
	@GetMapping("/datatables/ajax")
	public @ResponseBody String getBookGrid(HttpServletRequest request, HttpSession session, ModelMap model) {
		
		LOGGER.info(GETBOOKGRID_METHOD_MSG);
		List<Book> books = bookRepository.findAll();
		
		JSONArray data = new JSONArray();
		JSONObject jsonResponse = new JSONObject();
		
		try {
			if(books != null) {
				for (Book book: books) {
					JSONArray row  = new JSONArray();
					row.put(book.getIsbn())
					   .put(book.getTitle())
					   .put(book.getDateOfPublication());
					
					data.put(row);
				}
			}
			jsonResponse.put("aaData", data);
		} catch (JSONException e) {
			LOGGER.error(e.getMessage());
		}
		
		return jsonResponse.toString();
	}
	
	@PostMapping("/redirect")
	public ModelAndView buttonAction(ModelMap model) {
		LOGGER.info(BUTTON_ACTION_METHOD_MSG);
		
		return new ModelAndView("redirect:/table");
	}
	
	@RequestMapping(value = "/saveBook", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String saveBook(@RequestBody Book book) {
		LOGGER.info(SAVEBOOK_METHOD_MSG);
		LOGGER.info("Book: " + book );
		
		bookRepository.save(book);
		
		return new JSONObject().put("msg", "success").toString();

	}
	

}