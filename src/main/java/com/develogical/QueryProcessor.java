package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {


    public String process(String query) {
        StringBuilder q = new StringBuilder(query.toLowerCase());
        if (q.toString().contains(":")) {
            String[] qs = q.toString().split(":");
            q = new StringBuilder();
            for (int i = 1; i < qs.length; i++) {
                q.append(qs[i]);
            }
        }

        if (q.toString().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (q.toString().contains("name")) {
            return "horse-battery-66";
        }

        if (q.toString().contains("is the largest")) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(q.toString());
            int largest = 0;
            while (m.find()) {
                int i = Integer.parseInt(m.group());
                if (i > largest) {
                    largest = i;
                }
            }
            return Integer.toString(largest);
        }

        if (query.contains("plus")) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(q.toString());
            int sum = 0;
            while (m.find()) {
                int i = Integer.parseInt(m.group());
                sum += i;
            }
            return Integer.toString(sum);
        }

        return q.toString();
    }
}
