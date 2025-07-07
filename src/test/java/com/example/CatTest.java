package com.example;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты класса Cat")
class CatTest {

  private Cat cat;

  @BeforeEach
  void setUp() {
    cat = new Cat(new Feline());
  }

  @Test
  @DisplayName("Метод getSound должен возвращать 'Мяу'")
  void getSoundShouldReturnMeowTest() {
    assertEquals("Мяу", cat.getSound());
  }

  @Test
  @DisplayName("Метод getFood должен возвращать список еды от Feline")
  void getFoodShouldReturnFelineFoodTest() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    List<String> actualFood = cat.getFood();
    assertEquals(expectedFood, actualFood);
  }
}