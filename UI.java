public class UI {

    public static void displayMap(WorldMap map) {
        for (int y = 0; y < map.getHeight(); y++){
            for (int x = 0; x < map.getWidth(); x++){
                System.out.print(map.getBoard()[y][x].getCurrentObject().getSymbol());
            }
            System.out.println("");
        }
    }

    public static void bottomDisplay(Player player){
        //TODO ZROBIC 2 OSOBNE METODY Z PARAMETREM PLAYER DO GENEROWANIA OSOBNO HP I OSOBNO DIAMENTOW
        String hpResult = "HP: ";
        String collectedDiamonds = "DIAMONDS: ";
        for (int i =0; i<player.getHp();i++){
            hpResult += Colours.WHITE + "\u2605 " + Colours.RESET;
        }

        collectedDiamonds += 
        player.getCollectedDiamonds() + "/" + player.getCurrentMap().getNumberOfDiamonds()+ " ";

        for (int i =0; i<player.getCollectedDiamonds();i++){
            collectedDiamonds += Colours.YELLOW + "\u25C6 " + Colours.RESET;
        }
        String concatenatedResult = hpResult + "\n" + collectedDiamonds;
        System.out.println(concatenatedResult);
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
        System.out.println("\n\nQuick tips:\n\nYou are: " + Colours.RED + "\u2B2E" + Colours.RESET);
        System.out.println("\nCollect: " + Colours.YELLOW + "\u25C6" + Colours.RESET);
        System.out.println("\nWatch out for: "+ Colours.GREEN + "\u2739" + Colours.RESET +" and "+ Colours.RED + "\u2592" + Colours.RESET);
	}

}