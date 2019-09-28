package com.skorobahatko.practice5.serialization;

import java.io.*;

public class GroupSerializationTest {

    public static void main(String[] args) {
        Group group = new Group();
        group.addStudent(new Student("John Johnson", 1));
        group.addStudent(new Student("Peter Peterson", 2));
        group.addStudent(new Student("Jack Jackson", 3));
        group.addStudent(new Student("Will Willson", 4));

        serializeGroup("src/main/java/com/skorobahatko/practice5/serialization/serialized_group", group);

        Group deserializedGroup = deserializeGroup("src/main/java/com/skorobahatko/practice5/serialization/serialized_group");
        System.out.println(deserializedGroup);
    }

    public static void serializeGroup(String file, Group group) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group deserializeGroup(String file) {
        Group group = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            group = (Group) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return group;
    }

}
