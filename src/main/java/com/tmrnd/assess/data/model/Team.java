/**
 * 
 */
package com.tmrnd.assess.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Osman Sulaiman
 *
 */
@Entity
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String teamId;

	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
}
