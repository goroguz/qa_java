package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class LionTest {

    @ParameterizedTest
    @CsvSource({
        "Самец, true",
        "Самка, false"
    })
    void lionManeTest(String sex, boolean expectedHasMane) throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    @DisplayName("Проверка ошибки при недопустимом поле")
    public void testLionInvalidSexThrows() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", new Feline()));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка рациона льва")
    public void testGetFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник"))
            .thenReturn(List.of("Животные"));
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(List.of("Животные"), lion.getFood());
    }

    @Test
    @DisplayName("Проверка количества котят у льва")
    public void testLionKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertEquals(1, lion.getKittens());
    }
}