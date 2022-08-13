#### Final project for the Java Syntax module. Let's write a cryptanalyzer
Your task is to write a program that works with Caesar ciphers.

Let's say that the substitution alphabet consists of all the letters of the English alphabet, periods, commas, double quotation marks, colons, hyphen, exclamation points, question marks, and spaces. If you encounter characters that are not part of our substitution alphabet, then just skip them.

#### Main requirements
The program should have 2 modes:

Encryption/decryption. The program must encrypt and decrypt text using a given cryptographic key.

The program should receive a path to a text file containing source text and create a file containing the corresponding ciphertext.

Cryptanalysis. In this mode, the program must crack the ciphertext contained in an input text file. The user should be able to choose one of two cryptanalysis methods.

Details about the choice of cryptanalysis methods
If the user selects brute force, then the program must independently enumerate the possible keys, select the correct key, and decrypt the text.

Think about what criteria the program should use to successfully identify the correct key.

You may need to pay attention to the spaces between words or the correct use of punctuation marks.

If the user selects statistical analysis mode, then prompt the user to load an additional text file in plaintext, preferably by the same author and in the same style.

Based on the contents of the second file, the program should compile statistics on the occurrence of characters and then try to use these statistics to perform cryptanalysis of the ciphertext.

Additional requirements
Make dialog boxes for interaction with the user at your discretion. If desired, you can use the Swing and JavaFX graphic frameworks.

Upload your finished solution to a public Git repository.