/**
 * 
 */
package com.tmrnd.assess.modules.dataloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.tmrnd.assess.data.model.Team;

/**
 * @author Osman Sulaiman
 *
 */
@Service
public class TeamProcessor {

	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private ResourceLoader resourceLoader;
	
	public boolean process() {
		List<Team> itemList = new ArrayList<Team>();
		
		// load the team csv
		Resource res = resourceLoader.getResource("classpath:csv_files/team.csv");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(res.getInputStream()));
			itemList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
			
			// post it to the service
			MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
			request.add("teams", itemList);
			
			String url = "http://localhost:8080/team";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> resp = restTemplate.postForEntity(url, request, String.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private Function<String, Team> mapToItem = (line) -> {
		logger.debug("reading: " + line);
		String[] p = line.split(",");
		Team team = new Team();
		team.setTeamId(p[0]);
		return team;
	};
}
