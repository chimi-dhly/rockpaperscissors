package rockpaperscissors;


public class Game {
    private final HumanPlayer human;
    private final ComputerPlayer computer;
    private Result result;
    private GameState state;

    public Game() {
        this.human = new HumanPlayer();
        this.computer = new ComputerPlayer();
        this.state = GameState.ON;
    }

    public void startGame() {
        while (isRunningGame()) {
            playRound(human, computer);
        }
    }

    public void playRound(HumanPlayer human, ComputerPlayer computer) {
        try {
            //if the input is a command
            human.getUserInput();
            computer.generateRandomShape();
            compareWinners();
            if (!human.isCommandInput()) {
                printRoundResult();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input");
        }
    }

    private void printRoundResult() {
        switch (result) {
            case WIN -> System.out.printf("Well done. The computer chose %s and failed\n", computer.getShape());
            case LOSS -> System.out.printf("Sorry, but the computer chose %s\n", computer.getShape());
            case DRAW -> System.out.printf("There is a draw (%s)\n", computer.getShape());
        }
    }

    public void compareWinners() {
        if (human.getShape() == computer.getShape()) {
            result = Result.DRAW;
        } else switch (human.getShape()) {
            case rock -> {
                switch (computer.getShape()) {
                    case scissors -> setResult(Result.WIN);
                    case paper -> setResult(Result.LOSS);
                }
            }
            case paper -> {
                switch (computer.getShape()) {
                    case scissors -> setResult(Result.LOSS);
                    case rock -> setResult(Result.WIN);
                }
            }
            case scissors -> {
                switch (computer.getShape()) {
                    case rock -> setResult(Result.LOSS);
                    case paper -> setResult(Result.WIN);
                }
            }
            case exit -> exit();
        }
    }

    private void exit() {
        System.out.println("Bye");
        state = GameState.OFF;
    }

    private void setResult(Result result) {
        this.result = result;
    }

    private boolean isRunningGame() {
        return state == GameState.ON;
    }
}
