package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CipherBreakerTest {

  @Test
  void findsOffset() {
    CipherBreaker breaker = new CipherBreaker();
    CaesarCipher cipher = new CaesarCipher(breaker);
    int offset = breaker.probableOffset("ro dyvn wo s myevn xofob dokmr k vvkwk dy nbsfo", cipher);
    assertThat(offset).isEqualTo(10);

    assertThat(cipher.decipher("ro dyvn wo s myevn xofob dokmr k vvkwk dy nbsfo", offset))
        .isEqualTo("he told me i could never teach a llama to drive");
  }
}
