package org.ukdaga.corporatefacemash;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;


@Configuration
public class DynamoDbConfig {

	@Value("${aws.ujjwaldaga.keyaccessid}")
	private String keyAccessId;

	@Value("${aws.ujjwaldaga.secretaccesskey}")
	private String secretKey;

	@Value("${aws.dynamodb.region}")
	private String region;

	@Value("${aws.dynamodb.host}")
	private String host;


	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(keyAccessId, secretKey);
	}
	
	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}
	
	@Bean
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
		return new DynamoDBMapper(amazonDynamoDB, config);
	}


	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(amazonAWSCredentialsProvider())
				.withRegion(Regions.US_EAST_2)
				.build();
	}
	
	@Bean
	public DynamoDB dynamoDB() {
		return new DynamoDB(amazonDynamoDB());
	}
	
	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	}
}
