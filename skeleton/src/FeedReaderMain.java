
import feed.Feed;
import feed.Article;
import httpRequest.httpRequester;
import parser.RssParser;
import parser.SubscriptionParser;
import namedEntity.heuristic.Heuristic;
import namedEntity.heuristic.QuickHeuristic;
//import namedEntity.heuristic.RandomHeuristic;

import java.util.List;

public class FeedReaderMain {

    private static void printHelp(){
        System.out.println("Please, call this program in correct way: FeedReader [-ne]");
    }

    public static void main(String[] args) {
        System.out.println("************* FeedReader version 1.0 *************");
        try {
            // 1. Leer las URLs de feeds desde el archivo de suscripción
            List<String> urls = SubscriptionParser.getAllFeedUrls("config/subscriptions.json");
            httpRequester requester = new httpRequester();
            RssParser parser = new RssParser();

            // 2. Por cada feed, obtener y parsear los artículos
            for (String url : urls) {
                String xml = requester.getFeedRss(url);
                if (xml == null) continue;
                Feed feed = parser.parse(xml, url);

                // 3. Si no hay parámetro extra, mostrar artículos de forma legible
                if (args.length == 0) {
                    feed.prettyPrint();
                }
                // 4. Si hay parámetro -ne, computar entidades nombradas y mostrar tabla
                else if (args.length == 1 && args[0].equals("-ne")) {
                    // Puedes cambiar la heurística aquí fácilmente
                    Heuristic heuristic = new QuickHeuristic();
                    // Heuristic heuristic = new RandomHeuristic();
					for (Article article : feed.getArticleList()) {
						article.computeNamedEntities(heuristic);
					}
					feed.printNamedEntitiesTable();
                } else {
                    printHelp();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}