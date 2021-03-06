package API;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
//import com.google.api.services.samples.youtube.cmdline.Auth;
//import com.google.api.services.samples.youtube.cmdline.data.Search;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import app.AppController;
import elements.OurVideo;

public class APIManager {
	 private static final String PROPERTIES_FILENAME = "youtube.properties";
	 private static YouTube youtube;
	 private Properties properties;
	 
	 public APIManager() throws IOException{
		// Read the developer key from the properties file.
	        properties = new Properties();
	        try {
	        	URL url = APIManager.class.getProtectionDomain().getCodeSource().getLocation();
	    	    String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
	    	    String parentPath = new File(jarPath).getParentFile().getPath();
	            
	            String fileSeparator = System.getProperty("file.separator");
	            String p=parentPath+fileSeparator;
	        	System.out.println(p);
	            InputStream in = new FileInputStream(new File(p +PROPERTIES_FILENAME));
	            System.out.println(in.toString());
	            properties.load(in);

	        } catch (IOException e) {
	            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
	                    + " : " + e.getMessage());
	            System.exit(1);
	        }

	        try {
	            // This object is used to make YouTube Data API requests. The last
	            // argument is required, but since we don't need anything
	            // initialized when the HttpRequest is initialized, we override
	            // the interface and provide a no-op function.
	            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
	                public void initialize(HttpRequest request) throws IOException {
	                }
	            }).setApplicationName("youtube-cmdline-search-sample").build();
	        }catch (Throwable t) {
	            t.printStackTrace();
	        }
	 }
	 
	 public List<OurVideo> search(String queryTerm, long number_of_videos_returned ) throws IOException{
		 YouTube.Search.List search = youtube.search().list("id,snippet");
		 String apiKey = properties.getProperty("youtube.apikey");
         search.setKey(apiKey);
         search.setQ(queryTerm);
         search.setType("video");
         search.setFields("items(id/kind,id/videoId,snippet)");
         search.setMaxResults(number_of_videos_returned);
         SearchListResponse searchResponse = search.execute();
         List<SearchResult> searchResultList = searchResponse.getItems();
         List<OurVideo> ourVideoList = new ArrayList<OurVideo>();
         if (searchResultList != null) {
        	 for (SearchResult searchResult : searchResultList) {
        		 YouTube.Videos.List list = youtube.videos().list("statistics, ContentDetails");
        		 list.setId(searchResult.getId().getVideoId());
        		 list.setKey(apiKey);            
        		 Video v = list.execute().getItems().get(0);
        		 
        		 OurVideo ourVideo = new OurVideo(searchResult.getSnippet().getTitle(), searchResult.getId().getVideoId(), v.getStatistics().getViewCount(), v.getStatistics().getDislikeCount(), v.getStatistics().getLikeCount(), v.getStatistics().getCommentCount(), searchResult.getSnippet().getChannelTitle(), searchResult.getSnippet().getDescription(), searchResult.getSnippet().getPublishedAt(),searchResult.getSnippet().getThumbnails().getDefault().getUrl(),v.getContentDetails().getDuration());
            	 ourVideoList.add(ourVideo);
             }
         }
         return ourVideoList;
	 }

    public List<OurVideo> searchPopular() throws IOException{
		 long length = 40;
		 YouTube.Videos.List search = youtube.videos().list("id,snippet");
		 String apiKey = properties.getProperty("youtube.apikey");
		 search.setChart("mostPopular");
         search.setKey(apiKey);
         search.setRegionCode("FR");
         search.setFields("items(id,snippet)");
         search.setMaxResults(length);
         VideoListResponse searchResponse = search.execute();
         List<Video> searchResultList = searchResponse.getItems();
         List<OurVideo> ourVideoList = new ArrayList<OurVideo>();
         if (searchResultList != null) {
        	 for (Video searchResult : searchResultList) {
        		 YouTube.Videos.List list = youtube.videos().list("statistics, ContentDetails");
        		 list.setId(searchResult.getId());
        		 list.setKey(apiKey);            
        		 Video v = list.execute().getItems().get(0);
        		 OurVideo ourVideo = new OurVideo(searchResult.getSnippet().getTitle(), searchResult.getId(), v.getStatistics().getViewCount(), v.getStatistics().getDislikeCount(), v.getStatistics().getLikeCount(), v.getStatistics().getCommentCount(), searchResult.getSnippet().getChannelTitle(), searchResult.getSnippet().getDescription(), searchResult.getSnippet().getPublishedAt(),searchResult.getSnippet().getThumbnails().getDefault().getUrl(),v.getContentDetails().getDuration());
            	 ourVideoList.add(ourVideo);
             }
         }
         return ourVideoList;
	 }

    public List<OurVideo> ConnexVideo(OurVideo video)throws IOException{
    	long num = 10;
    	String videoID = video.getVideoID();
    	YouTube.Search.List search = youtube.search().list("id,snippet");
		String apiKey = properties.getProperty("youtube.apikey");
        search.setKey(apiKey);
        search.setRelatedToVideoId(videoID);
        search.setType("video");
        search.setFields("items(id/kind,id/videoId,snippet)");
        search.setMaxResults(num);
        SearchListResponse searchResponse = search.execute();
        List<SearchResult> searchResultList = searchResponse.getItems();
        List<OurVideo> ourVideoList = new ArrayList<OurVideo>();
        if (searchResultList != null) {
       	 for (SearchResult searchResult : searchResultList) {
       		 YouTube.Videos.List list = youtube.videos().list("statistics, ContentDetails");
       		 list.setId(searchResult.getId().getVideoId());
       		 list.setKey(apiKey);            
       		 Video v = list.execute().getItems().get(0);
       		 
       		OurVideo ourVideo = new OurVideo(searchResult.getSnippet().getTitle(), searchResult.getId().getVideoId(), v.getStatistics().getViewCount(), v.getStatistics().getDislikeCount(), v.getStatistics().getLikeCount(), v.getStatistics().getCommentCount(), searchResult.getSnippet().getChannelTitle(), searchResult.getSnippet().getDescription(), searchResult.getSnippet().getPublishedAt(),searchResult.getSnippet().getThumbnails().getDefault().getUrl(),v.getContentDetails().getDuration());
       		ourVideoList.add(ourVideo);
            }
        }
        return ourVideoList;
    }
    
  
}
