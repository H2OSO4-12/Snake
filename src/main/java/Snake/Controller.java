package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс Controller со свойствами контроллер управления игрой
 * @author  Osetrov Vladimir
 * @version 1.1
 */

public class Controller extends KeyAdapter {
    Game game;
    Main main;

    Controller(Game game, Main main){
        this.game = game;
        this.main = main;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        /* Чтобы при паузе нельзя было менять направление */

        if (game.getTimer().isRunning()) {

            /* Константы для клавиш */

            switch (key) {
                case KeyEvent.VK_UP:
                    game.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    game.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    game.setDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.setDirection(Direction.RIGHT);
                    break;
                case KeyEvent.VK_SPACE:
                    game.getTimer().stop();
                    main.pause_start();
                    break;
            }
        }
        else game.getTimer().start();

    }

}