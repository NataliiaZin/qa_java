package com.example;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тесты класса Lion")
class LionTest {

  @ParameterizedTest(name = "Пол: {0} → грива: {1}")
  @CsvSource({
      "Самец, true",
      "Самка, false"
  })
  @DisplayName("Проверка наличия гривы в зависимости от пола")
  void lionManePresenceTest(String sex, boolean expectedHasMane) throws Exception {
    Lion lion = new Lion(sex, new Feline());
    assertEquals(expectedHasMane, lion.doesHaveMane());
  }

  @Test
  @DisplayName("Недопустимый пол должен выбрасывать исключение")
  void lionInvalidSexShouldThrowExceptionTest() {
    Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", new Feline()));
    String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
    assertEquals(expectedExceptionMessage, exception.getMessage());
  }

  @ParameterizedTest(name = "Пол: {0}")
  @ValueSource(strings = {"Самец", "Самка"})
  @DisplayName("getKittens должен возвращать значение от Feline для разных полов")
  void getKittensShouldReturnFelineValueTest(String sex) throws Exception {
    int kittensCount = new Random().nextInt();
    Feline mockFeline = mock(Feline.class);
    when(mockFeline.getKittens()).thenReturn(kittensCount);
    Lion lion = new Lion(sex, mockFeline);
    int actualKittens = lion.getKittens();
    assertEquals(kittensCount, actualKittens);
  }

  @ParameterizedTest(name = "Проверка getFood для пола: {0}")
  @ValueSource(strings = {"Самец", "Самка"})
  @DisplayName("getFood должен возвращать список еды от Feline")
  void getFoodShouldReturnFelineFoodTest(String sex) throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Lion lion = new Lion(sex, new Feline());
    List<String> actualFood = lion.getFood();
    assertEquals(expectedFood, actualFood);
  }
}