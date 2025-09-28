import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class NotesManager {
    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt"; // File for saving your notes

        while (true) {
            System.out.println("\n--- NOTES MANAGER ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            int op = Integer.parseInt(sc.nextLine());

            if (op == 1) {
                // Take note from user and save to file
                System.out.print("Type your note: ");
                String note = sc.nextLine();

                // Open file in append mode, write note, add newline, close
                FileWriter fw = new FileWriter(fileName, true);
                fw.write(note + System.lineSeparator());
                fw.close();
                System.out.println("Note saved!");
            } else if (op == 2) {
                // Read and show all notes line by line
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String line;
                int count = 1;
                System.out.println("--- Your Notes ---");
                while ((line = br.readLine()) != null) {
                    System.out.println(count++ + ". " + line);
                }
                br.close();
            } else if (op == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}
