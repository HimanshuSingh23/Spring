package com.springassociate.Mock.Replica.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.springassociate.Mock.Replica.dto.MeetingDTO;
import com.springassociate.Mock.Replica.exception.MeetingSchedulerException;

public class MeetingValidator {
	
	private MeetingValidator()
	
	{
		
	}
	
	public static void validateMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException
	{
		if(isValidMeetingDate(meetingDTO.getMeetingDate())==false)
			
		{
			throw new MeetingSchedulerException("MeetingValidator.INVALID_MEETING_DATE");
		}
		if(isValidTeamName(meetingDTO.getTeamName())==false)
			
		{
			throw new MeetingSchedulerException("MeetingValidator.INVALID_TEAM_NAME");
		}
			
	}

	public  static Boolean isValidTeamName(String teamName) {
		if((teamName=="ETAMYSJAVA")||(teamName=="ETAMYSUI")||(teamName=="ETAMYSBI")||(teamName=="ETAMYSAI")||(teamName=="ETAMYSMS")){
			return true;
		}
		return false;
	}

	public static Boolean isValidMeetingDate(LocalDate meetingDate) {
		DayOfWeek day=DayOfWeek.of(meetingDate.get(ChronoField.DAY_OF_WEEK));
		if((day==DayOfWeek.SATURDAY)||(day==DayOfWeek.SUNDAY))
		{
			return false;
		}
		return true;
	}

}
