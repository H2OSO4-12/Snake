package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Класс Main со свойствами главное окно
 *
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Main extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGTH = 700;
    private final JLabel label_score;
    static int live;
    /** счетчик */
    private final JLabel label_level;
    private final Home_panel home;
    /** панелька */
    private Game gm;
    private About about;
    private Help help;
    private Pause_panel pause;
    private Game_over_panel game_over;
    private static BufferedImage img;

    public Main() throws IOException {
        int level = 0;
        int score = 0;
        Main.setLive(3);
        setTitle("Snake");
        File file = new File("resources/image/background.jpg");
        img = ImageIO.read(file);
        setContentPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }

        });
        //setIconImage(new ImageIcon(Main.class.getResource("logo.png").getPath()).getImage());

        setFocusable(true);
        setResizable(false);
        /*
         * Размер окна
         */
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        /* Закрытие завершает код */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH); // размер на весь экран
        /* Отключаем менеджер компоновки */
        setLayout(null);
//        setUndecorated(true); // полноэкранный режим
        getContentPane().setBackground(Color.YELLOW);
        pack();
        /* Панелька настройки и начало игры */
        home = new Home_panel();
        add(home);

        /* Меню и справка и о разработчике */

        JMenuBar menuBar = new JMenuBar();
        JMenu refMenu = new JMenu("О программе");
        JMenuItem eMenuItem = new JMenuItem("Выход");
        eMenuItem.setToolTipText("Выход из программы");
        eMenuItem.addActionListener((_) -> System.exit(0));
        JMenuItem refMenuItem = new JMenuItem("Справка");
        refMenuItem.setToolTipText("Справка для программы");
        refMenuItem.addActionListener(_ -> helper_start());
        JMenuItem devMenuItem = new JMenuItem("О разработчике");
        devMenuItem.setToolTipText("Информация о разработчике");
        devMenuItem.addActionListener(_ -> about_start());
        menuBar.add(refMenu);
        refMenu.add(eMenuItem);
        refMenu.add(refMenuItem);
        refMenu.add(devMenuItem);
        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
        /* Считывание нажатия на кнопку play */
        home.getPlayButton().addActionListener(_ -> start_game());
        /*
         * JLabel Счетчик
         */
        label_score = new JLabel();
        label_score.setBounds(68, 15, 150, 50);
        label_score.setText("Счёт: " + score);
        /*  label_level Счетчик уровня */
        label_level = new JLabel();
        label_level.setBounds(320, 15, 150, 50);
        label_level.setText("Уровень: " + level);

        add(label_score);
        add(label_level);
        /* Видимость окна */
        setVisible(true);
    }


    /** Меняем при каждом добавлении score */
    public int update_score(int score) {
        label_score.setText("Счет " + score);
        return score;
    }

    /** Функция обновления уровня игры */
    public int update_level(int level) {
        label_level.setText("Уровень: " + level);
        return level;
    }

    /** Функция Запуска - начало игры */
    public void start_game() {
        gm = new Game(this);
        home.setVisible(false);
        update_level(gm.getLevel());
        update_score(gm.getScore());
        /* Добавление скорости игры */
        if (home.getCheck_level_1().isSelected()) {
            gm.getTimer().setDelay(gm.a += 20);
            gm.newObstacle(42);
            repaint();
        } else if (home.getCheck_level_2().isSelected()) {
            gm.getTimer().setDelay(gm.a -= 60);
            gm.newObstacle(66);
            repaint();
        } else if (home.getCheck_level_3().isSelected()) {
            gm.getTimer().setDelay(gm.a -= 90);
            gm.newObstacle(100);
            repaint();
        }
        if (home.checkbox_BColor_Black.isSelected()) {
            gm.setBackground(Color.BLACK);
            repaint();
        } else
            repaint();
        if (home.checkbox_BColor_yell.isSelected()) {
            gm.setBackground(Color.yellow);
            repaint();
        } else
            repaint();

        /* Добавление длинны змейки */
        if (home.getLen_3().isSelected()) {
            repaint();
        }
        if (home.getLen_6().isSelected()) {
            gm.getSnake().add(new Point(3, 0));
            gm.getSnake().add(new Point(4, 0));
            gm.getSnake().add(new Point(5, 0));
            repaint();
        }
        if (home.getLen_9().isSelected()) {
            gm.getSnake().add(new Point(3, 0));
            gm.getSnake().add(new Point(4, 0));
            gm.getSnake().add(new Point(5, 0));
            gm.getSnake().add(new Point(6, 0));
            gm.getSnake().add(new Point(7, 0));
            gm.getSnake().add(new Point(8, 0));
            repaint();
        } else
            repaint();

        /* Цвет змейки */
        if (home.SnGreen.isSelected()) {
            gm.setChangeColor(gm.changeColor = true);
            repaint();
        } else if (home.SnRed.isSelected()) {
            gm.setChangeColor(gm.changeColor = false);
            repaint();
        } else
            repaint();

        /* Добавляем игру */
        add(gm);
        /* Фокусируем игру */
        gm.requestFocus();
        /* Обновления компоновки (пересчитает размер и расположение компонентов) */
        revalidate();
        /* Обновления отрисовки компонентов */
        repaint();

    }

    /**
     * Функция вывода панельки пауза
     *
     */
    public void pause_start() {
        /* панелька паузы */
        pause = new Pause_panel(this);
        /* Убираем видимость */
        gm.setVisible(false);
        label_score.setVisible(false);
        label_level.setVisible(false);
        /* Добавляем в окно */
        this.add(pause);
        revalidate();
        repaint();
    }
    /**
     * Функция скрытия панельки пауза
     */

    public void pause_exit() {
        /* убираем паузу */
        this.remove(pause);
        /* Добавляем видимость */
        gm.setVisible(true);
        label_score.setVisible(true);
        label_level.setVisible(true);
        /* Фокусируем игру */
        gm.requestFocus();
        revalidate();
        repaint();
    }

    /**
     * Функция вывода панельки home
     *
     */
    public void start_home() {
        this.remove(pause);
        label_score.setVisible(true);
        label_level.setVisible(true);
        home.setVisible(true);
        /* фокусируем игру */
        gm.requestFocus();
        /* обновления компоновки (пересчитает размер и расположение компонентов) */
        revalidate();
        /* обновления отрисовки компонентов */
        repaint();
    }
    /**
     * Функция вывода панельки конец игры
     *
     */
    public void game_over_start() {
        /* панелька game over */
        game_over = new Game_over_panel(gm, this);
        /* Убираем видимость */
        gm.setVisible(false);
        label_score.setVisible(false);
        label_level.setVisible(false);
        /* добавляем в окно */
        this.add(game_over);
        revalidate();
        repaint();
    }
    /**
     * Функция скрытия панельки игра окончена
     */
    public void game_over_exit() {
        /* Убираем панельку */
        this.remove(game_over);
        gm.setVisible(true);
        label_score.setVisible(true);
        label_level.setVisible(true);
        /* Фокусируем игру */
        revalidate();
        repaint();
    }

    public void about_start() {
        about = new About(this);
        home.setVisible(false);
        label_score.setVisible(false);
        label_level.setVisible(false);
        this.add(about);
        revalidate();
        repaint();
    }

    public void about_exit() {
        this.remove(about);
        home.setVisible(true);
        label_score.setVisible(true);
        label_level.setVisible(true);
        revalidate();
        repaint();
    }

    public void helper_start()  {
        help = new Help(this);
        home.setVisible(false);
        label_score.setVisible(false);
        label_level.setVisible(false);
        this.add(help);
        revalidate();
        repaint();

    }

    public void helper_exit() {
        this.remove(help);
        home.setVisible(true);
        label_score.setVisible(true);
        label_level.setVisible(true);
        revalidate();
        repaint();
    }

    /**
     * Главный метод начало работы программы
     * @throws IOException Генерация ошибки
     */
    static void main() throws IOException {
        new Main();
    }

    /**
     * Возвращает значение x
     *
     * @return the x
     */
    public int getX() {
        int x;
        x = 50;
        return x;
    }


    /**
     * Возвращает значение y
     *
     * @return the y
     */
    public int getY() {
        int y;
        y = 50;
        return y;
    }
    /**
     * @return the live
     */
    public static int getLive() {
        return live;
    }

    /**
     * @param live to set
     */
    public static void setLive(int live) {
        Main.live = live;
    }
}
