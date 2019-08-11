package org.ukdaga.corporatefacemash;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Scores")
public class Scores {

	private String playerId;
	private String field;
	private Double score;
	
	@DynamoDBHashKey
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	@DynamoDBAttribute
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	@DynamoDBAttribute
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	
}
	