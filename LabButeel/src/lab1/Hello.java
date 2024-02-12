package lab1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello<T> {
	List<Task<T>> tasks = new ArrayList<>(); 

    static class Task<T> {
        T task;
        boolean completed;

        Task(T task, boolean completed) {
            this.task = task;
            this.completed = completed;
        }
    }
    public static void main(String[] args) {
    	Hello<String> hello = new Hello<>();
        hello.run(); 
    //5:45PM 
    }
    
    
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
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
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    markTaskCompleted(scanner);
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    switchTasks(scanner);
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

    void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        T task = (T) scanner.nextLine();
        tasks.add(new Task<T>(task, false));
    }

    void removeTask(Scanner scanner) {
        System.out.print("Enter index of task to remove: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid index.");
        }
    }

    void markTaskCompleted(Scanner scanner) {
        System.out.print("Enter index of task to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).completed = true;
        } else {
            System.out.println("Invalid index.");
        }
    }

    void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task<T> task = tasks.get(i); // 
            System.out.println((i + 1) + ". " + task.task + " - " + (task.completed ? "Completed" : "Not done"));
        }
    }

    void switchTasks(Scanner scanner) {
        System.out.print("Enter index of the first task to switch: ");
        int firstIndex = scanner.nextInt();
        System.out.print("Enter index of the second task to switch: ");
        int secondIndex = scanner.nextInt();

        if (firstIndex >= 1 && firstIndex <= tasks.size() && secondIndex >= 1 && secondIndex <= tasks.size()) {
            Task<T> temp = tasks.get(firstIndex - 1); 
            tasks.set(firstIndex - 1, tasks.get(secondIndex - 1));
            tasks.set(secondIndex - 1, temp);
            System.out.println("Tasks order switched.");
        }
    }

    void clearTasks() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }
}//9:54