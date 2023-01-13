package com.springassociate.Mock.Replica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springassociate.Mock.Replica.dto.MeetingDTO;
import com.springassociate.Mock.Replica.entity.Meeting;
import com.springassociate.Mock.Replica.exception.MeetingSchedulerException;
import com.springassociate.Mock.Replica.repository.MeetingRepository;
import com.springassociate.Mock.Replica.validator.MeetingValidator;

@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;

	@Override
	public MeetingDTO scheduleMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException{
//		MeetingValidator.validateMeeting();
		List<Meeting> myMeeting=meetingRepository.findBySchedulerNameAndMeetingDate(meetingDTO.getSchedulerName(),meetingDTO.getMeetingDate());
		if(myMeeting.isEmpty()==false)
		 {
		   throw new MeetingSchedulerException("MeetingServiceException.MEETING_DATE_UNAVAILABLE");
		 }
		 List<Meeting> newTeam=meetingRepository.findByTeamNameAndMeetingDate(meetingDTO.getTeamName(),meetingDTO.getMeetingDate());
		 if(newTeam.isEmpty()==false)
		 {
		    throw new MeetingSchedulerException("MeetingService.TEAM_UNAVAILABLE");
		 }
		
		Meeting obj=MeetingDTO.prepareEntity(meetingDTO);
		meetingRepository.save(obj);
		int newId=obj.getMeetingId();
		meetingDTO.setMeetingId(newId);
		return meetingDTO;
    }
	@Override
	
	public List<MeetingDTO> getAllMeetingOfScheduler(String schedulerName) throws MeetingSchedulerException
	{
	 List<Meeting> newList=meetingRepository.findBySchedulerName(schedulerName);
	 if(newList.isEmpty()==true)
	   throw new MeetingSchedulerException("MeetingService.NO_MEETINGS_FOUND");
	 List<MeetingDTO> newDto=new ArrayList<>();
	 for(Meeting newLst:newList)
	 {
	   MeetingDTO dto=MeetingDTO.prepareDTO(newLst);
	   newDto.add(dto);
	 }
	 return newDto;
	}
	@Override
	public MeetingDTO updateByTeamName(String teamName, MeetingDTO meetingDTO) {
		Meeting initialObj=meetingRepository.findByTeamName(teamName);
		initialObj.setTeamName(meetingDTO.getTeamName());
		initialObj.setMeetingDate(meetingDTO.getMeetingDate());
		initialObj.setSchedulerName(meetingDTO.getSchedulerName());
		initialObj.setPurpose(meetingDTO.getPurpose());
		meetingRepository.save(initialObj);
		MeetingDTO updatedTeam=MeetingDTO.prepareDTO(initialObj);
		return updatedTeam;
		
	}
	@Override
	public void deleteByMeetingId(int meetingId) {
		meetingRepository.deleteById(meetingId);
		
		
	}
	

}
