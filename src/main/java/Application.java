
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scan.Match;
import scan.Scaner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    private static final int MAX_VISITED =10000;
    private static final int MAX_DEPTH =8;

    public static void main(String[] args) throws IOException {
        Match match = new Match();
        Scaner scanner = new Scaner();
        List<String> terms = new ArrayList<String>();
        List<String> links = new ArrayList<>();
        String mainLink = "https://en.wikipedia.org/wiki/Elon_Musk";
        terms.add("Musk");
        terms.add("Tesla");
        terms.add("Elon Musk");
        links = scanner.Scan(mainLink,MAX_VISITED,MAX_DEPTH);
        for(String link :links){
            System.out.println(link+" : ");
            System.out.println(!match.FindMatches(link,terms).isEmpty()?match.FindMatches(link,terms):"There are no matches");
        }
        System.out.println(links.size());
    }

}
