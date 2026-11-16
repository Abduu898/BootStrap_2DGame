import java.util.Scanner;

public class Game {
    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== GRID QUEST ===");
        System.out.println("8=up  2=down  4=left  6=right  0=quit");

        boolean running = true;
        while (running) {
            System.out.print("> ");
            int dir = sc.nextInt();
            switch (dir) {
                case 8: System.out.println("You move UP");    break;
                case 2: System.out.println("You move DOWN");  break;
                case 4: System.out.println("You move LEFT");  break;
                case 6: System.out.println("You move RIGHT"); break;
                case 0:
                    System.out.println("Bye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        sc.close();
    }
}