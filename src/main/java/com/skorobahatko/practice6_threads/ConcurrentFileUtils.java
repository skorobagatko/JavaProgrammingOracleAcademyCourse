package com.skorobahatko.practice6_threads;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class ConcurrentFileUtils {

    public static void main(String[] args) {
//        concurrentFindAllFilesByName(new File("src/main/java/com/skorobahatko"), "txt");

        concurrentCopyAllFileOldStyle("src/main/java/com/skorobahatko/practice6_threads/src_dir",
                "src/main/java/com/skorobahatko/practice6_threads/dst_dir");
    }

    public static void concurrentFindAllFilesByName(File file, String extension) {
        if (file.isDirectory()) {
            new Thread(() -> {
                File[] files = file.listFiles();
                if (files.length > 0) {
                    for (File f : files) {
                        concurrentFindAllFilesByName(f, extension);
                    }
                }
            }).start();
        } else if (file.getName().endsWith(extension)) {
            System.out.println(file.getName());
            synchronized (ConcurrentFileUtils.class) {
                try {
                    Files.writeString(
                            Path.of("src/main/java/com/skorobahatko/practice6_threads/files.txt"),
                            file.getName() + "\n",
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void concurrentCopyAllFileOldStyle(String srcPath, String dstPath) {
        File src = new File(srcPath);
        if (src.isDirectory()) {
            File dst = new File(dstPath);
            dst.mkdir();
            File[] files = src.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    concurrentCopyAllFileOldStyle(file.getAbsolutePath(), dstPath + System.getProperty("file.separator") + file.getName());
                } else if (file.isFile()) {
                    File newFile = new File(dst.getAbsolutePath() + System.getProperty("file.separator") + file.getName());
                    try (FileInputStream in = new FileInputStream(file);
                         FileOutputStream out = new FileOutputStream(newFile)) {
                        byte[] buf = new byte[1024];
                        int count = 0;
                        while ((count = in.read(buf)) != -1) {
                            out.write(buf, 0, count);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void concurrentCopyAllFileNewStyle(String srcPath, String dstPath) {
        try {
            Files.copy(Path.of(srcPath), Path.of(dstPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
