package com.springassociate.Mock.Replica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springassociate.Mock.Replica.dto.MeetingDTO;
import com.springassociate.Mock.Replica.entity.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting,Integer>{
	
	List<Meeting> findBySchedulerName(String schedulerName);
	
	List<Meeting> findBySchedulerNameAndMeetingDate(String schedulerName,LocalDate meetingDate);
	
	List<Meeting> findByTeamNameAndMeetingDate(String teamName,LocalDate meetingDate);
	
	Meeting findByTeamName(String teamName);

}
