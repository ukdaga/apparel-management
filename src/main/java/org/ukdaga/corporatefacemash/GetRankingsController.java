package org.ukdaga.corporatefacemash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@RestController
public class GetRankingsController {

	@Autowired
	DynamoDBMapper mapper;

	private final Logger logger = LoggerFactory.getLogger(GetRankingsController.class);

	@RequestMapping(value = "scores/{playerId}" , method = RequestMethod.GET)
	public Scores getScores(@PathVariable String playerId)
	{
		try {
			return mapper.load(Scores.class, playerId);
		}
		catch (Exception e){
			logger.info("Error ",e);
		}
		return null;
	}
	
	@RequestMapping(value = "scores/add" , method = RequestMethod.POST)
	public String getScores(@RequestBody Scores score)
	{
		mapper.save(score);
		return "success";
	}

}
