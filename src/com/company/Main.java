package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<Effect> Oct18 = new ArrayList<>();
    static ArrayList<Effect> Nov18 = new ArrayList<>();
    static ArrayList<Effect> Dec18 = new ArrayList<>();
    static ArrayList<Effect> Jan19 = new ArrayList<>();
    static ArrayList<Effect> Feb19 = new ArrayList<>();
    static ArrayList<Effect> Mar19 = new ArrayList<>();
    static ArrayList<Effect> Apr19 = new ArrayList<>();
    static ArrayList<Effect> May19 = new ArrayList<>();
    static ArrayList<Effect> Jun19 = new ArrayList<>();
    static ArrayList<Effect> Jul19 = new ArrayList<>();
    static ArrayList<Effect> Aug19 = new ArrayList<>();
    static ArrayList<Effect> Sept19 = new ArrayList<>();
    static ArrayList<Effect> Oct19 = new ArrayList<>();
    static ArrayList<Effect> Nov19 = new ArrayList<>();
    static ArrayList<Effect> Dec19 = new ArrayList<>();
    static ArrayList<Effect> Jan20 = new ArrayList<>();
    static ArrayList<Effect> Feb20 = new ArrayList<>();
    static ArrayList<Effect> Mar20 = new ArrayList<>();
    static ArrayList<ArrayList<Effect>> data = new ArrayList<>();

    static int position;
    static boolean simulation;

    public static void main(String[] args) {
	    initialize();
        System.out.println("\nWelcome! Please enter your commands below:\n");
	    while (true) {
	        String command = readCommand();
	        parseCommand(command);
	        if (simulation) {
	            run();
	            simulation = false;
            }
	    }
    }

    static void initialize() {
        data.add(Oct18);
        data.add(Nov18);
        data.add(Dec18);
        data.add(Jan19);
        data.add(Feb19);
        data.add(Mar19);
        data.add(Apr19);
        data.add(May19);
        data.add(Jun19);
        data.add(Jul19);
        data.add(Aug19);
        data.add(Sept19);
        data.add(Oct19);
        data.add(Nov19);
        data.add(Dec19);
        data.add(Jan20);
        data.add(Feb20);
        data.add(Mar20);
    }

    static String readCommand() {
        return scanner.nextLine();
    }

    static void parseCommand(String message) {
        String [] sections = message.split(" ");
        String desc = null;
        if (sections.length > 1) {
            desc = sections[1];
        }
        switch (sections[0]) {
            case "set":
                position = Integer.parseInt(desc);
                break;
            case "run":
                simulation = true;
                break;
            case "recur":
                for (int i = 0; i < 18; i++) {
                    data.get(i).add(new RecurringEffect(Integer.parseInt(sections[2]), sections[1]));
                }
                break;
            case "randev":
                int lowerVal = Integer.parseInt(sections[2]);
                int upperVal = Integer.parseInt(sections[3]);
                int time = Integer.parseInt(sections[4]);
                data.get(time - 1).add(new RandomEvent(0, desc, lowerVal, upperVal));
                break;
            case "randeff":
                int value = Integer.parseInt(sections[2]);
                float probability = Float.parseFloat(sections[3]);
                for (int i = 0; i < 18; i++) {
                    data.get(i).add(new RandomEffect(value, desc, probability));
                }
                break;
        }
    }

    static void run() {
        TimerTask timerTask = new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                resolve(i);
                i++;
                if (i == 18) {
                    cancel();
                }
            }
        };

        Timer timer = new Timer("timer");
        timer.scheduleAtFixedRate(timerTask, 500, 1000);
    }

    static void resolve(int i) {
        System.out.println("\n=================================== Month " + (i + 1) + "\n");
        int overallChange = 0;
        for (Effect e: data.get(i)) {
            int change = e.getValue();
            String prefix = change == 0 ? " " : (change > 0) ? "+" : "";
            System.out.println(prefix + change + " " + e.getDescription());
            overallChange += change;
        }
        System.out.println("\nOverall Change: " + overallChange);
        System.out.println(position + " --> " + (position + overallChange));
        position += overallChange;
    }
}
