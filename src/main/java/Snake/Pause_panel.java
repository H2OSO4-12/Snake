package Snake;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Класс Pause_panel со свойствами панель паузы
 *
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Pause_panel extends JPanel {

    /**
     * Конструктор Pause_panel
     */
    Pause_panel(Main main) {
        this.setBounds(0, 0, Main.WIDTH, Main.HEIGTH);
        this.setLayout(null);
        this.setFocusable(true);
        Border no_border = BorderFactory.createEmptyBorder();


        /*Кнопка возврата в меню */

        JButton go_home = new JButton();
        go_home.setName("go_home");
        go_home.setOpaque(false);
        go_home.setContentAreaFilled(false);
        go_home.setBorderPainted(false);
        go_home.setBounds((getWidth()) / 2, (getHeight() + 10) / 6, 390, 120);
        go_home.setRolloverEnabled(false); // отключение эффекта подсветки при наведении
        go_home.setBorder(no_border);
        go_home.setIcon(Resources.ICON_EXIT);

        /*
         * Кнопка перезагрузки игры
         */
        JButton restart = new JButton();
        restart.setOpaque(false);
        restart.setContentAreaFilled(false);
        restart.setBorderPainted(false);
        restart.setBounds((getWidth() - 900) / 9, (getHeight() + 10) / 6, 390, 120);
        restart.setRolloverEnabled(false);
        restart.setBorder(no_border);
        restart.setIcon(Resources.ICON_PLAY);
        add(restart);
        add(go_home);
        go_home.addActionListener(_ -> main.start_home());
        go_home.addMouseListener(new MouseListener() {
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
        restart.addActionListener(_ -> {

            main.start_game();

            main.pause_exit();

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
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String message = "Пауза";
        g.drawImage(Resources.BACKGROUND.getImage(), 0, 0, getWidth(), getHeight(), null);
        g.setFont(new Font("Minicomputer Light 300", Font.BOLD, 30));
        int message_wight = g.getFontMetrics().stringWidth(message); // ширина текста
        g.drawString(message, (getWidth() - message_wight) / 2, getHeight() / 6); // посередине
    }

}