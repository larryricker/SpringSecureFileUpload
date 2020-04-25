package northwind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	String login(HttpServletRequest request, Model model) {
		return "login";
	}

	@RequestMapping(value = "/loginerror", method = RequestMethod.GET)
	String err(HttpServletRequest request, Model model) {
		return "loginerror";
	}

}
