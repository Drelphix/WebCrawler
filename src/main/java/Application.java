import csv.File;
import scan.Match;
import scan.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Application {
    private static final int MAX_VISITED = 10000;
    private static final int MAX_DEPTH = 8;

    public static void main(String[] args) throws IOException {
        Match match = new Match();
        Scanner scanner = new Scanner();
        List<String> terms = new ArrayList<String>();
        List<String> output = new ArrayList<>();
        List<String> links = new ArrayList<>();
        String mainLink = "https://en.wikipedia.org/wiki/Elon_Musk";
        terms.add("Musk");
        terms.add("Tesla");
        terms.add("Elon Musk");
        links = scanner.Scan(mainLink, MAX_VISITED, MAX_DEPTH);
        for (String link : links) {
            output.add(link + " : "+ match.FindMatches(link, terms));
        }
        new File().Save(output);
        System.out.println("You can find the file in C://data.csv");
    }

}
