package com.skorobahatko.lecture6;

import java.io.*;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        readAndWriteprimitiveDataTypes("data");

        Human human = new Human("John", 25, "1234");
        serializeHuman(human, "human");

        Human deserializedHuman = deserializeHuman("human");
        System.out.println(deserializedHuman);
    }

    public static void copyFileBySymbolicStream(String src, String dst) {
        try (BufferedReader br = new BufferedReader(new FileReader(src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dst))) {
            String curLine = null;
            while ((curLine = br.readLine()) != null) {
                bw.write(curLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByByteStream(String src, String dst) {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int count = -1;
            while ((count = in.read(buf)) != -1) {
                out.write(buf, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteprimitiveDataTypes(String file) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
             DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            out.writeInt(123);
            out.writeDouble(23.45);
            out.writeBoolean(true);
            System.out.println(in.readInt());
            System.out.println(in.readDouble());
            System.out.println(in.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeHuman(Human human, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(human);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Human deserializeHuman(String file) {
        Human human = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            human = (Human) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static void saveProperties(Properties prop, String file, String description) {
        try {
            prop.store(new FileOutputStream(file), description);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
    }

    public static Properties loadProperties(String file) {
        // TODO
        return null;
    }

}
