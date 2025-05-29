package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    @Test
    @DisplayName("Проверка издаваемого звука кошкой")
    public void testCatSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("Проверка рациона кошки")
    public void testCatFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.eatMeat())
            .thenReturn(List.of("Птицы"));
        Cat cat = new Cat(mockFeline);
        assertEquals(List.of("Птицы"), cat.getFood());
    }
}
