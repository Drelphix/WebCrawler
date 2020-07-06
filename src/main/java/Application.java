import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final int maxVisited=10000;
    private static final int depth=8;

    public static void main(String[] args) throws IOException {
        String site;
        List<String> terms = new ArrayList<String>();
        List<String> urls = new ArrayList<String>();
        urls.add("https://en.wikipedia.org/wiki/Elon_Musk");
        List<Document> pages = new ArrayList<Document>();
        terms.add("Musk");
        terms.add("Tesla");
        terms.add("Elon Musk");
        int[] counts = new int[terms.size()-1];
        Document page = Jsoup.connect(urls.get(0)).get();
        Elements links = page.select("a");
        String absHref = null;
        for (Element element : links)
                urls.add(element.attr("href"));
            //Поиск
        System.out.println("URLS:");
        for (int i = 1; i < urls.size(); i++) {

            System.out.println(urls.get(i));
        }
        Document doc = Jsoup.parse(page.body().text());
        String finded = doc.body().text();
        System.out.println(finded);

    }

}
