package dwarf.gfx;

public interface Colours {

    //Basic Colours:
    /**
     * The colour white. In the default sRGB space.
     */
    public final static Colour white = new Colour(0xff, 0xff, 0xff);

    /**
     * The colour white. In the default sRGB space.
     */
    public final static Colour WHITE = white;

    /**
     * The colour grey. In the default sRGB space.
     */
    public final static Colour grey = new Colour(0.5f, 0.5f, 0.5f, 0xff);

    /**
     * The colour grey. In the default sRGB space.
     */
    public final static Colour GREY = grey;

    /**
     * The colour dark grey. In the default sRGB space.
     */
    public final static Colour darkGrey = new Colour(0.3f, 0.3f, 0.3f, 0xff);

    /**
     * The colour dark grey. In the default sRGB space.
     */
    public final static Colour DARK_GREY = darkGrey;

    /**
     * The colour black. In the default sRGB space.
     */
    public final static Colour black = new Colour(0x0, 0x0, 0x0);

    /**
     * The colour black. In the default sRGB space.
     */
    public final static Colour BLACK = black;

    /**
     * The colour red. In the default sRGB space.
     */
    public final static Colour red = new Colour(0xff, 0x0, 0x0);

    /**
     * The colour red. In the default sRGB space.
     */
    public final static Colour RED = red;

    /**
     * The colour yellow. In the default sRGB space.
     */
    public final static Colour yellow = new Colour(0xff, 0xff, 0x0);

    /**
     * The colour yellow. In the default sRGB space.
     */
    public final static Colour YELLOW = yellow;

    /**
     * The colour lime. In the default sRGB space.
     */
    public final static Colour lime = new Colour(0x0, 0xff, 0x0);

    /**
     * The colour lime. In the default sRGB space.
     */
    public final static Colour LIME = lime;

    /**
     * The colour magenta. In the default sRGB space.
     */
    public final static Colour magenta = new Colour(0xff, 0x0, 0xff);

    /**
     * The colour magenta. In the default sRGB space.
     */
    public final static Colour MAGENTA = magenta;

    /**
     * The colour aqua. In the default sRGB space.
     */
    public final static Colour aqua = new Colour(0x0, 0xff, 0xff);

    /**
     * The colour aqua. In the default sRGB space.
     */
    public final static Colour AQUA = aqua;

    /**
     * The color blue. In the default sRGB space.
     */
    public final static Colour blue = new Colour(0x0, 0x0, 0xff);

    /**
     * The color blue. In the default sRGB space.
     */
    public final static Colour BLUE = blue;
    // --

