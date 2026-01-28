package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  // You can put your JUnit tests here
  // Feel free to create other files, as needed, to organize your tests
  @Test
  public void testDependentDeductionCalculation(Object PayrollCalculator){
    assertEquals(35, PayrollCalculator.perDependant(1), 0.001);
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }
}
