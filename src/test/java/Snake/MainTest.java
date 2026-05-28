package Snake;
import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Класс для тестирования объекта класса Main используется библиотека Fest JUnit, JUnit jupiter */

class MainTest {
    private static FrameFixture frame;
    private Main main;

    @BeforeAll //До выполнения всех тестов
    static void setUp() throws IOException {
        frame = new FrameFixture(new Main()); //Создается объект для автоматического тестирования Объекта Main
        frame.show();
    }

    @Test //Тест GUI
    void main_test(){
        frame.menuItemWithPath("Справка").click();
        frame.button("help").click();
        frame.menuItemWithPath("О разработчике").click();
        frame.button("about").click();
        frame.radioButton("Черный").click();
        frame.radioButton("Желтый").click();
        frame.radioButton("Зеленый").click();
        frame.radioButton("Красный").click();
        frame.radioButton("Три").click();
        frame.radioButton("Шесть").click();
        frame.radioButton("Девять").click();
        frame.radioButton("Уровень 1").click();
        frame.radioButton("Уровень 2").click();
        frame.radioButton("Уровень 3").click();
        frame.button("play").click();
        frame.menuItemWithPath("Выход").click();
    }

    @Test
    void update_score() throws IOException {
        main = new Main();
        assertEquals(6, main.update_score(6));
    }

    @Test
    void update_level() throws IOException {
        main = new Main();
        assertEquals(6, main.update_level(6));
    }

    @AfterAll //После выполнения тестов
    static void tearDown() {
        frame.cleanUp(); //Уничтожается объект класса Main
    }

}