    public final static Colour aquamarine = new Colour(0.439216, 0.858824, 0.576471);
    public final static Colour blueViolet = new Colour(0.62352, 0.372549, 0.623529);
    public final static Colour brown = new Colour(0.647059, 0.164706, 0.164706);
    public final static Colour cadetBlue = new Colour(0.372549, 0.623529, 0.623529);
    public final static Colour coral = new Colour(1.0, 0.498039, 0.0);
    public final static Colour cornflowerBlue = new Colour(0.258824, 0.258824, 0.435294);
    public final static Colour darkGreen = new Colour(0.184314, 0.309804, 0.184314);
    public final static Colour darkOliveGreen = new Colour(0.309804, 0.309804, 0.184314);
    public final static Colour darkOrchid = new Colour(0.6, 0.196078, 0.8);
    public final static Colour darkSlateBlue = new Colour(0.419608, 0.137255, 0.556863);
    public final static Colour darkSlateGray = new Colour(0.184314, 0.309804, 0.309804);
    public final static Colour darkSlateGrey = new Colour(0.184314, 0.309804, 0.309804);
    public final static Colour darkTurquoise = new Colour(0.439216, 0.576471, 0.858824);
    public final static Colour firebrick = new Colour(0.556863, 0.137255, 0.137255);
    public final static Colour forestGreen = new Colour(0.137255, 0.556863, 0.137255);
    public final static Colour gold = new Colour(0.8, 0.498039, 0.196078);
    public final static Colour goldenrod = new Colour(0.858824, 0.858824, 0.439216);
    public final static Colour greenYellow = new Colour(0.576471, 0.858824, 0.439216);
    public final static Colour indianRed = new Colour(0.309804, 0.184314, 0.184314);
    public final static Colour khaki = new Colour(0.623529, 0.623529, 0.372549);
    public final static Colour lightBlue = new Colour(0.74902, 0.847059, 0.847059);
    public final static Colour lightSteelBlue = new Colour(0.560784, 0.560784, 0.737255);
    public final static Colour limeGreen = new Colour(0.196078, 0.8, 0.196078);
    public final static Colour maroon = new Colour(0.556863, 0.137255, 0.419608);
    public final static Colour mediumAquamarine = new Colour(0.196078, 0.8, 0.6);
    public final static Colour mediumBlue = new Colour(0.196078, 0.196078, 0.8);
    public final static Colour mediumForestGreen = new Colour(0.419608, 0.556863, 0.137255);
    public final static Colour mediumGoldenrod = new Colour(0.917647, 0.917647, 0.678431);
    public final static Colour mediumOrchid = new Colour(0.576471, 0.439216, 0.858824);
    public final static Colour mediumSeaGreen = new Colour(0.258824, 0.435294, 0.258824);
    public final static Colour mediumTurquoise = new Colour(0.439216, 0.858824, 0.858824);
    public final static Colour mediumVioletRed = new Colour(0.858824, 0.439216, 0.576471);
    public final static Colour midnightBlue = new Colour(0.184314, 0.184314, 0.309804);
    public final static Colour navy = new Colour(0.137255, 0.137255, 0.556863);
    public final static Colour navyBlue = new Colour(0.137255, 0.137255, 0.556863);
    public final static Colour orange = new Colour(1, 0.5, 0.0);
    public final static Colour orchid = new Colour(0.858824, 0.439216, 0.858824);
    public final static Colour paleGreen = new Colour(0.560784, 0.737255, 0.560784);
    public final static Colour pink = new Colour(0.737255, 0.560784, 0.560784);
    public final static Colour plum = new Colour(0.917647, 0.678431, 0.917647);
    public final static Colour salmon = new Colour(0.435294, 0.258824, 0.258824);
    public final static Colour seaGreen = new Colour(0.137255, 0.556863, 0.419608);
    public final static Colour sienna = new Colour(0.556863, 0.419608, 0.137255);
    public final static Colour skyBlue = new Colour(0.196078, 0.6, 0.8);
    public final static Colour steelBlue = new Colour(0.137255, 0.419608, 0.556863);
    public final static Colour tan = new Colour(0.858824, 0.576471, 0.439216);
    public final static Colour thistle = new Colour(0.847059, 0.74902, 0.847059);
    public final static Colour turquoise = new Colour(0.678431, 0.917647, 0.917647);
    public final static Colour violet = new Colour(0.309804, 0.184314, 0.309804);
    public final static Colour violetRed = new Colour(0.8, 0.196078, 0.6);
    public final static Colour wheat = new Colour(0.847059, 0.847059, 0.74902);
    public final static Colour yellowGreen = new Colour(0.6, 0.8, 0.196078);
    public final static Colour summerSky = new Colour(0.22, 0.69, 0.87);
    public final static Colour richBlue = new Colour(0.35, 0.35, 0.67);
    public final static Colour brass = new Colour(0.71, 0.65, 0.26);
    public final static Colour copper = new Colour(0.72, 0.45, 0.20);
    public final static Colour bronze = new Colour(0.55, 0.47, 0.14);
    public final static Colour bronze2 = new Colour(0.65, 0.49, 0.24);
    public final static Colour silver = new Colour(0.90, 0.91, 0.98);
    public final static Colour brightGold = new Colour(0.85, 0.85, 0.10);
    public final static Colour oldGold = new Colour(0.81, 0.71, 0.23);
    public final static Colour feldspar = new Colour(0.82, 0.57, 0.46);
    public final static Colour quartz = new Colour(0.85, 0.85, 0.95);
    public final static Colour neonPink = new Colour(1.00, 0.43, 0.78);
    public final static Colour darkPurple = new Colour(0.53, 0.12, 0.47);
    public final static Colour neonBlue = new Colour(0.30, 0.30, 1.00);
    public final static Colour coolCopper = new Colour(0.85, 0.53, 0.10);
    public final static Colour mandarinOrange = new Colour(0.89, 0.47, 0.20);
    public final static Colour lightWood = new Colour(0.91, 0.76, 0.65);
    public final static Colour mediumWood = new Colour(0.65, 0.50, 0.39);
    public final static Colour darkWood = new Colour(0.52, 0.37, 0.26);
    public final static Colour spicyPink = new Colour(1.00, 0.11, 0.68);
    public final static Colour semiSweetChoc = new Colour(0.42, 0.26, 0.15);
    public final static Colour bakersChoc = new Colour(0.36, 0.20, 0.09);
    public final static Colour flesh = new Colour(0.96, 0.80, 0.69);
    public final static Colour newTan = new Colour(0.92, 0.78, 0.62);
    public final static Colour newMidnightBlue = new Colour(0.00, 0.00, 0.61);
    public final static Colour veryDarkBrown = new Colour(0.35, 0.16, 0.14);
    public final static Colour darkBrown = new Colour(0.36, 0.25, 0.20);
    public final static Colour darkTan = new Colour(0.59, 0.41, 0.31);
    public final static Colour greenCopper = new Colour(0.32, 0.49, 0.46);
    public final static Colour darkGreenCopper = new Colour(0.29, 0.46, 0.43);
    public final static Colour dustyRose = new Colour(0.52, 0.39, 0.39);
    public final static Colour huntersGreen = new Colour(0.13, 0.37, 0.31);
    public final static Colour scarlet = new Colour(0.55, 0.09, 0.09);
}
