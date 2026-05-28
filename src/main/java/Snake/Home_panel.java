package Snake;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * Класс Home_panel со свойствами панель для настроек игры и ее начало
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Home_panel extends JPanel {
    JButton play;
    JButton exit;
    JLabel BGColor;
    JLabel SnColor;
    JLabel gameLevel;
    JLabel LenSn;
    JRadioButton checkbox_BColor_yell;
    JRadioButton checkbox_BColor_Black;
    JRadioButton SnGreen;
    JRadioButton SnRed;
    JRadioButton check_level_1;
    JRadioButton check_level_2;
    JRadioButton check_level_3;
    JRadioButton len_3;
    JRadioButton len_6;
    JRadioButton len_9;
    ButtonGroup g1;
    ButtonGroup g2;
    ButtonGroup g3;
    ButtonGroup g4;

    /**
     * Конструктор <a> Home_panel
     */

    Home_panel() {
        this.setBounds(0, 0, Main.WIDTH, Main.HEIGTH);

        /* Отключаем менеджер компоновки */

        this.setLayout(null);
        this.setFocusable(true);
        play = new JButton();
        play.setName("play");
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setIcon(Resources.ICON_PLAY);
        play.setBounds((getWidth() - 900) / 9, (getHeight() + 10) / 6, 390, 120);

        /* Отключение эффекта подсветки при наведении */

        play.setRolloverEnabled(false);

        /* Убираем синие границы картинки */

        Border no_border = BorderFactory.createEmptyBorder();
        play.setBorder(no_border);
        add(play);
        exit = new JButton();
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setBounds((getWidth()) / 2, (getHeight() + 10) / 6, 390, 120);
        exit.setRolloverEnabled(false);
        exit.setBorder(no_border);
        exit.setIcon(Resources.ICON_EXIT);
        add(exit);
        BGColor = new JLabel("Цвет фона: ");
        BGColor.setBounds((getWidth() - 200) / 9, (getHeight() + 700) / 5, 90, 50);
        BGColor.setBorder(no_border);
        add(BGColor);
        checkbox_BColor_Black = new JRadioButton("Черный");
        checkbox_BColor_Black.setName("Черный");
        checkbox_BColor_Black.setOpaque(false);
        checkbox_BColor_Black.setBounds((getWidth()) / 5, (getHeight() + 700) / 5, 90, 50);
        checkbox_BColor_Black.setBorder(no_border);
        checkbox_BColor_Black.setSelected(true);
        checkbox_BColor_yell = new JRadioButton("Желтый");
        checkbox_BColor_yell.setName("Желтый");
        checkbox_BColor_yell.setOpaque(false);
        checkbox_BColor_yell.setBounds((getWidth()) / 5, (getHeight() + 880) / 5, 90, 50);
        checkbox_BColor_yell.setBorder(no_border);
        SnColor = new JLabel("Цвет змейки: ");
        SnColor.setBounds((getWidth() + 230) / 2, (getHeight() + 700) / 5, 90, 50);
        SnColor.setBorder(no_border);
        add(SnColor);
        SnGreen = new JRadioButton("Зеленый");
        SnGreen.setName("Зеленый");
        SnGreen.setOpaque(false);
        SnGreen.setBounds((getWidth() + 400) / 2, (getHeight() + 700) / 5, 90, 50);
        SnGreen.setBorder(no_border);
        SnGreen.setSelected(true);
        SnRed = new JRadioButton("Красный");
        SnRed.setName("Красный");
        SnRed.setOpaque(false);
        SnRed.setBounds((getWidth() + 400) / 2, (getHeight() + 880) / 5, 90, 50);
        SnRed.setBorder(no_border);
        gameLevel = new JLabel("Уровень сложности: ");
        gameLevel.setBounds((getWidth() - 200) / 8, (getHeight() + 700) / 3, 140, 50);
        gameLevel.setBorder(no_border);
        add(gameLevel);
        check_level_1 = new JRadioButton("Уровень 1");
        check_level_1.setName("Уровень 1");
        check_level_1.setOpaque(false);
        check_level_1.setBounds((getWidth() - 100) / 3, (getHeight() + 235) / 2, 90, 50);
        check_level_1.setBorder(no_border);
        check_level_1.setSelected(true);
        check_level_2 = new JRadioButton("Уровень 2");
        check_level_2.setName("Уровень 2");
        check_level_2.setOpaque(false);
        check_level_2.setBounds((getWidth() - 100) / 3, (getHeight() + 285) / 2, 90, 50);
        check_level_2.setBorder(no_border);
        check_level_3 = new JRadioButton("Уровень 3");
        check_level_3.setName("Уровень 3");
        check_level_3.setOpaque(false);
        check_level_3.setBounds((getWidth() - 100) / 3, (getHeight() + 330) / 2, 90, 50);
        check_level_3.setBorder(no_border);
        LenSn = new JLabel("Длина змейки: ");
        LenSn.setBounds((getWidth() + 300) / 2, (getHeight() + 700) / 3, 140, 50);
        LenSn.setBorder(no_border);
        add(LenSn);
        len_3 = new JRadioButton("Три");
        len_3.setName("Три");
        len_3.setOpaque(false);
        len_3.setBounds((getWidth() + 500) / 2, (getHeight() + 235) / 2, 90, 50);
        len_3.setBorder(no_border);
        len_3.setSelected(true);
        len_6 = new JRadioButton("Шесть");
        len_6.setName("Шесть");
        len_6.setOpaque(false);
        len_6.setBounds((getWidth() + 500) / 2, (getHeight() + 285) / 2, 90, 50);
        len_6.setBorder(no_border);
        len_9 = new JRadioButton("Девять");
        len_9.setName("Девять");
        len_9.setOpaque(false);
        len_9.setBounds((getWidth() + 500) / 2, (getHeight() + 330) / 2, 90, 50);
        len_9.setBorder(no_border);
        g1 = new ButtonGroup();
        g2 = new ButtonGroup();
        g3 = new ButtonGroup();
        g4 = new ButtonGroup();
        g3.add(SnGreen);
        g3.add(SnRed);
        add(SnGreen);
        add(SnRed);
        add(len_3);
        add(len_6);
        add(len_9);
        g4.add(len_3);
        g4.add(len_6);
        g4.add(len_9);
        add(checkbox_BColor_Black);
        add(checkbox_BColor_yell);
        g2.add(checkbox_BColor_Black);
        g2.add(checkbox_BColor_yell);
        g1.add(check_level_1);
        g1.add(check_level_2);
        g1.add(check_level_3);
        add(check_level_1);
        add(check_level_2);
        add(check_level_3);
        play.addMouseListener(new MouseListener() {
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
                play.setIcon(Resources.ICON_PLAY);
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
                exit.setIcon(Resources.ICON_EXIT);
            }
        });

    }

    public JButton getPlayButton() {
        return play;
    }

    public JRadioButton getCheck_level_1() {
        return check_level_1;
    }

    public JRadioButton getCheck_level_2() {
        return check_level_2;
    }

    public JRadioButton getCheck_level_3() {
        return check_level_3;
    }

    public JRadioButton getLen_3() {
        return len_3;
    }

    public JRadioButton getLen_6() {
        return len_6;
    }

    public JRadioButton getLen_9() {
        return len_9;
    }

    /**
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Resources.BACKGROUND.getImage(), 0, 0, getWidth(), getHeight(), null);
        String message = "Добро пожаловать в игру змейка!";
        g.setFont(new Font("Minicomputer Light 300", Font.BOLD, 28));
        int message_wight = g.getFontMetrics().stringWidth(message); // ширина текста
        g.drawString(message, (getWidth() - message_wight) / 2, (getHeight() - 100) / 7); // Посередине

    }

}