package com.skorobahatko.practice2;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        String text = FileUtils.readAll("names.html", "UTF-8");
        String regex = "<td>(?<name>[a-zA-Z]+?)</td>";

        List<String> names = TextParseUtils.parseByGroup(text, regex, "name");

        System.out.println(names);
    }

}
