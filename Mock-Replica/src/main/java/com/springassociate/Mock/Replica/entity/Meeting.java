package com.springassociate.Mock.Replica.entity;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Meeting {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int meetingId;
	 private String schedulerName;
	 private String teamName;
	 private String purpose;
	 private LocalDate meetingDate;
	
	 
	 public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public LocalDate getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", schedulerName=" + schedulerName + ", teamName=" + teamName
				+ ", purpose=" + purpose + ", meetingDate=" + meetingDate + "]";
	}
	public Meeting(int meetingId, String schedulerName, String teamName, String purpose, LocalDate meetingDate) {
		super();
		this.meetingId = meetingId;
		this.schedulerName = schedulerName;
		this.teamName = teamName;
		this.purpose = purpose;
		this.meetingDate = meetingDate;
	}
	public Meeting() {
		
	}
	
	
	 
	 
}
