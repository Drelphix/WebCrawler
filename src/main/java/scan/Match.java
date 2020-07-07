package scan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Match {
    public List<String> FindMatches(String link,List<String> terms) throws IOException {
        List<String> answer = new ArrayList<>();
        int[] counts = new int[terms.size()];
        Document page = Jsoup.connect(link).get();
        int j=0;
        for (String expression : terms) {

            String text= page.body().text();
            while (text.indexOf(expression) != -1) {
                counts[j]++;
                text=text.substring(text.indexOf(expression)+expression.length());
            }
            if(counts[j]!=0) answer.add(expression+" : "+counts[j]);
            j++;
        } return answer;
     }

}
