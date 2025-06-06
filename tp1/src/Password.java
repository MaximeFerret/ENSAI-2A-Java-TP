import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Password {
    /**
     * Hashes the provided password using the SHA-256 algorithm.
     * 
     * @param password the password to be hashed
     * @return a hexadecimal string representing the hashed password
     * @throws RuntimeException if the SHA-256 algorithm is not available
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Attempts a brute-force attack to find the 6-digit number
     * 
     * @param targetHash the target hash to match
     * @return the 6-digit number that matches, or null if no match is found
     */
    public static String bruteForce6Digit(String targetHash) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                String mdp = Integer.toString(i) + Integer.toString(j) + Integer.toString(k)
                                        + Integer.toString(l) + Integer.toString(m) + Integer.toString(n);
                                if (hashPassword(mdp).equals(targetHash)) {
                                    return mdp;
                                }

                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Checks if the given password is strong according to the following criteria:
     * 
     * <ul>
     * <li>Minimum length of 12 characters</li>
     * <li>At least one uppercase letter</li>
     * <li>At least one lowercase letter</li>
     * <li>At least one digit</li>
     * <li>No whitespace characters</li>
     * </ul>
     * 
     * @param password the password to check
     * @return true if the password is strong, false otherwise
     */
    public static boolean isNotNumeric(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isStrongPassword(String password) {
        return (password.length() >= 12)
                && !(password.toLowerCase().equals(password))
                && !(password.toUpperCase().equals(password))
                && (password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3")
                        || password.contains("4") || password.contains("5") || password.contains("6")
                        || password.contains("7") || password.contains("8") || password.contains("9"))
                && isNotNumeric(password)
                && (password.replaceAll(" ", "").equals(password));
    }

    /**
     * Checks the strength of multiple passwords and stores the results in a
     * HashMap.
     *
     * @param passwords An ArrayList of passwords to be checked.
     * @return A HashMap where each password is mapped to a Boolean value:
     *         true if the password is strong, false otherwise
     */
    public static HashMap<String, Boolean> checkPasswordsList(ArrayList<String> passwords) {
        HashMap<String, Boolean> passwordMap = new HashMap<>();
        for (String password : passwords) {
            passwordMap.put(password, isStrongPassword(password));
        }
        return passwordMap;
    }

    /**
     * Generates a secure random password with at least:
     * <ul>
     * <li>1 uppercase letter</li>
     * <li>1 lowercase letter</li>
     * <li>1 digit</li>
     * <li>1 special character</li>
     * </ul>
     * 
     * @param nbCar The desired length of the password (minimum 4).
     * @return A randomly generated password that meets the security criteria.
     */
    public static String generatePassword(int nbCar) {
        if (nbCar < 4) {
            System.err.println("La taille du mot de passe aléatoire doit être de 4 caractères minimum.");
        }
        List<Character> passwordMap = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            passwordMap.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            passwordMap.add(c);
        }
        List<Character> specialCharactersInSolr = Arrays.asList(new Character[] {
                '+', '-', '&', '|', '!', '(', ')', '{', '}', '[', ']', '^',
                '~', '*', '?', ':' });

        List<String> ordrecaracteres = new ArrayList<>();
        ordrecaracteres = List.of("maj", "min", "chiffre", "spec");
        for (int i = 4; i < nbCar; i++) {
            int alea = (int) (Math.random() * 4);
            ordrecaracteres.add(ordrecaracteres[alea])
        }
        System.out.println(passwordMap);
        String mdp = "";
        for (int i = 0; i < nbCar; i++) {
            // On va déterminer l'ordre des caractères obligatoires.
            int randomNum = (int) (Math.random() * 5);

            System.out.println(randomNum);
        }

        return null;

    }

    public static void main(String[] args) {
        if (args.length == 0) {
            // No arguments provided, running all questions
            for (int i = 1; i <= 4; i++)
                runQuestion(String.valueOf(i));
        } else {
            for (String arg : args) {
                runQuestion(arg);
            }
        }
    }

    private static void runQuestion(String questionNumber) {

        System.out.println("\nQ" + questionNumber + "\n" + "-".repeat(20));
        switch (questionNumber) {
            case "1":
                String HashedPwd = "a97755204f392b4d8787b38d898671839b4a770a864e52862055cdbdf5bc5bee";
                String bruteForcedPwd = bruteForce6Digit(HashedPwd);
                System.out.println(bruteForcedPwd != null ? bruteForcedPwd : "No result found");
                break;

            case "2":
                System.out.println("Abc5          -> " + isStrongPassword("1234"));
                System.out.println("abcdef123456  -> " + isStrongPassword("abcdef123456"));
                System.out.println("AbCdEf123456  -> " + isStrongPassword("AbCdEf123456"));
                System.out.println("AbCdEf 123456 -> " + isStrongPassword("AbCdEf 123456"));
                break;

            case "3":
                ArrayList<String> passwords = new ArrayList<>(
                        List.of("Abc5", "abcdef123456", "AbCdEf123456", "AbCdEf 123456"));
                HashMap<String, Boolean> password_map = checkPasswordsList(passwords);

                if (password_map != null) {
                    for (Map.Entry<String, Boolean> entry : password_map.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }
                break;

            case "4":
                System.out.println("Generated password: " + generatePassword(12));
                break;

            default:
                System.out.println("Invalid question number: " + questionNumber);
        }
    }

}
