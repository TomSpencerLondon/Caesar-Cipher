package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CaesarCipherTest {

  @Test
  void encryptsWithOffset3() {
    CaesarCipher cipher = new CaesarCipher(new CipherBreaker());

    String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 3);

    assertThat(cipheredMessage)
        .isEqualTo("kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh");
  }

  @Test
  void decipherWorks() {
    CaesarCipher cipher = new CaesarCipher(new CipherBreaker());

    String decipheredSentence = cipher.decipher("ro dyvn wo s myevn xofob dokmr k vvkwk dy nbsfo", 36);
    assertThat(decipheredSentence)
        .isEqualTo("he told me i could never teach a llama to drive");
  }
}
