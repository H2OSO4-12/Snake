package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * Класс Help со свойствами панель с информацией правил игры
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class Help extends JPanel {
    final Main main;
    final JButton hel;
    final JTextArea area1;


    /**
     * Конструктор <a> Help
     *
     *
     */

    Help(Main main) {
        this.main = main;
        setBounds(0, 0, Main.WIDTH, Main.HEIGTH);
        setFocusable(true);
        Border no_border = BorderFactory.createEmptyBorder();
        hel = new JButton();
        hel.setName("help");
        hel.setOpaque(false);
        hel.setContentAreaFilled(false);
        hel.setBorderPainted(false);
        hel.setBounds((getWidth()) / 2, (getHeight() + 10) / 6, 390, 120);
        hel.setRolloverEnabled(false);
        hel.setBorder(no_border);
        hel.setIcon(Resources.ICON_EXIT);
        add(hel);

        hel.addActionListener(_ -> main.helper_exit());
        area1 = new JTextArea(50, 50);
        area1.setText("                              Правила игры для пользователя: "
                + "                                                        "
                + " "
                + "Игра начинается кнопкой 'Старт'."
                + " Далее управление осуществляется клавишами 'влево', 'вправо', 'вверх'"
                + " и 'вниз'; пробел - это пауза.Задача змейки - ловить 'мышек', не вы"
                + " ходя за рамки поля .У вас есть три жизни; по окончании их игра "
                + " закончится.  ");
        // Шрифт и табуляция
        area1.setFont(new Font("Minicomputer Light 300", Font.BOLD, 14));
        area1.setTabSize(10);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area1.setBackground(new Color(232,253,148));
        this.add(new JScrollPane(area1));
        this.add(area1);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(232,253,148));
    }


}

