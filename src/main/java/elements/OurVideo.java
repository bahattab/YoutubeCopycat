package elements;


import java.io.Serializable;
import java.math.BigInteger; 

import com.google.api.client.util.DateTime;

public class OurVideo implements Serializable{
	private String name;
	private String videoID;
	private BigInteger viewCount;
	private BigInteger dislikeCount;
	private BigInteger likeCount;
	private BigInteger commentCount;
	private String channelTitle;
	private String videoDescription;
	private DateTime publishedAt;
	private String miniature;
	private Boolean onlineStatus = true;
	private String duration;
	
	public OurVideo(String name, String videoID, BigInteger viewCount,
			BigInteger dislikeCount, BigInteger likeCount,
			BigInteger commentCount, String channelTitle,
			String videoDescription, DateTime publishedAt, String miniature,String duration) {
		super();
		this.miniature=miniature;
		this.name = name;
		this.videoID = videoID;
		this.viewCount = viewCount;
		this.dislikeCount = dislikeCount;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.channelTitle = channelTitle;
		this.videoDescription = videoDescription;
		this.publishedAt = publishedAt;
		this.duration=duration;
	}


	@Override
	public String toString() {
		return "OurVideo [name=" + name + ", videoID=" + videoID
				+ ", viewCount=" + viewCount + ", dislikeCount=" + dislikeCount
				+ ", likeCount=" + likeCount + ", commentCount=" + commentCount
				+ ", channelTitle=" + channelTitle + ", videoDescription="
				+ videoDescription + ", publishedAt=" + publishedAt + ", miniature="+miniature+"]";
	}
	
	public String getDuration(){
		return duration;
	}
	
	public String getMiniature(){
		return miniature;
	}
	public String getName() {
		return name;
	}


	public String getVideoID() {
		return videoID;
	}


	public BigInteger getViewCount() {
		return viewCount;
	}


	public BigInteger getDislikeCount() {
		return dislikeCount;
	}


	public BigInteger getLikeCount() {
		return likeCount;
	}


	public BigInteger getCommentCount() {
		return commentCount;
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

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public Boolean isOnline(){
		return onlineStatus;
	}
	
}
