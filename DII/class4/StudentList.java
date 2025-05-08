package class4;

import java.util.LinkedList;

public class StudentList {
    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();

        // Add names
        studentNames.add("James");
        studentNames.add("Luca");
        studentNames.add("Tang");
        studentNames.add("John");
        studentNames.add("Jane");
        studentNames.add("May");
        studentNames.add("Bee");
        studentNames.add("Jazz");

        // Display the initial list
        System.out.println("Student names who ordered a T-shirt (before removal):");
        displayList(studentNames);

        // Remove names (one by one as requested)
        System.out.println("\nRemoving names of students who received the T-shirt...");
        studentNames.remove("Luca");
        System.out.println("Removed Luca:");
        displayList(studentNames);

        studentNames.remove("May");
        System.out.println("Removed May:");
        displayList(studentNames);

        studentNames.remove("James"); // The prompt asks to remove James last
        System.out.println("Removed James:");
        displayList(studentNames);

        // Display the list after removal
        System.out.println("\nStudent names who ordered a T-shirt (after removal):");
        displayList(studentNames);
    }

    // Helper method to display the list
    public static void displayList(LinkedList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (String name : list) {
                System.out.println("- " + name);
            }
        }
    }
}
