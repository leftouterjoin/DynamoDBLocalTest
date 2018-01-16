package pkg1;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Channels")
public class Channel {
	@DynamoDBHashKey
	private String channelName;

	@DynamoDBAttribute
	private long maxMessageNumber;

	@DynamoDBAttribute
	private Date createdAt;

	@DynamoDBAttribute
	private Date updatedAt;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public long getMaxMessageNumber() {
		return maxMessageNumber;
	}

	public void setMaxMessageNumber(long maxMessageNumber) {
		this.maxMessageNumber = maxMessageNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Channel [channelName=" + channelName + ", maxMessageNumber=" + maxMessageNumber + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
