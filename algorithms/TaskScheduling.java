package com.day14.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int deadline;
    int timeRequired;

    public Task(int deadline, int timeRequired) {
        this.deadline = deadline;
        this.timeRequired = timeRequired;
    }
}

public class TaskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of tasks
        int T = scanner.nextInt();

        Task[] tasks = new Task[T];

        // Input the deadlines and time required for each task
        for (int i = 0; i < T; i++) {
            int deadline = scanner.nextInt();
            int timeRequired = scanner.nextInt();
            tasks[i] = new Task(deadline, timeRequired);
        }

        // Sort tasks based on deadlines in descending order
        Arrays.sort(tasks, Comparator.comparingInt(task -> -task.deadline));

        // Calculate and output the maximum overshoot for each task
        for (int i = 0; i < T; i++) {
            System.out.println(calculateOvershoot(tasks, i));
        }
    }

    private static int calculateOvershoot(Task[] tasks, int index) {
        int totalCompletionTime = 0;
        int maxOvershoot = 0;

        for (int i = 0; i <= index; i++) {
            totalCompletionTime += tasks[i].timeRequired;
            int overshoot = Math.max(0, totalCompletionTime - tasks[i].deadline);
            maxOvershoot = Math.max(maxOvershoot, overshoot);
        }

        return maxOvershoot;
    }
}
