package com.springassociate.Mock.Replica.dto;

import java.time.LocalDate;



import com.springassociate.Mock.Replica.entity.Meeting;

import jakarta.validation.constraints.NotNull;





public class MeetingDTO {
        private int meetingId;
        @NotNull
        private String schedulerName;
        @NotNull
	    private String teamName;
        @NotNull
	    private String purpose;
        @NotNull
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
		public MeetingDTO(int meetingId, String schedulerName, String teamName, String purpose, LocalDate meetingDate) {
			super();
			this.meetingId = meetingId;
			this.schedulerName = schedulerName;
			this.teamName = teamName;
			this.purpose = purpose;
			this.meetingDate = meetingDate;
		}
		public MeetingDTO() {
			
		}
		
		
		public static Meeting prepareEntity(MeetingDTO meetingDTO)
		{
			Meeting meeting=new Meeting();
			meeting.setPurpose(meetingDTO.getPurpose());
			meeting.setMeetingDate(meetingDTO.getMeetingDate());
			meeting.setSchedulerName(meetingDTO.getSchedulerName());
			meeting.setTeamName(meetingDTO.getTeamName());
			return meeting;
		}
		public static MeetingDTO prepareDTO(Meeting meeting)
		{
			MeetingDTO meetingDTO= new MeetingDTO();
			meetingDTO.setMeetingId(meeting.getMeetingId());
			meetingDTO.setMeetingDate(meeting.getMeetingDate());
			meetingDTO.setPurpose(meeting.getPurpose());
			meetingDTO.setSchedulerName(meeting.getSchedulerName());
			meetingDTO.setTeamName(meeting.getTeamName());
			return meetingDTO;
		}

	    
}
