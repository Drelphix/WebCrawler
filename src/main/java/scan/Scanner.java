package scan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Scanner implements Callable<List<String>> {
    private String link;
    private List<String> terms;

    public Scanner() {

    }

    public Scanner(String link, List<String> terms) {
        this.link = link;
        this.terms = terms;
    }

    public List<String> Scan(String url, int maxPages, int maxDepth) throws IOException {
        List<String> linkList = new ArrayList<>();
        int depth = 0;
        int start = 0;
        int count = 0;
        linkList.add(url);
        int end = linkList.size();
        while (depth <= maxDepth) {
            depth++;
            for (int i = start; i < end; i++) {
                if (linkList.size() >= maxPages) break;
                else {
                    linkList.addAll(SubScan(linkList.get(i)));
                }
            }
            start = end;
            end = linkList.size();
        }
        return linkList;
    }

    private List<String> SubScan(String url) throws IOException {
        List<String> subUrlList = new ArrayList<>();
        Document page = Jsoup.connect(url).get();
        Elements links = page.select("a");
        for (Element element : links) {
            if ((!element.attr("href").isEmpty()) && element.attr("href").startsWith("/"))
                subUrlList.add(element.absUrl("href"));
        }
        return subUrlList;
    }


    @Override
    public List<String> call() throws Exception {
        return new Match().FindMatches(link,terms);
    }
}
