package lab1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello {

    static List<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static class Task {
        String task;
        boolean completed;

        Task(String task, boolean completed) {
            this.task = task;
            this.completed = completed;
        }
    }

    public static void main(String[] args) {
        while (true) {
          
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Display Tasks");
            System.out.println("5. Switch Task Order");
            System.out.println("6. Clear Tasks");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    switchTasks();
                    break;
                case 6:
                	clearTasks();
                    break;
                case 7:
                 
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    //5:45PM 
    static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(new Task(task, false));
    }

    static void removeTask() {
        System.out.print("Enter index of task to remove: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid index.");
        }
    }

    static void markTaskCompleted() {
        System.out.print("Enter index of task to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).completed = true;
        } else {
            System.out.println("Invalid index.");
        }
    }

    static void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.task + " - " + (task.completed ? "Completed" : "Not done"));
        }
    }
    static void switchTasks() {
        System.out.print("Enter index of the first task to switch: ");
        int firstIndex = scanner.nextInt();
        System.out.print("Enter index of the second task to switch: ");
        int secondIndex = scanner.nextInt();

        if (firstIndex >= 1 && firstIndex <= tasks.size() && secondIndex >= 1 && secondIndex <= tasks.size()) {
            Task temp = tasks.get(firstIndex - 1);
            tasks.set(firstIndex - 1, tasks.get(secondIndex - 1));
            tasks.set(secondIndex - 1, temp);
            System.out.println("Tasks order switched.");
        }
    }
    static void clearTasks() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }

} //5:54


    
   





