package com.skorobahatko.practice2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static String readAll(String path, String charset) throws IOException {
        return Files.readString(Paths.get(path), Charset.forName(charset));
    }

}
