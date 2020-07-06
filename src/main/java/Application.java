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

        List<String> terms = new ArrayList<String>();
        List<String> urls = new ArrayList<String>();
        urls.add("https://en.wikipedia.org/wiki/Elon_Musk");
        List<Document> pages = new ArrayList<Document>();
        terms.add("Musk");
        terms.add("Tesla");
        terms.add("Elon Musk");
        int[] counts = new int[terms.size()];
        Document page = Jsoup.connect(urls.get(0)).get();
        Elements links = page.select("a");
        String absHref = null;
        int j=0;
        int test=0;
            for (String expression : terms) {
                String text= page.body().text();
                while (text.indexOf(expression) != -1) {
                    counts[j]++;
                    text=text.substring(text.indexOf(expression)+expression.length());
                }j++;
            }
        for (int i = 0; i <counts.length ; i++) {
            System.out.println(terms.get(i)+" : "+ counts[i]);
        }

        for (Element element : links)
            if ((!element.attr("href").isEmpty())&&element.attr("href").startsWith("/"))
                urls.add(element.attr("href"));
            //Поиск
        System.out.println("URLS:");
        for (int i = 1; i < urls.size(); i++) {
            if (urls.get(i).startsWith("//www.")){
                System.out.println(urls.get(i).substring(2));
            } else
            System.out.println(urls.get(i));
        }
        Document doc = Jsoup.parse(page.body().text());
        String finded = doc.body().text();
        System.out.println(finded);
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }*/


    }

}
