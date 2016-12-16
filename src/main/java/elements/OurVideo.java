package elements;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if(!duration.equals("")){
			this.duration = convertDuration(convertToSeconds(duration));
		}
		
	}


	private String convertDuration(int seconds) {
		String fDuration="";
		if(seconds<60){
			fDuration=fDuration+"00:";
		}
		if(seconds>3600){
			int hours = Math.round(seconds/3600);
			if(hours>9){
				fDuration=fDuration+String.valueOf(hours)+":";
			}
			else{
				fDuration=fDuration+"0"+String.valueOf(hours)+":";
			}
			seconds=seconds - hours*3600;
		}
		if(seconds>60){
			int minutes =  Math.round(seconds/60);
			if(minutes>9){
				fDuration=fDuration+String.valueOf(minutes)+":";
			}else{
				fDuration=fDuration+"0"+String.valueOf(minutes)+":";
			}
			seconds=seconds - minutes*60;
		}
		if(seconds>9){
			fDuration=fDuration+String.valueOf(seconds);
		}else{
			fDuration=fDuration+"0"+String.valueOf(seconds);
		}
		return fDuration;
	}
	
	private int convertToSeconds(String txt){
	    String re1="(P)";   // Any Single Character 1
	    String re2="(T)";   // Any Single Character 2
	    String reh="(\\d+)";
	    String reh1="(H)";
	    String re3="(\\d+)";    // Integer Number 1
	    String re4="(M)";   // Any Single Character 3
	    String re5="(\\d+)";    // Integer Number 2
	    String re6="(S)";   // Any Single Character 4
	
	    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(txt);
	    if (m.find())
	    {
	        //String c1=m.group(1);
	        //String c2=m.group(2);
	        String minutes=m.group(3); // Minutes are here
	        //String c3=m.group(4);
	        String seconds=m.group(5); // Seconds are here
	        //String c4=m.group(6);
	        int totalSeconds = Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds);
		    return totalSeconds;
		    
	    }else{
	    	p = Pattern.compile(re1+re2+re5+re6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    	m = p.matcher(txt);
	    	if(m.find()){
	    		 String seconds=m.group(3); // Seconds are here
	    		 int totalSeconds = Integer.parseInt(seconds);
	 		     return totalSeconds;
	    	}else{
	    		p = Pattern.compile(re1+re2+reh+reh1+re3+re4+re5+re6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    	m = p.matcher(txt);
		    	if(m.find()){
		    		String hours = m.group(3);
		    		String minutes=m.group(5); 
		    		String seconds=m.group(7);
		    		int totalSeconds = Integer.parseInt(hours)*3600+Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds);
				    return totalSeconds;
		    	}
	    	}
	    }
	    return 0;
	    
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
