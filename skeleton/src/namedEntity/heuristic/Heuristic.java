package namedEntity.heuristic;

import java.util.Map;

public abstract class Heuristic {
    private static Map<String, String> categoryMap = Map.of(
        "Microsft", "organización", 
        "Apple", "organización", 
        "Google", "organización",
        "Musk", "persona",
        "Biden", "persona",
        "Trump", "persona",
        "Messi", "persona",
        "Federer", "persona",
        "USA", "lugar",
        "Russia", "lugar"
    );

    private static Map<String, String> subcategoryMap = Map.of(
        "USA", "país",
        "Russia", "país",
        "Messi", "nombre",
        "Federer", "nombre"
        // agrega más si quieres
    );

    private static Map<String, String> topicMap = Map.of(
        "Messi", "deportes",
        "Federer", "deportes",
        "Trump", "política",
        "Biden", "política"
        // agrega más si quieres
    );

    public String getCategory(String entity){
        return categoryMap.getOrDefault(entity, "otro");
    }

    public String getSubcategory(String entity){
        return subcategoryMap.getOrDefault(entity, "otro");
    }

    public String getTopic(String entity){
        return topicMap.getOrDefault(entity, "otro");
    }

    public abstract boolean isEntity(String word);
}
