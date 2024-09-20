package crypto_analyze;

public class TextsForValidation {

    // Russian texts

    public static final String RUSSIAN_LANGUAGE_INPUT_REQUEST = "Введите 2 для работы с текстом на Русском языке !";

    public static final String ENGLISH_LANGUAGE_INPUT_REQUEST = "Введите 1 для работы с текстом на Англииском языке ! ";

    public static final String FILE_TEXT_LINK_INPUT_REQUEST = "Пожалуиста введите ссылку на существующии текстовыи фаил:";

    public  static final String FINISH_PROGRAM_INPUT_REQUEST = "Введите 0 для завершения программы !";

    public static final String PROGRAM_IS_FINISHED_OUTPUT = "Программа завершена !";

    public static final String EMPTY_INPUT = "Вы ничего не ввели !";

    public static final String WRONG_FILE_TYPE = "Вы ввели сылку к фаилу другого типа !";

    public static final String EXISTENT_FILE = "Вы ввели сылку к несуществуещему фаилу !";

    public static final String EMPTY_FILE = "Вы ввели сылку к пустому фаилу !";

    public static final String FILE_ENCRYPTION_REQUEST = "Введите 1 если хотите зашифровать фаил !";

    public static final String FILE_DECRYPTION_REQUEST = "Введите 2 если хотите разшифровать фаил !";

    public static final String BRUT_FORCE_REQUEST = "Введите 3 для взлома шифра методом Brute Force !";

    public static final String INVALID_SYMBOL_INPUT = "Вы ввели невалидный символ !";

    public static final String KEY_INPUT_REQUEST = "Введите номер ключа начиная с: 1 до " + (Alphabet.ALPHABET_RUS.length - 1);

    public static final String OUT_OF_BOUNDS_KEY_INPUT = "Вы ввели ключь вне указанного диапазона !";

    public static final String ENCRYPTED_FILE_OUTPUT = "Шифрование текста прошла успешно ! Проверьте фаил: ";

    public static final String DECRYPTED_FILE_OUTPUT = "Разшифрование текста прошла успешно ! Проверьте фаил: ";

    public static final String SUCCESSFUL_BRUT_FORCE = "Введите 1 если текстовыи фаил был успешно разшифрован !";

    public static final String FAILED_BRUT_FORCE = "Введите 2 если для перебора текста следуищим ключом если текстовыи фаил не был успешно разшифрован !";

    public static final String DECRYPTION_RESULT = "Результат разшифровки ключем: ";

}
