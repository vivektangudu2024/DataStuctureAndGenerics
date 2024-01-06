package com.day14.datastructures;

public class Calender {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Calendar <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1); // Set the calendar to the first day of the specified month

        int[][] calendarArray = new int[6][7]; // 2D array to store the calendar

        // Fill the array with the days of the month
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
        int maxDayOfMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        int currentDay = 1;

        for (int week = 0; week < calendarArray.length; week++) {
            for (int day = 0; day < calendarArray[week].length; day++) {
                if (week == 0 && day < dayOfWeek) {
                    calendarArray[week][day] = 0; // Empty cell before the first day
                } else if (currentDay <= maxDayOfMonth) {
                    calendarArray[week][day] = currentDay;
                    currentDay++;
                } else {
                    calendarArray[week][day] = 0; // Empty cell after the last day
                }
            }
        }

        // Print the calendar
        System.out.println("Calendar for " + java.time.Month.of(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int week = 0; week < calendarArray.length; week++) {
            for (int day = 0; day < calendarArray[week].length; day++) {
                if (calendarArray[week][day] == 0) {
                    System.out.print("    "); // Empty space for days not in the month
                } else {
                    System.out.printf("%3d ", calendarArray[week][day]);
                }
            }
            System.out.println();
        }
    }
}
