package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Класс Game со свойствами - панель для игры
 *
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Game extends JPanel implements ActionListener {
    Main main;
    final int SNAKE_SIZE = 10;
    final int APPLE_SIZE = 10;
    final int OBSTACLE_SIZE = 10;
    private int score;
    private int level;
    private boolean game;
    private List<Point> snake = new ArrayList<>();
    private final List<Point> apples = new ArrayList<>();
    private final List<Point> obstacles = new ArrayList<>();
    private final Random rng = new Random();

    /** Начальное направление движения змейки вправо */

    private Direction direction = Direction.DOWN;
    private Timer timer;
    private int round = 12;
    private final Color green_color = Color.green;
    private final Color red_color = Color.red;
    int a = 180;
    boolean changeColor = false;

    /**
     * Конструктор панели игры Game
     */

    Game(Main main) {
        this.main = main;
        this.setLevel(1);
        this.setScore(0);
        this.setBounds(68, 57, Main.WIDTH - 130, Main.HEIGTH - 130);
        this.setLayout(null);
        Color white_color = Color.white;
        this.setBackground(white_color);
        this.addKeyListener(new Controller(this, main));
        this.setFocusable(true);
        Main.setLive(Main.getLive() -1);
        if(Main.getLive()==-1) Main.setLive(3);
        this.start();
    }


    /**
     * Метод start со свойствами инициализация начало игры
     */
    void start() {
        game = true;
        // длинна змеи
        getSnake().add(new Point(2, 0));
        getSnake().add(new Point(1, 0));
        getSnake().add(new Point(0, 0));
        newApple();
        newObstacle(round);
        setTimer(new Timer(a, this));
        getTimer().start();
    }

    /**
     * Метод newApple генерация нового объекта яблока
     */

    void newApple() {
        while (true) {
            Point apple = new Point(rng.nextInt(getWidth() / APPLE_SIZE), rng.nextInt(getHeight() / APPLE_SIZE));
            if (!apples.contains(apple) && !getSnake().contains(apple)) { // если яблока с такими координатами нет и не на
                // змее
                apples.add(apple);
                break;
            }
        }
    }

    /**
     * Метод newObstacle генерация нового объекта препятствия
     */

    void newObstacle(int round) {
        int r;
        for (r = 0; r < round; r++)
            while (true) {
                Point obstacle = new Point(rng.nextInt(getWidth() / OBSTACLE_SIZE),
                        rng.nextInt(getHeight() / OBSTACLE_SIZE));
                if (!obstacles.contains(obstacle) && !getSnake().contains(obstacle) && !apples.contains(obstacle)) {
                    obstacles.add(obstacle);
                    break;
                }
            }
    }

    /**
     * Метод snake_move движение змеи
     */

    void snake_move() {

        Point head = getSnake().getFirst();
        int dx = head.x, dy = head.y;
        switch (direction) {
            case UP:
                dy -= 1;
                break;
            case DOWN:
                dy += 1;
                break;
            case RIGHT:
                dx += 1;
                break;
            case LEFT:
                dx -= 1;
                break;

        }

        Point newHead = new Point(dx, dy);
        getSnake().addFirst(newHead);

        /*
         *  Если вышел за границу
         */

        if (newHead.x < 0 || newHead.y < 0 || newHead.x >= getWidth() / SNAKE_SIZE
                || newHead.y >= getHeight() / SNAKE_SIZE) {

            game = false;
            return;
        }

        /*
         * Если врезался в себя
         */

        if (getSnake().subList(1, getSnake().size()).contains(newHead)) {
            game = false;
            return;
        }
        /*
         * Если яблоко - увеличиваем счетчик
         */

        if (apples.contains(newHead)) {
            this.setScore(this.getScore() + 1);
            apples.remove(newHead);
            /*
             * Вывод счетчика
             */
            main.update_score(this.getScore());
            if (this.getScore() == 2 || this.getScore() == 3 || this.getScore() == 4)
                this.setLevel(this.getLevel() + 1);
            getTimer().setDelay(a-=20);
            main.update_level(this.getLevel());

            newApple();
            newObstacle(round += 6);
        } else
            getSnake().removeLast();

        /* Врезался в препятствие */

        if (obstacles.contains(newHead)) {
            game = false;
        }
    }

    void setDirection(Direction direction) {
        /*
         * Запрещает изменение направления, если игра закончена
         */
        if (!game) {
            return;
        }
        /*
         * Запрещает изменение направления на противоположное
         */
        if (this.direction == Direction.UP && direction == Direction.DOWN
                || this.direction == Direction.DOWN && direction == Direction.UP
                || this.direction == Direction.LEFT && direction == Direction.RIGHT
                || this.direction == Direction.RIGHT && direction == Direction.LEFT) {
            return;
        }
        this.direction = direction;
    }

    @Override
    /*
     * Рисования графики внутри компонента
     */
    protected void paintComponent(Graphics g) {
        /*
         * Настройка графического контекста
         */
        super.paintComponent(g);

        /*
         * Конец игры
         */
        if (!this.game) {
            main.game_over_start();
            return;

        }

        /*
         * Змея
         */
        g.setColor(changeColor ? Color.green : Color.red);
        for (Point point : getSnake()) {
            g.fillOval(point.x * SNAKE_SIZE, point.y * SNAKE_SIZE, SNAKE_SIZE, SNAKE_SIZE); // отрисовка

        }

        /*
         * Яблоко
         */
        g.setColor(red_color);
        for (Point point : apples) {
            g.fillOval(point.x * APPLE_SIZE, point.y * APPLE_SIZE, APPLE_SIZE, APPLE_SIZE);
        }

        /*
         * Препятствие
         */
        g.setColor(green_color);
        for (Point point : obstacles) {
            g.fillOval(point.x * OBSTACLE_SIZE, point.y * OBSTACLE_SIZE, OBSTACLE_SIZE, OBSTACLE_SIZE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake_move();
        repaint();
    }


    /** Сеттер для функции */
    public void setChangeColor(boolean changeColor) {
        this.changeColor = changeColor;
        repaint();
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }


    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }


    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }


    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * @return the timer
     */
    public Timer getTimer() {
        return timer;
    }


    /**
     * @param timer the timer to set
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }


    /**
     * @return the snake
     */
    public List<Point> getSnake() {
        return snake;
    }


    /**
     * @param snake the snake to set
     */
    public void setSnake(List<Point> snake) {
        this.snake = snake;
    }

}