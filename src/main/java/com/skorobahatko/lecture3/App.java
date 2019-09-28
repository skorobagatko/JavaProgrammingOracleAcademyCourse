package com.skorobahatko.lecture3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {

        String html = "<head>" +
                "        <meta charset=\"utf-8\">" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" +
                "        <meta http-equiv=\"language\" content=\"en\">" +
                "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";

        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }

}
