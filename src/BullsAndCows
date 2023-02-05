package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        playGame();

    }

        private static void playGame() {
            Scanner scanner = new Scanner(System.in);
            String secretCode = null;
            System.out.println("Input the length of the secret code:");
            String inputLength = scanner.nextLine();
            int n = 0;
            if (!inputLength.matches("\\d+")) {
                System.out.println("Error: " + inputLength + " isn't a valid number.");
                return;
            } else {
                n = Integer.parseInt(inputLength);
            }

            if (n <= 0) {
                System.out.println("Error: the length of the secret code must be a positive number.");
                return;
            }

            System.out.println("Input the number of possible symbols in the code:");
            int numPossibleSymbols = scanner.nextInt();
            if (numPossibleSymbols < n) {
                System.out.println("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.");
                return; // End the program if an error occured
            }
            if (numPossibleSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            } else {
                secretCode = generateSecretCode(n, numPossibleSymbols);
                getRangeOfPossibleNumbers(n, numPossibleSymbols);
            }

            startGame(secretCode);
        }

        private static void getRangeOfPossibleNumbers(int n, int numPossibleSymbols) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("*");
            }

            StringBuilder possibleSymbols = new StringBuilder();
            if (numPossibleSymbols <= 10) {
                possibleSymbols.append("0-").append(numPossibleSymbols - 1);
            } else {
                possibleSymbols.append("0-9, ");
                for (int i = 10; i < numPossibleSymbols; i++) {
                    possibleSymbols.append((char) ('a' + i - 10)).append(", ");
                }
                possibleSymbols.setLength(possibleSymbols.length() - 2);
            }
            System.out.println("The secret is prepared: " + sb + " (" + possibleSymbols.toString() + ")");
        }

        private static void startGame(String secretCode) {
            System.out.println("Okay, let's start a game!");
            int turnNumber = 1;
            boolean isBull = false;
            while (!isBull) {
                isBull = calculateAndPrint(secretCode, turnNumber);
                turnNumber++;
            }
        }

        private static String generateSecretCode(int n, int numPossibleSymbols) {
            boolean[] usedSymbols = new boolean[numPossibleSymbols];
            StringBuilder str = new StringBuilder();
            Random random = new Random();
            while (str.length() < n) {
                int nextSymbol = random.nextInt(numPossibleSymbols);
                if (!usedSymbols[nextSymbol]) {
                    usedSymbols[nextSymbol] = true;
                    str.append(nextSymbol < 10 ? (char) ('0' + nextSymbol) : (char) ('a' + nextSymbol - 10));
                }
            }
            return str.toString();
        }


        public static boolean calculateAndPrint(String secretCode, int turnNumber) {
            Scanner scanner = new Scanner(System.in);
            int n = secretCode.length();

            System.out.printf("Turn %d. Answer:\n", turnNumber);
            String numberToCheck = scanner.next();

            int cows = getCows(numberToCheck, secretCode);
            int bulls = getBulls(numberToCheck, secretCode);
            cows -= bulls;

            printGrade(cows, bulls);

            if (bulls == n) {
                System.out.println("Congratulations! You guessed the secret code.");
                return true;
            }
            return false;
        }

        private static void printGrade(int cows, int bulls) {
            if (cows == 0 && bulls == 0) {
                System.out.println("Grade: None.");
            } else if (cows == 0) {
                if (bulls == 1) {
                    System.out.println("Grade: 1 bull.");
                } else {
                    System.out.println("Grade: " + bulls + " bulls.");
                }
            } else if (bulls == 0) {
                if (cows == 1) {
                    System.out.println("Grade: 1 cow.");
                } else {
                    System.out.println("Grade: " + cows + " cows.");
                }
            } else if (bulls > 1) {
                if (cows == 1) {
                    System.out.println("Grade: " + bulls + " bulls and 1 cow.");
                } else {
                    System.out.println("Grade: " + bulls + " bulls and " + cows + " cows.");
                }
            } else if (cows > 1) {
                if (bulls == 1) {
                    System.out.println("Grade: 1 bull and " + cows + " cows.");
                } else {
                    System.out.println("Grade: " + bulls + " bulls and " + cows + " cows.");
                }
            }
        }

        private static int getBulls(String str1, String number) {
            int count = 0;
            String str2 = String.valueOf(number);
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    count++;
                }
            }
            return count;
        }

        private static int getCows(String secretCode, String number) {
            int count = 0;
            boolean[] vis = new boolean[secretCode.length()];

            for (int i = 0; i < secretCode.length(); i++) {
                for (int j = 0; j < secretCode.length(); j++) {
                    if (secretCode.charAt(i) == number.charAt(j) && !vis[j]) {
                        count++;
                        vis[j] = true;
                        break;
                    }
                }
            }
            return count;
        }
    }

