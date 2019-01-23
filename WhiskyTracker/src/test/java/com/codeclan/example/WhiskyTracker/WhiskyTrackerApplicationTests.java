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
	public void canReturnWhiskiesByYear(){
		List<Whisky> results = whiskyRepository.findWhiskiesWithYear(1991);
		assertEquals(1, results.size());
	}

	@Test
	public void findDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Lowland");
		assertEquals(1, found.size());
	}

	@Test
	public void findWhiskyByAgeAndDistillery(){
		List<Whisky> found = whiskyRepository.findWhiskiesWithAge(12, 2L);
		assertEquals(1, found.size());
	}

}
