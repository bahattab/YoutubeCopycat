package API;


import com.google.api.client.util.DateTime;

public class OurVideo {
	private String name;
	private String videoID;
	//public BigInteger viewCount;
	//public BigInteger dislikeCount;
	//public BigInteger likeCount;
	//public BigInteger commentCount;
	private String channelTitle;
	private String videoDescription;
	private DateTime publishedAt;
	
	public OurVideo(String title, String videoId, String channelTitle,
			String description, DateTime publishedAt) {
		this.name = title;
		this.videoID=videoId;
		//this.viewCount = viewCount;
		//this.dislikeCount = dislikeCount;
		//this.likeCount = likeCount;
		//this.commentCount = commentCount;
		this.channelTitle = channelTitle;
		this.videoDescription = description;
		this.publishedAt = publishedAt;
	}

	@Override
	public String toString() {
		return "OurVideo [name=" + name + ", videoID=" + videoID
				+ ", channelTitle=" + channelTitle + ", videoDescription="
				+ videoDescription + ", publishedAt=" + publishedAt + "]";
	}

	public String getName() {
		return name;
	}

	public String getVideoID() {
		return videoID;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public DateTime getPublishedAt() {
		return publishedAt;
	}
	
}
