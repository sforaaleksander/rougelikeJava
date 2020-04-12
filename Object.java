
public enum Object {
    PLAYER("\u2B2E", Colours.RED), DIAMOND("\u25C6", Colours.YELLOW),
    HEART("\u2605", Colours.WHITE), GRASS(" ", Colours.BLACK),
    LAVA("\u2592", Colours.RED), MOSQUITO("\u2739", Colours.GREEN), SWAMP("\u2588", Colours.CYAN);

    public final String symbol;
    public final String colour;

    Object(String symbol, String colour){
        this.symbol = symbol;
        this.colour = colour;
    }
}




// public static final String playerSymbol = "\u2B2E";
// public static final String playerColour = Colours.RED;
// public static final String diamondSymbol = "\u25C6";
// public static final String diamondColour = Colours.YELLOW;
// public static final String heartSymbol = "\u2605";
// public static final String heartColour = Colours.WHITE;
// public static final String grassSymbol = " ";
// public static final String grassColour = Colours.BLACK;
// public static final String lavaSymbol = "\u2592";
// public static final String lavaColour = Colours.RED;
// public static final String mosquitoSymbol = "\u2739";
// public static final String mosquitoColour = Colours.GREEN;
// public static final String swampSymbol = "\u2588";
// public static final String swampColour = Colours.CYAN;