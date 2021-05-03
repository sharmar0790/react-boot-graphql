package com.graphql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vonage {


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int k = 0;
        List<Integer> inputArray = new ArrayList<>();
        /*while ((line = in.readLine()) != null) {
            if (line.equalsIgnoreCase("break")) {
                break;
            } else if (line.length() == 1) {
                k = Integer.valueOf(line);
            } else if (line.length() > 1) {
                inputArray = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

            }
        }*/

        k = 3;
        inputArray = Arrays.asList(1, 5, 4, 3, 6, 3, 7, 8, 9);
        getFinalMedians(k, inputArray);
    }

    private static int getFinalMedians(int k, List<Integer> inputArray) {
        List<List<Integer>> temp = getSublist(inputArray, k);

        List<Integer> medianList = getMedians(temp);

        if (medianList.size() > k) {
            return getFinalMedians(k, medianList);
        } else {
            Collections.sort(medianList);
            return getMedian(medianList);
        }
    }


    private static List<List<Integer>> getSublist(List<Integer> inputArray, int k) {
        List<List<Integer>> temp = new ArrayList<>();

        int start = 0;
        int to = k;
        while (start < inputArray.size()) {
            if (to > inputArray.size()) {
                temp.add(inputArray.subList(start, inputArray.size()));
            } else {
                temp.add(inputArray.subList(start, to));
            }
            start = to;
            to = to + k;
        }
        return temp;
    }

    private static int getMedian(List<Integer> temp) {
        if ((temp.size()) % 2 != 0) {
            return temp.get(temp.size() / 2);
        } else if (temp.size() == 2) {
            return temp.get(0);
        } else {
            return temp.get(temp.size() / 2);
        }

    }

    private static List<Integer> getMedians(List<List<Integer>> temp) {
        List<Integer> medianList = new ArrayList<>();
        for (List<Integer> integers : temp) {
            Collections.sort(integers);
            if ((integers.size()) % 2 != 0) {
                medianList.add(getMedian(integers));
            } else if (integers.size() == 2) {
                medianList.add(getMedian(integers));
            } else {
                medianList.add(getMedian(integers));
            }

        }
        return medianList;

    }


}
