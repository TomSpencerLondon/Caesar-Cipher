package com.tomspencerlondon;

public class CaesarCipher {
  String cipher(String message, int offset) {
    StringBuilder result = new StringBuilder();

    for (char character : message.toCharArray()) {
      if (character != ' ') {
        int originalAlphabetPosition = character - 'a';
        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
        char newCharacter = (char) ('a' + newAlphabetPosition);
        result.append(newCharacter);
      } else {
        result.append(character);
      }
    }

    return result.toString();
  }

  String decipher(String message, int offset) {
    return cipher(message, 26 - (offset % 26));
  }
}
