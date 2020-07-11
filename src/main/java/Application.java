import csv.File;
import scan.Match;
import scan.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Application  {
    private static final int MAX_VISITED = 10000;
    private static final int MAX_DEPTH = 8;
    private static final String CSV_FILE="D://output.csv";

    public static void main(String[] args) throws Exception {
        Match match = new Match();
        List<String> terms = new ArrayList<String>();
        java.io.File csvFile = new File().CreateFile(CSV_FILE);
        List<String> output = new ArrayList<>();
        List<String> links = new ArrayList<>();
        String mainLink = "https://en.wikipedia.org/wiki/Elon_Musk";
        terms.add("Musk");
        terms.add("Tesla");
        terms.add("Elon Musk");
        links = new Scanner().Scan(mainLink, MAX_VISITED, MAX_DEPTH);
        for (String link:links){
            output.addAll(new Scanner(link, terms).call());
            new File().Save(output,CSV_FILE);
            output.clear();
        }
        System.out.println("You can find the file in C://data.csv");
    }

}