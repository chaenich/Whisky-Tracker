package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(1995);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void canFindWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Lowland");
		assertEquals("Rosebank", found.get(0).getName());
	}
	@Test
	public void canFindDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindWhiskiesFromParticularDistilleryWithSpecificAge(){
		List<Whisky> found = whiskyRepository.findWhiskiesFromParticularDistilleryWithSpecificAge("Rosebank", 12);
//		List<Whisky> found = whiskyRepository.findWhiskiesFromParticularDistillery("Rosebank");
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void canFindWhiskiesFromParticularDistilleryWithSpecificAge2(){
		List<Whisky> found = whiskyRepository.findWhiskiesFromParticularDistilleryWithSpecificAge("Macallan", 25);
//		List<Whisky> found = whiskyRepository.findWhiskiesFromParticularDistillery("Rosebank");
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}
}
