package com.tomspencerlondon;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CipherBreaker {
  private final Logger log = LoggerFactory.getLogger(CaesarCipher.class);

  private static final char LETTER_A = 'a';
  private static final char LETTER_Z = 'z';
  private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;
  private static final double[] ENGLISH_LETTERS_PROBABILITIES = {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074, 0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003, 0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};

  public int probableOffset(String message, CaesarCipher cipher) {
    return probableOffset(chiSquares(message, cipher));
  }

  private double[] chiSquares(String message, CaesarCipher cipher) {
    double[] expectedLetterFrequencies = expectedLetterFrequencies(message.length());

    double[] chiSquares = new double[ALPHABET_SIZE];

    for (int offset = 0; offset < chiSquares.length; offset++) {
      String decipheredMessage = cipher.decipher(message, offset);
      long[] letterFrequencies = letterFrequencies(decipheredMessage);
      double chiSquare = new ChiSquareTest().chiSquare(expectedLetterFrequencies, letterFrequencies);
      chiSquares[offset] = chiSquare;
    }

    return chiSquares;
  }

  private long[] letterFrequencies(String message) {
    return IntStream.rangeClosed(LETTER_A, LETTER_Z)
        .mapToLong(letter -> countLetterOccurrences((char) letter, message))
        .toArray();
  }

  private long countLetterOccurrences(char letter, String message) {
    return message.chars()
        .filter(character -> character == letter)
        .count();
  }

  private double[] expectedLetterFrequencies(int messageLength) {
    return Arrays.stream(ENGLISH_LETTERS_PROBABILITIES)
        .map(probability -> probability * messageLength)
        .toArray();
  }

  private int probableOffset(double[] chiSquares) {
    int probableOffset = 0;
    for (int offset = 0; offset < chiSquares.length; offset++) {
      log.debug(String.format("Chi-Square for offset %d: %.2f", offset, chiSquares[offset]));
      if (chiSquares[offset] < chiSquares[probableOffset]) {
        probableOffset = offset;
      }
    }

    return probableOffset;
  }
}
