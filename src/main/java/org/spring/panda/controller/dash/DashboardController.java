package org.spring.panda.controller.dash;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jeevan
 * @date 23-Jan-2015
 * @purpose 
 *
 */
@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home() {
		return "dash/dash";
	}
}
