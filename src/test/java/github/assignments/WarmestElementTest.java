package github.assignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarmestElementTest {

  WarmestElement<Integer, String> warmest;

  @BeforeEach
  void setUp() {
    warmest = new WarmestElement<>();
    warmest.put(1, "hello");
    warmest.put(2, "warmest");
  }

  @Test
  void put() {
    // test if put sets warmest element
    assertEquals("warmest", warmest.getWarmest());
    warmest.put(3, "aminadav");
    assertEquals("aminadav", warmest.getWarmest());
  }

  @Test
  void get() {
    String first = warmest.getWarmest();
    // test if get works
    assertEquals("hello", warmest.get(1));
    // test if get sets warmest element
    assertEquals("hello", warmest.getWarmest());
    // verify that the warmest element wasn't already "hello"
    assertNotEquals(first, warmest.getWarmest());
  }

  @Test
  void remove() {
    // test if remove works
    assertEquals("warmest", warmest.remove(2));
    // test if remove unsets warmest element
    assertEquals("hello", warmest.getWarmest());
  }
}