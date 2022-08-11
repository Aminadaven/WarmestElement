package github.assignments;

import java.util.HashMap;
import java.util.LinkedList;

public class WarmestElement<K, V> {

  private final HashMap<K, V> elementsMap = new HashMap<>();
  private final LinkedList<K> warm = new LinkedList<>();

  private void warmElement(K key) {
    // O(n)
    warm.remove(key);
    // O(1)
    warm.addFirst(key);
  }

  void put(K key, V value) {
    warmElement(key);
    elementsMap.put(key, value);
  }


  V get(K key) {
    V value = elementsMap.get(key);
    if (value != null) {
      warmElement(key);
    }
    return value;
  }


  V remove(K key) {
    warm.remove(key);
    return elementsMap.remove(key);
  }

  // O(1)
  V getWarmest() {
    return elementsMap.get(warm.getFirst());
  }
}
