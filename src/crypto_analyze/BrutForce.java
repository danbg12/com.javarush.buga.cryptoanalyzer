package crypto_analyze;

import java.util.Arrays;
import java.util.Scanner;

public class BrutForce {

    // Method use all possible keys to decrypt the text and after every used key show the result to user.
    // If user see successful decrypted text run the DecryptedTextOutput method.
    // If user see unsuccessful decrypted file run the method one more time with the next key
    static void CodeBreaking(char[] charArray) {

        char[] decryptedText = new char[charArray.length];
        Integer keyValue = 1;

        //loop replace symbols with keyValue paths on the left
        while (true) {
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < CaesarCipher.ACTUAL_LANGUAGE.length; j++) {
                    if (charArray[i] == CaesarCipher.ACTUAL_LANGUAGE[j]) {
                        if (j - keyValue >= 0) {
                            decryptedText[i] = CaesarCipher.ACTUAL_LANGUAGE[j - keyValue];
                        } else {
                            decryptedText[i] = CaesarCipher.ACTUAL_LANGUAGE[CaesarCipher.ACTUAL_LANGUAGE.length - Math.abs(j - keyValue)];
                        }
                    }
                }
            }

            // Show to user decryption text result in array and it is successful run DecryptedTextOutput method.
            // If it is unsuccessful we run the method one more time with the next key until the user receives Arrays.toString(decryptedText));
            // successful decrypted text file .
            Scanner scanner = new Scanner(System.in);
            char[] firstTry = new char[30];

            if (decryptedText.length > firstTry.length) {
                for (int i = 0; i < firstTry.length; i++) {
                    firstTry[i] = decryptedText[i];
                }
                System.out.println(TextsForValidation.DECRYPTION_RESULT + keyValue + "\n" + Arrays.toString(firstTry));
            } else {
                System.out.println(TextsForValidation.DECRYPTION_RESULT + keyValue + "\n" + Arrays.toString(decryptedText));
            }

            System.out.println(TextsForValidation.SUCCESSFUL_BRUT_FORCE + "\n" + TextsForValidation.FAILED_BRUT_FORCE + "\n" +
                    TextsForValidation.FINISH_PROGRAM_INPUT_REQUEST);

            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println(TextsForValidation.PROGRAM_IS_FINISHED_OUTPUT);  // Finish the program if user entered exit
                System.exit(0);
            } else if (input.trim().isEmpty()) {                                    // Delete backspaces from entered data
                System.out.println(TextsForValidation.EMPTY_INPUT);                 // Verify if scanner is empty
                continue;
            }

            if (input.equals("1")) {
                CaesarCipher.resultFileOutput(decryptedText);            // If user entered 1 write data from array to output file
                break;
            } else if (input.equals("2")) {                              // If user entered 2 restart the method with next key
                keyValue++;
                continue;
            } else {
                System.out.println(TextsForValidation.INVALID_SYMBOL_INPUT);
            }
        }
    }
}



