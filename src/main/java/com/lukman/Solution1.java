package com.lukman;

import java.util.*;

public class Solution1 {

    public List<Map<String, String>> storeMap(String text) {

        List<Map<String, String>> arrayMap = new ArrayList();
        String[] items = text.split("\n");

        for(int x = 0; x < items.length; x++) {
            // Seperator is specified here, to split string on this basis
            Map<String, String> map = new HashMap<String, String>();
            for (String keyValue : items[x].split(";")) {

                // Here the each part is futher splitted taking in account the equal sign ‘=’ which demarcates the key
                // and valuefor the hashmap
                String[] pairs = keyValue.split("=");

                // Those key and values are then put into hashmap
                map.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
            }
            arrayMap.add(map);
        }
        return arrayMap;
    }

    public static String loadMap(List<Map<String, String>> arr) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, String> map : arr) {
            int counter = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (counter > 0) {
                    builder.append(";");
                }
                builder.append(entry.getKey()).append("=").append(entry.getValue());
                counter++;
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    public void printMap(List<Map<String, String>> map){
        System.out.println(map);
    }
}
