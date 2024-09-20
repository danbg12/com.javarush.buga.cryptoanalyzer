package crypto_analyze;

import java.io.*;
import java.nio.file.Path;

public class CaesarCipher {

    private static char[] charArray; // Array with symbols from the file
    static Path outPutFilePath;      // Path for output file
    static char[] ACTUAL_LANGUAGE;   // Language chosen by user

    // Write all symbols from entered file into a char[] array
    static void fileFormatting(Path filePath) {

        // Language initialization
        if (CryptoAnalyzeValidation.FILE_TEXT_LANGUAGE.equals("Eng")) {
            ACTUAL_LANGUAGE = Alphabet.ALPHABET_ENG;
        } else if (CryptoAnalyzeValidation.FILE_TEXT_LANGUAGE.equals("Rus")) {
            ACTUAL_LANGUAGE =Alphabet.ALPHABET_RUS;
        }
        outPutFilePath = filePath;

        StringBuilder builder = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath.toFile()))) {  // Read all symbols from the file

            String line;
            while ((line = buffer.readLine()) != null) {    // All counted symbols write in char array
                builder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        charArray = builder.toString().toCharArray();

        if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Hack")) {
            BrutForce.CodeBreaking(charArray);
        } else {
            textCipher(charArray);
        }
    }

    // Method decrypt or encrypt the text from char array , depends on ACTION_WITH_FILE value .
    static void textCipher(char[] charArray) {

        char[] resultText = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < ACTUAL_LANGUAGE.length; j++) {
                if (charArray[i] == ACTUAL_LANGUAGE[j]) {
                    // Text encryption
                    if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Encrypt")) {
                        if (j + CryptoAnalyzeValidation.SHIFT_KEY <= (ACTUAL_LANGUAGE.length - 1)) {
                            resultText[i] = ACTUAL_LANGUAGE[j + CryptoAnalyzeValidation.SHIFT_KEY];
                        } else {
                            resultText[i] = ACTUAL_LANGUAGE[Math.abs((j + CryptoAnalyzeValidation.SHIFT_KEY) - (ACTUAL_LANGUAGE.length))];
                        }
                    // File decryption
                    } else if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Decrypt")) {
                        if (j - CryptoAnalyzeValidation.SHIFT_KEY >= 0) {
                            resultText[i] = ACTUAL_LANGUAGE[j - CryptoAnalyzeValidation.SHIFT_KEY];
                        } else {
                            resultText[i] = ACTUAL_LANGUAGE[ACTUAL_LANGUAGE.length - Math.abs(j - CryptoAnalyzeValidation.SHIFT_KEY)];
                        }
                    }
                } else {
                    resultText[i] = charArray[i];
                }
            }
        }
        resultFileOutput(resultText);
    }

    // All symbols from char array with replaced symbols we read with BufferWriter and write in the native file .
    static void resultFileOutput(char[] resultText) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFilePath.toFile()))) {
            writer.write(resultText, 0 , resultText.length );
        } catch (IOException e) {
            throw new RuntimeException();
        }

        // Show to user operation result
        if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Encrypt")) {
            System.out.println(TextsForValidation.ENCRYPTED_FILE_OUTPUT + outPutFilePath.toString());
            System.out.println();
        } else if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Decrypt")) {
            System.out.println(TextsForValidation.DECRYPTED_FILE_OUTPUT + outPutFilePath.toString());
            System.out.println();
        } else if (CryptoAnalyzeValidation.ACTION_WITH_FILE.equals("Hack")) {
            System.out.println(TextsForValidation.DECRYPTED_FILE_OUTPUT + outPutFilePath.toString());
            System.out.println();
        }
    }
}