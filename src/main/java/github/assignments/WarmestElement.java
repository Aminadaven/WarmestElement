package github.assignments;

import org.apache.commons.collections4.map.LinkedMap;

public class WarmestElement<K, V> {

  private final LinkedMap<K, V> elementsMap = new LinkedMap<>();

  private void warmElement(K key) {
    // O(1)
    V value = elementsMap.remove(key);
    // O(1)
    elementsMap.put(key, value);
  }

  // O(1)
  void put(K key, V value) {
    warmElement(key);
    elementsMap.put(key, value);
  }

  // O(1)
  V get(K key) {
    V value = elementsMap.get(key);
    if (value != null) {
      warmElement(key);
    }
    return value;
  }

  // O(1)
  V remove(K key) {
    return elementsMap.remove(key);
  }

  // O(1)
  V getWarmest() {
    return elementsMap.get(elementsMap.lastKey());
  }
}
