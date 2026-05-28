package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Класс About со свойствами - панель с информацией о разработчике.
 * @author Osetrov Vladimir
 * @version 1.1
 */

public class About extends JPanel {
    JButton help;
    /**
     * Конструктор <a> About
     */

    About(Main main){
        this.setBounds(0, 0, Main.WIDTH, Main.HEIGTH);
        this.setLayout(null);
        this.setFocusable(true);
        Border no_border = BorderFactory.createEmptyBorder();
        help = new JButton();
        help.setName("about");
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setBorderPainted(false);
        help.setBounds((getWidth()) / 2, (getHeight() + 10) / 6, 390, 120);
        help.setRolloverEnabled(false);
        help.setBorder(no_border);
        help.setIcon(Resources.ICON_EXIT);
        add(help);

        help.addActionListener(_ -> main.about_exit());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(232,253,148));
        String message = "О разработчике: ";
        String message_2 = "Выполнил Осетров.В.В, ученик группы з-424П8-1 2025г";
        String message_3 = "для курсовой работы по информатике.";
        g.setFont(new Font("Minicomputer Light 300", Font.BOLD, 18));

        /* Ширина текста */

        int message_wight = g.getFontMetrics().stringWidth(message);

        /* Посередине */

        g.drawString(message, (getWidth() - message_wight) / 2, (getHeight() - 450) / 7);
        g.drawString(message_2, 30, 90);
        g.drawString(message_3, 30, 130);
    }

}