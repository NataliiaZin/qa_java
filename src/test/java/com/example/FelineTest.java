package com.example;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тесты для Feline")
class FelineTest {

  private Feline feline;

  @BeforeEach
  void setUp() {
    feline = new Feline();
  }

  @Test
  @DisplayName("getFood должен возвращать хищную пищу")
  void getFoodPredatorTest() throws Exception {
    List<String> expected = List.of("Животные", "Птицы", "Рыба");
    List<String> actual = feline.getFood("Хищник");
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getFood должен возвращать растительную пищу")
  void getFoodHerbivorousTest() throws Exception {
    List<String> expected = List.of("Трава", "Различные растения");
    List<String> actual = feline.getFood("Травоядное");
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getFood должен выбрасывать исключение при неизвестном типе")
  void getFoodUnsupportedTest() {
    Exception exception = assertThrows(Exception.class, () -> feline.getFood("unsupported"));
    String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  @DisplayName("eatMeat должен возвращать хищную пищу")
  void eatMeatTest() throws Exception {
    List<String> expected = List.of("Животные", "Птицы", "Рыба");
    List<String> actual = feline.eatMeat();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("getFamily должен возвращать 'Кошачьи'")
  void getFamilyTest() {
    assertEquals("Кошачьи", feline.getFamily());
  }

  @Test
  @DisplayName("getKittens без параметра должен возвращать 1")
  void getKittensDefaultTest() {
    assertEquals(1, feline.getKittens());
  }

  @ParameterizedTest(name = "getKittens({0}) должен вернуть {0}")
  @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
  @DisplayName("getKittens с параметром должен возвращать переданное значение")
  void GetKittensCustomTest(int kittensCount) {
    assertEquals(kittensCount, feline.getKittens(kittensCount));
  }
}