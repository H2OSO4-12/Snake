package Snake;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Класс Resources со свойствами источник jpg файлов</b>.
 *  @author Osetrov Vladimir
 * @version 1.1
 */

public class Resources {
    /** Константы */
    public static ImageIcon ICON_PLAY;
    public static ImageIcon ICON_EXIT;
    public static ImageIcon ICON_RESTART;
    public static ImageIcon ICON_CONTINUE;
    public static ImageIcon apple;
    public static ImageIcon BACKGROUND;

    static {

        BACKGROUND = new ImageIcon("resources/image/background.jpg");
        ICON_PLAY = new ImageIcon("resources/image/play.png");
        ICON_EXIT = new ImageIcon("resources/image/exit.png");
        ICON_RESTART = new ImageIcon("resources/image/restart.png");
        ICON_CONTINUE = new ImageIcon("resources/image/continue.png");
        apple = new ImageIcon("resources/image/m.png");
    }
}