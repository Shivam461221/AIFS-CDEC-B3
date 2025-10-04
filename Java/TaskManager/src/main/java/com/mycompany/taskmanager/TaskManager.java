/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taskmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author shiva
 */
public class TaskManager {

    public static final String FILE_NAME = "C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\task.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        int choice;

        do {
            System.out.println("\n======Task Manager======");
            System.out.println("1. Add a Task");
            System.out.println("2. View All Task");
            System.out.println("3. Delete a Task1");
            System.out.println("4. ");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                     viewTasks();
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    searchTask(scanner);
                    break;
                case 5:
                    System.out.println("Existing.....");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice!=5);
       
    }

    public static void addTask(Scanner scanner) {
        System.out.println("Enter your task");
        String task = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(task + "\n");
            System.out.println("Task saved");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing task");
            System.out.println(e);
        }
    }

    public static List<String> readAllTask() {
        List<String> tasks = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        return tasks;
    }

    public static void viewTasks() {
        List<String> tasks = readAllTask();

        if (tasks.isEmpty()) {
            System.out.println("No tasks");
        } else {
            System.out.println("\nYour Tasks----------");
            int count = 1;
            for (String str : tasks) {

                System.out.println(count + " : " + str);
                count++;
            }
        }
    }

    public static void deleteTask(Scanner scanner) {
        List<String> tasks = readAllTask();

        if (tasks.isEmpty()) {
            System.out.println("No tasks");
            return;
        }

        viewTasks();

        System.out.println("Enter task number to delete: ");
        int taskNum = scanner.nextInt();
        scanner.nextLine();

        if (taskNum < 1 || taskNum > tasks.size()) {
            System.out.println("Invalid task number");
            return;
        }

        tasks.remove(taskNum - 1);

        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (String task : tasks) {
                writer.write(task + "\n");
            }
            System.out.println("Task deleted");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void searchTask(Scanner scanner){
        
    }

}
