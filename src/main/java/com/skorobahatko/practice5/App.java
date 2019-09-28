package com.skorobahatko.practice5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class App {

    public static void main(String[] args) {
        createAndFillFileWithRandomNumbers();

        List<Integer> sortedNumbers = getAndSortRandomNumbersFromFile();
        System.out.println(sortedNumbers);

        printBestStudentsByGradeFromFile("src/main/java/com/skorobahatko/practice5/students", 90);

        swapFirstAndLastWordsInLines("src/main/java/com/skorobahatko/practice5/text", "src/main/java/com/skorobahatko/practice5/swaped_text");

        copyFile("src/main/java/com/skorobahatko/practice5/src", "src/main/java/com/skorobahatko/practice5/dst");
    }

    public static void createAndFillFileWithRandomNumbers() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("randomNumbers"))) {
            Random rnd = new Random();
            for (int i = 0; i < 100; i++) {
                out.writeInt(rnd.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getAndSortRandomNumbersFromFile() {
        List<Integer> numbers = null;
        try (DataInputStream out = new DataInputStream(new FileInputStream("randomNumbers"))) {
            numbers = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                numbers.add(out.readInt());
            }
            numbers.sort(Comparator.naturalOrder());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static void printBestStudentsByGradeFromFile(String file, int minGrade) {
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" = ");
                String studentName = tokens[0];
                int studentGrade = Integer.parseInt(tokens[1]);
                if (studentGrade >= minGrade) {
                    System.out.println(studentName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void swapFirstAndLastWordsInLines(String srcFile, String dstFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(srcFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dstFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                int indexOfFirstSpace = line.indexOf(" ");
                int indexOfLastSpace = line.lastIndexOf(" ");
                String firstWord = line.substring(0, indexOfFirstSpace);
                String lastWord = line .substring(indexOfLastSpace + 1, line.length());
                String middle = line.substring(indexOfFirstSpace, indexOfLastSpace + 1);
                String result = lastWord.concat(middle).concat(firstWord).concat("\n");
                bw.write(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String srcFile, String dstFile) {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(srcFile));
            Files.write(Path.of(dstFile), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
