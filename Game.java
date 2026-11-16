import java.util.Scanner;

public class Game {
	public void play() {
		Scanner sc = new Scanner(System.in);
		while (!gameOver() && !victory()) {
			switch (sc.nextInt()) {
			case 8: // the player moves up
				break;
			case 6: // the player moves right
				break;
			case 2: // the player moves down
				break;
			case 4: // the player moves left
				break;
			default:
				return;
			}
		}
		if (gameOver()) {
			System.out.println("Game over");
		} else if (victory()) {
			System.out.println("Congratulations !");
		}
		sc.close();
	}

	private boolean gameOver() {
		return false;
	}

	private boolean victory() {
		return false;
	}
}