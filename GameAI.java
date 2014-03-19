import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameAI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameAI extends Actor
{
    /**
     * Act - do whatever the GameAI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage AINorthImage;
    private GreenfootImage AIEastImage;
    private GreenfootImage AISouthImage;
    private GreenfootImage AIWestImage;
    private boolean spokenTo;
    private boolean walks;
    private int walkCounter;
    private String AIName;
    private TextBox message1;
    private TextBox message2;
    private int relX;
    private int relY;
    GameAI(int newX, int newY, boolean newWalks, String newAIName, TextBox newMessage1, TextBox newMessage2)
    {
        this.relX = newX;
        this.relY = newY;
        this.walks = newWalks;
        this.AIName = newAIName;
        this.AINorthImage = new GreenfootImage(AIName + "\\north.png");
        this.AIEastImage = new GreenfootImage(AIName + "\\east.png");
        this.AISouthImage = new GreenfootImage(AIName + "\\south.png");
        this.AIWestImage = new GreenfootImage(AIName + "\\west.png");
        this.AINorthImage.scale(48, 57);
        this.AIEastImage.scale(48, 57);
        this.AISouthImage.scale(48, 57);
        this.AIWestImage.scale(48, 57);
        setImage(AISouthImage);
        this.message1 = newMessage1;
        this.message2 = newMessage2;
        getImage().scale(48, 57);
        this.spokenTo = false;
    }
    public void act() 
    {
        //         if (this.walks == true)
        //         {
        //             //null
        //         }
        //System.out.println(this.spokenTo);
        setLocation(GameWorld.getWorldRelX() + relX, GameWorld.getWorldRelY() + relY);
        //System.out.println("X" + getX() + " , Y" + getY());
    }
    public void displayMessage(String directionToLook)
    {
        if (OverWorld.isMessageOpen == false)
        {
            if (this.spokenTo == false)
            {
                OverWorld.addToMessageQue(message1);
                this.spokenTo = true;
            }
            else
            {
                OverWorld.addToMessageQue(message2);
            }
            if (directionToLook == "north")
            {
                setImage(AINorthImage);
            }
            else if (directionToLook == "east")
            {
                setImage(AIEastImage);
            }
            else if (directionToLook == "south")
            {
                setImage(AISouthImage);
            }
            else if (directionToLook == "west")
            {
                setImage(AIWestImage);
            }
        }
    }
}
