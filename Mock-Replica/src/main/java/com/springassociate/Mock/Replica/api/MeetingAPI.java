package com.springassociate.Mock.Replica.api;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springassociate.Mock.Replica.dto.MeetingDTO;
import com.springassociate.Mock.Replica.exception.MeetingSchedulerException;
import com.springassociate.Mock.Replica.service.MeetingService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value="api")
@Validated
public class MeetingAPI {
	
	@Autowired
	private MeetingService meetingService;

	
	@GetMapping("/")
	public String HelloWorld()
	{
		return "Welcome";
	}
	
	@PostMapping(value="/meetings") 
	public ResponseEntity<MeetingDTO> scheduleMeeting (@Valid @RequestBody  MeetingDTO meetingDTO)throws MeetingSchedulerException
	{
		MeetingDTO myDTO=meetingService.scheduleMeeting(meetingDTO);
		return new ResponseEntity<>(myDTO,HttpStatus.CREATED);
	}
	@GetMapping(value="/meetings/{schedulerName}")//Get by scheduler name
	public ResponseEntity<List<MeetingDTO>> getAllMeetingsScheduler(@PathVariable("schedulerName") String schedulerName)throws MeetingSchedulerException
	{
		List<MeetingDTO> dto=meetingService.getAllMeetingOfScheduler(schedulerName);
		return  new ResponseEntity<List<MeetingDTO>>(dto,HttpStatus.OK);
		
	}
	@PutMapping(value="/meetings/{teamName}")
	public ResponseEntity<MeetingDTO> updateByTeamName(@Valid @PathVariable("teamName") String teamName,@RequestBody MeetingDTO meetingDTO)
	{
		MeetingDTO newTeamDTO=meetingService.updateByTeamName(teamName,meetingDTO);
		return new ResponseEntity<MeetingDTO>(newTeamDTO,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value="/meetings/{meetingId}")
	public String deleteByMeetingId(@PathVariable("meetingId") int meetingId)
	{
		meetingService.deleteByMeetingId(meetingId);
		return "Meeting Deleted Successfully";
	}
	
	
	
	
	
}
