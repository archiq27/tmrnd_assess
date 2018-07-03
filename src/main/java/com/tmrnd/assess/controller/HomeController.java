/**
 * 
 */
package com.tmrnd.assess.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Osman Sulaiman
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/start")
	public Map<String, Object> start() {
		logger.debug("Program started.");
		return null;
	}
}
