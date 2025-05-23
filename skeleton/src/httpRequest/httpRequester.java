package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class httpRequester {
    
    public String getFeedRss(String urlFeed){
        StringBuilder feedRssXml = new StringBuilder();
        try {
            URL url = URI.create(urlFeed).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/rss+xml, application/xml, text/xml, */*");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                feedRssXml.append(output).append("\n");
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return feedRssXml.toString();
    }

    public String getFeedReedit(String urlFeed) {
        String feedReeditJson = null;
        return feedReeditJson;
    }
}