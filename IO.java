import java.util.Scanner;

public class IO {
    public static Scanner scan;

    public static void initializeScanner() {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
    }

    public static String gatherInput(String title) {
        System.out.println(title);
        boolean validInput = true;
        String userInput = "";
        do {
            if (!validInput) {
                System.out.println("Your input must contain at least one character. Enter again: ");
            }
            validInput = false;
            userInput = scan.next().toUpperCase();
            if (!userInput.equals("")) {
                validInput = true;
            }
        } while (!validInput);
        return userInput;
    }

    public static String gatherEmptyInput(String title) {
        System.out.println(title);
        String userInput = scan.next().toUpperCase();
        return userInput;
    }

    public static int gatherIntInput(String title, int range) {
        System.out.println(title);
        String userInput;
        int userInt = 1;
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("")) {
                if (userInput.matches("^[0-9]*$")) {
                    userInt = Integer.parseInt(userInput);
                    if (userInt > 0 && userInt <= range) {
                        validInput = true;
                    }
                }
            }
        }
        return userInt;
    }

	public static void welcomeScreen() {
        Engine.clearScreen();
        String sampleString = String.join(
        System.getProperty("line.separator"),
        "\n\n\n\n\n        ▄▄▄▄       ▄▄▄           ▄████     ███▄    █     ▒█████          ",
        "        ▓█████▄    ▒████▄        ██▒ ▀█▒    ██ ▀█   █    ▒██▒  ██▒        ",
        "        ▒██▒ ▄██   ▒██  ▀█▄     ▒██░▄▄▄░   ▓██  ▀█ ██▒   ▒██░  ██▒        ",
        "        ▒██░█▀     ░██▄▄▄▄██    ░▓█  ██▓   ▓██▒  ▐▌██▒   ▒██   ██░        ",
        "        ░▓█  ▀█▓    ▓█   ▓██▒   ░▒▓███▀▒   ▒██░   ▓██░   ░ ████▓▒░        ",
        "        ░▒▓███▀▒    ▒▒   ▓▒█░    ░▒   ▒    ░ ▒░   ▒ ▒    ░ ▒░▒░▒░         ",
        "        ▒░▒   ░      ▒   ▒▒ ░     ░   ░    ░ ░░   ░ ▒░     ░ ▒ ▒░         ",
        "         ░               ░  ░         ░             ░        ░ ░          ",
        "              ░                                                           "

        );
        System.out.println(sampleString);
        System.out.println("\n\n\n\t\t\tPRESS ANY KEY TO START GAME!");
	}

}