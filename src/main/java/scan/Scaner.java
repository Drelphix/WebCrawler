package scan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scaner {
    int depth=0;

    public List<String> Scan(String url, int maxPages, int maxDepth) throws IOException {
        int depth=0;
        int start=0;
        int end = 0;
        List<String> linkList=SubScan(url);
        end = linkList.size();
        while (depth<=maxDepth) {
            depth++;
            for (int i = start; i < end; i++) {
                if(linkList.size()>=maxPages) break; else
                linkList.addAll(SubScan(linkList.get(i)));
            }
            start=end;
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
}
