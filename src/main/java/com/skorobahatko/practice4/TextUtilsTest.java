package com.skorobahatko.practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextUtilsTest {

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Path.of("src/main/java/com/skorobahatko/practice4/file.txt")));
        System.out.println(TextUtils.countWordsFromText(text));

        System.out.println(TextUtils.countWordsFromTextSortedBy(text, SortingOrder.DESCENDING));
        System.out.println(TextUtils.countWordsFromTextSortedBy(text, SortingOrder.ASCENDING));
    }

}
