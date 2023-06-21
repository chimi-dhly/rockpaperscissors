package rockpaperscissors;

import java.util.Scanner;

public final class HumanPlayer extends Player {
    public void getUserInput() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()) {
            case "rock" -> shape = Shape.rock;
            case "paper" -> shape = Shape.paper;
            case "scissors" -> shape = Shape.scissors;
            case "!exit" -> shape = Shape.exit;
            default -> throw new IllegalArgumentException("Unexpected value: ");
        }
    }

    public boolean isCommandInput() {
        return getShape().equals(Shape.exit);
    }
}
