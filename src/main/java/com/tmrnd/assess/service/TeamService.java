/**
 * 
 */
package com.tmrnd.assess.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmrnd.assess.data.model.Team;
import com.tmrnd.assess.data.repo.TeamRepository;

/**
 * @author Osman Sulaiman
 *
 */
@RestController
public class TeamService {

	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private TeamRepository teamRepo;
	
	@RequestMapping("/team")
	public Map<String, Object> process(@RequestParam(value="teams") List<Team> teams) {
		Map<String, Object> resp = new HashMap<String, Object>();
		logger.debug("test je");
		for (Team t : teams) {
			logger.debug("data enter: {}", t);
		}
		resp.put("status", "okay");
		return resp;
	}
}
