package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class QueryProcessor {


    public String process(String query) {
        String q = query.toLowerCase();

        // Get rid of query ID
        if (q.contains(":")) {
            StringBuilder sb = new StringBuilder();
            String[] qs = q.split(":");
            for (int i = 1; i < qs.length; i++) {
                sb.append(qs[i]);
            }
            q = sb.toString();
        }

        // Extract any ints
        final List<Integer> ints = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(q);
        while (m.find()) {
            int i = Integer.parseInt(m.group());
            ints.add(i);
        }

        if (q.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (q.contains("name")) {
            return "horse-battery-66";
        }

        if (q.contains("is the largest")) {
            return Integer.toString(Collections.max(ints));
        }

        if (query.contains("plus")) {
            return Integer.toString(ints.stream().reduce(0, Integer::sum));
        }

        if (q.contains("cube") && q.contains("square")) {
            for (int i : ints) {
                if (perfectSquare(i) && perfectCube(i)) {
                    return Integer.toString(i);
                }
            }
        }

        if (q.contains("multiplied")) {
            return Integer.toString(ints.stream().reduce(1, (a, b) -> a * b));
        }

        if (q.contains("prime")) {
            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                if (isPrime(i)) {
                    sb.append(i);
                    sb.append(',');
                }
            }
            return sb.toString();
        }

        if (q.contains("theresa")) {
            return "2016";
        }

        return q;
    }

    public boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public boolean perfectSquare(int N) {
        double sqrt = Math.sqrt(N);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

    public boolean perfectCube(int N) {
        int cube;

        // Iterate from 1-N
        for (int i = 0; i <= N; i++) {

            // Find the cube of
            // every number
            cube = i * i * i;

            // Check if cube equals
            // N or not
            if (cube == N) {
                return true;
            } else if (cube > N) {
                return false;
            }
        }
        return false;
    }

}
