package crypto_analyze;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class CryptoAnalyzeValidation {

    static String ACTION_WITH_FILE;
    static Integer SHIFT_KEY;
    static String FILE_TEXT_LANGUAGE;

    public static void main(String[] args) {

        while (true) {  //program stop only if user enter 0
            languageInput();
            actionWithFileInput();

            if (ACTION_WITH_FILE.equals("Hack")) {
                CaesarCipher.fileFormatting(fileInputValidation());  // If ACTION_WITH_FILE value is Hack run
            } else {
                keyInput();
                CaesarCipher.fileFormatting(fileInputValidation());  // Run methods for encryption and decryption
            }
        }
    }

    // C:\Users\User\Desktop\Cipher_Result_File.txt
    // C:\Users\User\Desktop\Exemplu3.txt
    // Ask user to enter a path to the text file in console
    // After user enter the path, check the path and the file
    // After all checks this method return File type var with path
    private static Path fileInputValidation() {

        Scanner scanner = new Scanner(System.in);
        File file;

        while (true) {

            System.out.println(TextsForValidation.FILE_TEXT_LINK_INPUT_REQUEST + "\n" + TextsForValidation.FINISH_PROGRAM_INPUT_REQUEST);
            String pathFile = scanner.nextLine();

            if (pathFile.equals("0")) {                                                 // Finish the program if user entered 0
                System.out.println(TextsForValidation.PROGRAM_IS_FINISHED_OUTPUT);
                System.exit(0);
            } else if (pathFile.trim().isEmpty()) {                                     // Delete backspaces from entered data and
                System.out.println(TextsForValidation.EMPTY_INPUT);                     // Check if scanner is empty
                continue;
            }

            file = new File(pathFile);
            if (!pathFile.endsWith(".txt")) {
                System.out.println(TextsForValidation.WRONG_FILE_TYPE);                // Check if user entered right file format
                continue;
            } else if (!file.exists()) {
                System.out.println(TextsForValidation.EXISTENT_FILE);                  // Check if user entered existent file
                continue;
            } else if (file.length() == 0) {
                System.out.println(TextsForValidation.EMPTY_FILE);                     // Check if user entered file is not empty
                continue;
            } else {
                break;
            }
        }

        Path filePath = Path.of(file.toString());
        return filePath;
    }

    // If user enter 1 method set var ACTION_WITH_FILE Encrypt
    // If user enter 2 method set var ACTION_WITH_FILE Decrypt
    // If user enter 3 method set var ACTION_WITH_FILE Hack
    // If user enter 4 method set program is finished
    static void actionWithFileInput() {

        Scanner scanner = new Scanner(System.in);
        int symbolFromConsole;

        while (true) {

            System.out.println(TextsForValidation.FILE_ENCRYPTION_REQUEST + "\n" + TextsForValidation.FILE_DECRYPTION_REQUEST + "\n" +
                    TextsForValidation.BRUT_FORCE_REQUEST + "\n" + TextsForValidation.FINISH_PROGRAM_INPUT_REQUEST);

            String input = scanner.nextLine();

            switch (input) {
                case "0": System.out.println(TextsForValidation.PROGRAM_IS_FINISHED_OUTPUT);
                    System.exit(0);
                case "1": ACTION_WITH_FILE = "Encrypt";
                    break;
                case "2":  ACTION_WITH_FILE = "Decrypt";
                    break;
                case "3": ACTION_WITH_FILE = "Hack";
                    break;
                default:  System.out.println(TextsForValidation.INVALID_SYMBOL_INPUT);
                    continue;
            }
            break;

        }
    }

    // This method ask user to enter the key for encrypting or decrypting in indicated range
    // Method make all checks with entered characters
    // If after all checks entered key is in the right range , method initialize var SHIFT_KEY
    private static void keyInput() {

        Scanner scanner = new Scanner(System.in);
        Integer key;

        while (true) {
            System.out.println(TextsForValidation.KEY_INPUT_REQUEST + "\n" + TextsForValidation.FINISH_PROGRAM_INPUT_REQUEST);

            String input = scanner.nextLine();
            if (input.equals("0")) {                            // Finish the program if user entered exit
                System.out.println(TextsForValidation.PROGRAM_IS_FINISHED_OUTPUT);
                System.exit(0);
            } else if (input.trim().isEmpty()) {                                      // Delete backspaces from entered data
                System.out.println(TextsForValidation.EMPTY_INPUT);                   // Verify if scanner is empty
                continue;
            }

            try {
                key = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(TextsForValidation.INVALID_SYMBOL_INPUT);         // Verify if user enter right number
                continue;
            }

            if (key >= 1 && key <= (Alphabet.ALPHABET_RUS.length - 1)) {
                SHIFT_KEY = key;                                                      // If entered by user number is into the indicated range
                break;                                                                // we set result key to var SHIFT_KEY and break the loop
            } else {
                System.out.println(TextsForValidation.OUT_OF_BOUNDS_KEY_INPUT);
            }
        }
    }

    // User chooses from two languages in which language is his text for the next operations
    static void languageInput() {
        Scanner scanner = new Scanner(System.in);
        int symbolFromConsole;

        while(true) {
            System.out.println(TextsForValidation.ENGLISH_LANGUAGE_INPUT_REQUEST + "\n" + TextsForValidation.RUSSIAN_LANGUAGE_INPUT_REQUEST +
                    "\n" + TextsForValidation.FINISH_PROGRAM_INPUT_REQUEST);

            String input = scanner.nextLine();

            switch (input) {
                case "0": System.out.println(TextsForValidation.PROGRAM_IS_FINISHED_OUTPUT);
                          System.exit(0);
                case "1": FILE_TEXT_LANGUAGE = "Eng";
                           break;
                case "2": FILE_TEXT_LANGUAGE = "Rus";
                           break;
                default:  System.out.println(TextsForValidation.INVALID_SYMBOL_INPUT);
                          continue;
            }
            break;
        }
    }
}


