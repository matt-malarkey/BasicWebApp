package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {


    public String process(String query) {
        final String q = query.toLowerCase();

        if (q.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (q.contains("name")) {
            return "horse-battery-66";
        } else if (q.contains("is the largest")) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(q);
            int largest = 0;
            while (m.find()) {
                int i = Integer.parseInt(m.group());
                if (i > largest) {
                    largest = i;
                }
            }
            return Integer.toString(largest);
        } else if (query.contains("plus")) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(q);
            int sum = 0;
            while (m.find()) {
                int i = Integer.parseInt(m.group());
                sum += i;
            }

            return Integer.toString(sum);
        }
        return query.toLowerCase();



    }
}
