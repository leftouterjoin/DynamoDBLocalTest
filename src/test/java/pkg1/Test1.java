package pkg1;

import org.junit.Test;
import java.time.OffsetDateTime;
import java.util.Date;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;

public class Test1 {
	@Test
	public void test1() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();

		PutItemRequest request = new PutItemRequest().withTableName("Channels")
				.addItemEntry("channelName", new AttributeValue("techscore"))
				.addItemEntry("maxMessageNumber", new AttributeValue().withN("0"))
				.addItemEntry("createdAt", new AttributeValue(OffsetDateTime.now().toString()))
				.addItemEntry("updatedAt", new AttributeValue(OffsetDateTime.now().toString()));
		client.putItem(request);

		client.scan(new ScanRequest().withTableName("Channels"));

		System.out.println(client.listTables());

	}

	@Test
	public void test2() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();

		DynamoDBMapper mapper = new DynamoDBMapper(client);

		{
			Channel channel = new Channel();
			channel.setChannelName("techscore");
			channel.setCreatedAt(new Date());
			channel.setUpdatedAt(new Date());
			channel.setMaxMessageNumber(0);

			mapper.save(channel);
		}
		{
			Channel channel = mapper.load(Channel.class, "techscore");
			System.out.println(channel);
			mapper.delete(channel);
		}
		{
			Channel channel = mapper.load(Channel.class, "techscore");
			System.out.println(channel);
		}
	}
}
