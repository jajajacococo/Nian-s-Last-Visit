//importing packages and utilities
package nianproject;
import java.io.*;

/**
 * writes to a file about its score, task completed etc.
 * @author Jacob Zheng
 */
public class Score {
    /**
     * Writes a completed task to the scores.txt file.
     * @param task The description of the completed task.
     */
    public static void writeFileTask(String task) {
        try {
            FileWriter writer = new FileWriter("scores.txt", true); // initiates the FileWriter 
             PrintWriter printer = new PrintWriter(writer); // initiates the PrintWriter 
            printer.println("Task: " + task); //prints the task completed
        } catch (IOException e) { // catch if error
            System.err.println(e);
        }
    }
    /**
     * Writes if the player won or lost, and the time if they won.
     * @param state True if the player won, false if they lost.
     * @param time  The time it took to win, only relevant if state is true.
     */
    public static void writeFileState(boolean state, String time) {
        try {
            FileWriter writer = new FileWriter("scores.txt", true);
            PrintWriter printer = new PrintWriter(writer) ;
            if (state) { // checks if state is true == win, false == lose
                printer.println("Win! | Time: " + time); // prints win and time
            } else {
                printer.println("Lose... Try Again.."); // print lose
            }
        } catch (IOException e) { // catch if error
            System.err.println(e);
        }
    }
    /**
     * Writes a specific interaction based on what the player touched.
     * @param touched The type of object touched
     */
    public static void interaction(String touched) {
        try {
            FileWriter inter = new FileWriter("interaction.txt", true);
            PrintWriter interaction = new PrintWriter(inter); 
            
            // what ever touched equals to it will write Touching __(touched)____
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

        } catch (IOException e) { // catch if error
            System.err.println(e);
        }
    }
    /**
     * writes a transition or scene change to the interaction.txt file.
     * @param trans The transition message or label to log.
     */
    public static void transition(String trans) {
        try {
            FileWriter inter = new FileWriter("interaction.txt", true);
            PrintWriter interaction = new PrintWriter(inter); 
            interaction.println(trans); // prints the string parameter
        } catch (IOException e) { // catch if error
            System.err.println(e);
        }
    }
}
