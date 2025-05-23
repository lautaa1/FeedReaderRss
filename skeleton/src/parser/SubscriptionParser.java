package parser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import feed.Feed;

public class SubscriptionParser extends GeneralParser {

    public static List<String> getAllFeedUrls(String path) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONArray arr = new JSONArray(content);
        List<String> urls = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            String urlTemplate = obj.getString("url");
            JSONArray params = obj.getJSONArray("urlParams");
            for (int j = 0; j < params.length(); j++) {
                String param = params.getString(j);
                String url = urlTemplate.replace("%s", param);
                urls.add(url);
            }
        }
        return urls;
    }

    @Override
    public Feed parse(String xml, String siteName) {
        throw new UnsupportedOperationException("SubscriptionParser no implementado.");
    }

    public static void main(String[] args) throws Exception {
        List<String> urls = getAllFeedUrls("config/subscriptions.json");
        for (String url : urls) {
            System.out.println(url);
        }
    }
}