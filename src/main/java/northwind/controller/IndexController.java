package northwind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@RequestMapping(value  =  "/", method = RequestMethod.GET)
	String index(HttpServletRequest request, Model model) {
		return "index";
	}
}
