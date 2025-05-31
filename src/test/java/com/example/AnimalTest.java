package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Nested;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    Animal animal = new Animal();

    @Nested
    @DisplayName("Tests for getFood")
    class GetFoodTests {

        @ParameterizedTest
        @CsvSource({
            "Травоядное, Трава",
            "Хищник, Животные"
        })
        @DisplayName("Проверка, что список еды не null")
        void testGetFoodNotNull(String kind) throws Exception {
            List<String> food = animal.getFood(kind);
            assertNotNull(food);
        }

        @ParameterizedTest
        @CsvSource({
            "Травоядное, Трава",
            "Хищник, Животные"
        })
        @DisplayName("Проверка, что список еды не пустой")
        void testGetFoodNotEmpty(String kind) throws Exception {
            List<String> food = animal.getFood(kind);
            assertFalse(food.isEmpty());
        }

        @ParameterizedTest
        @CsvSource({
            "Травоядное, Трава",
            "Хищник, Животные"
        })
        @DisplayName("Проверка, что первый элемент списка еды корректный")
        void testGetFoodFirstItem(String kind, String expectedFirstItem) throws Exception {
            List<String> food = animal.getFood(kind);
            assertEquals(expectedFirstItem, food.get(0));
        }

        @Test
        @DisplayName("Проверка ошибки при неизвестном виде животного")
        void testGetFoodInvalidType() {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood("Насекомое"));
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода getFamily")
    void testGetFamily() {
        String family = animal.getFamily();
        assertTrue(family.contains("семейств"));
    }
}
