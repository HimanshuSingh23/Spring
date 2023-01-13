package com.springassociate.Mock.Replica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springassociate.Mock.Replica.dto.MeetingDTO;
import com.springassociate.Mock.Replica.exception.MeetingSchedulerException;



public interface MeetingService {

	MeetingDTO scheduleMeeting( MeetingDTO meetingDTO) throws MeetingSchedulerException;

	List<MeetingDTO> getAllMeetingOfScheduler(String schedulerName) throws MeetingSchedulerException;

	MeetingDTO updateByTeamName(String teamName, MeetingDTO meetingDTO);

	void deleteByMeetingId(int meetingId);

	

	

}
