package com.skorobahatko.practice4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    private TextUtils() {}

    public static Map<String, Integer> countWordsFromText(String text) {
        if (text == null) return null;
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);
        Map<String, Integer> wordsMap = new HashMap<>();
        while (matcher.find()) {
            String word = matcher.group();
            wordsMap.merge(word, 1, Integer::sum);
        }
        return wordsMap;
    }

    public static Map<String, Integer> countWordsFromTextSortedBy(String text, SortingOrder order) {
        Comparator<String> comp = (order == SortingOrder.ASCENDING) ? Comparator.naturalOrder() : Comparator.reverseOrder();
        Map<String, Integer> words = new TreeMap<>(comp);
        words.putAll(countWordsFromText(text));
        return words;
    }

}
