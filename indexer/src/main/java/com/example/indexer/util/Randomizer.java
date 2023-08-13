package com.example.indexer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Randomizer {
  private static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private static List<UUID> randomArray(int max) {
    var size = getRandomNumber(0, max);
    var list = new ArrayList<UUID>();
    for (int i = 0; i < size; i++) {
      list.add(UUID.randomUUID());
    }
    return list;
  }

  public static List<UUID> randomBookMessages(int max) {
    return randomArray(max);
  }

  public static List<UUID> randomOtherMessages(int max) {
    return randomArray(max);
  }
}
