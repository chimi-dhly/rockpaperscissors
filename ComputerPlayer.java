package rockpaperscissors;

import java.util.Random;

public class ComputerPlayer extends Player{

    public void generateRandomShape() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0 -> setShape(Shape.rock);
            case 1 -> setShape(Shape.paper);
            case 2 -> setShape(Shape.scissors);
        }
    }
}
