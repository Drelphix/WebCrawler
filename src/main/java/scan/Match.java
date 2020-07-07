package scan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Match {
    public List<String> FindMatches(String link, List<String> terms) throws IOException {
        List<String> answer = new ArrayList<>();
        int[] counts = new int[terms.size()];
        Document page = Jsoup.connect(link).get();
        int j = 0;
        int total = 0;
        for (String expression : terms) {

            String text = page.body().text();
            while (text.contains(expression)) {
                counts[j]++;
                text = text.substring(text.indexOf(expression) + expression.length());
            }
            if (counts[j] !=0) {
                answer.add(expression + " : " + counts[j]);
                total+=counts[j];
            }
            j++;
        }
        if (total != 0) {
            answer.add("Total :" + total);
        } else answer.add("There is no matches");
        return answer;
    }

}
