package class4;

import java.util.LinkedList;

public class TshirtOrders {

    // Helper method to display the list
    public static void displayStudentList(String listName, LinkedList<String> students) {
        System.out.println("--- " + listName + " ---");
        if (students.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            int i = 1;
            for (String student : students) {
                System.out.println(i + ". " + student);
                i++;
            }
        }
        System.out.println(); // Add a blank line for better readability
    }

    public static void main(String[] args) {
        // 1. Initialize a LinkedList and add names
        LinkedList<String> studentList = new LinkedList<>();
        
        // Names to add
        String[] namesToAdd = {"James", "Luca", "Tang", "John", "Jane", "May", "Bee", "Jazz"};
        for (String name : namesToAdd) {
            studentList.add(name);
        }

        // 2. Display the initial list
        displayStudentList("Initial T-Shirt Order List", studentList);

        // 3. Names to remove
        String[] namesToRemove = {"Luca", "May", "James"};
        System.out.println("--- Removing students who received T-shirts ---");
        for (String name : namesToRemove) {
            boolean removed = studentList.remove(name); // remove() returns true if the element was found and removed
            if (removed) {
                System.out.println("Removed: " + name);
            } else {
                System.out.println(name + " not found in the list.");
            }
        }
        System.out.println();

        // 4. Display the list after removals
        displayStudentList("Updated T-Shirt Order List (After Removals)", studentList);
    }
}