package nianproject;

import java.io.*;

public class Score {

    public static void writeFileTask(String task) {
        try (FileWriter writer = new FileWriter("scores.txt", true);
             PrintWriter printer = new PrintWriter(writer)) {
            printer.println("Task: " + task);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void writeFileState(boolean state, String time) {
        try (FileWriter writer = new FileWriter("scores.txt", true);
             PrintWriter printer = new PrintWriter(writer)) {
            if (state) {
                printer.println("Win! | Time: " + time);
            } else {
                printer.println("Lose... Try Again..");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void interaction(String touched) {
        try (FileWriter inter = new FileWriter("interaction.txt", true);
             PrintWriter interaction = new PrintWriter(inter)) {

            switch (touched) {
                case "item":
                    interaction.println("Touching Item");
                    break;
                case "building":
                    interaction.println("Touching Building");
                    break;
                case "villager":
                    interaction.println("Touching Villager");
                    break;
                case "paper":
                    interaction.println("Touching Paper");
                    break;
                default:
                    interaction.println("Touching Unknown");
                    break;
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void transition(String trans) {
        try (FileWriter inter = new FileWriter("interaction.txt", true);
             PrintWriter interaction = new PrintWriter(inter)) {
            interaction.println(trans);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
