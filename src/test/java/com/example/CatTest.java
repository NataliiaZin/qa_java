package com.example;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@DisplayName("Тесты класса Cat")
class CatTest {

  private Cat cat;
  private Feline mockFeline;

  @BeforeEach
  void setUp() {
    mockFeline = mock(Feline.class);
    cat = new Cat(mockFeline);
  }

  @Test
  @DisplayName("Метод getSound должен возвращать 'Мяу'")
  void getSoundShouldReturnMeowTest() {
    assertEquals("Мяу", cat.getSound());
  }

  @Test
  @DisplayName("Метод getFood должен возвращать список еды от Feline")
  void getFoodShouldReturnFelineFoodTest() throws Exception {
    List<String> expectedFood = List.of("Мясо", "Курица");
    when(mockFeline.eatMeat()).thenReturn(expectedFood);

    List<String> actualFood = cat.getFood();

    assertEquals(expectedFood, actualFood);
    verify(mockFeline).eatMeat();
    verifyNoMoreInteractions(mockFeline);
  }
}