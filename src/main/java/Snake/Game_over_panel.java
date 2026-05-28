package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Класс Game_over_panel со свойствами панель конец игры
 *
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Game_over_panel extends JPanel {
    private final Game game;
    final JButton exit;

    /**
     * Конструктор панели конец игры
     */

    Game_over_panel(Game game, Main main) {
        this.game = game;
        setBounds(0, 0, Main.WIDTH, Main.HEIGTH);
        setLayout(null);
        setFocusable(true);

        Border no_border = BorderFactory.createEmptyBorder();
        JButton restart = new JButton();
        restart.setOpaque(false);
        restart.setContentAreaFilled(false);
        restart.setBorderPainted(false);
        restart.setBounds((getWidth() - 900) / 9, (getHeight() + 10) / 6, 390, 120);
        restart.setRolloverEnabled(false);
        restart.setBorder(no_border);
        restart.setIcon(Resources.ICON_RESTART);

        exit = new JButton();
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setBounds((getWidth()) / 2, (getHeight() + 10) / 6, 390, 120);
        exit.setRolloverEnabled(false);
        exit.setBorder(no_border);
        exit.setIcon(Resources.ICON_EXIT);

        add(exit);
        add(restart);

        restart.addActionListener(_ -> {
            main.start_game();
            main.game_over_exit();

        });
        restart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        exit.addActionListener(_ -> System.exit(0));
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Resources.BACKGROUND.getImage(), 0, 0, getWidth(), getHeight(), null);
        g.setFont(new Font("Minicomputer Light 300", Font.BOLD, 30));
        String message = "Вы проиграли!";
        String message2 = "Счет: " + game.getScore();
        String message3 = "Остаток жизней: " + Main.getLive();

        int message_wight = g.getFontMetrics().stringWidth(message); // ширина текста
        int message_wight2 = g.getFontMetrics().stringWidth(message2); // ширина текста
        int message_wight3 = g.getFontMetrics().stringWidth(message2);
        g.setColor(Color.RED);
        g.drawString(message, ((getWidth() - message_wight)) / 2, (getHeight() - 200) / 9); // посередине
        g.setColor(Color.RED);
        g.drawString(message2, (getWidth() - message_wight2) / 2, getHeight() / 7); // посередине
        g.drawString(message3, ((getWidth() - 150) - message_wight3) / 2, (getHeight() + 400) / 2); // посередине

    }
}
