/**
 * 
 */
package com.tmrnd.assess.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmrnd.assess.modules.dataloader.TeamProcessor;

/**
 * @author Osman Sulaiman
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private TeamProcessor teamProcessor;

	@RequestMapping("/start")
	public Map<String, Object> start() {
		logger.debug("Program started.");
		teamProcessor.process();
		return null;
	}
}
