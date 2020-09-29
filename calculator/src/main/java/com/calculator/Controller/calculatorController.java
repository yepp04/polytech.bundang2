package com.calculator.Controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class calculatorController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}

	@RequestMapping("Calculate.do")
	public ModelAndView printCalculatedResult(String num1, String operation, String num2) {
		ModelAndView modelAndView = new ModelAndView();
		int resultData = 0;

		if ("+".equals(operation)) {
			resultData = Integer.parseInt(num1) + Integer.parseInt(num2);
		} else if ("-".equals(operation)) {
			resultData = Integer.parseInt(num1) - Integer.parseInt(num2);
		} else if ("*".equals(operation)) {
			resultData = Integer.parseInt(num1) * Integer.parseInt(num2);
		} else if ("/".equals(operation)) {
			resultData = Integer.parseInt(num1) / Integer.parseInt(num2);
		}
		modelAndView.setViewName("result");
		modelAndView.addObject("resultData", resultData);

		return modelAndView;

	}
}
