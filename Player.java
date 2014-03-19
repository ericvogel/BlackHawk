import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rizzo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int imageNumber = 2;
    
        GreenfootImage north1 = new GreenfootImage("Player\\north1.png");
        GreenfootImage north2 = new GreenfootImage("Player\\north2.png");
        GreenfootImage north3 = new GreenfootImage("Player\\north3.png");
        GreenfootImage east1 = new GreenfootImage("Player\\east1.png");
        GreenfootImage east2 = new GreenfootImage("Player\\east2.png");
        GreenfootImage east3 = new GreenfootImage("Player\\east3.png");
        GreenfootImage south1 = new GreenfootImage("Player\\south1.png");
        GreenfootImage south2 = new GreenfootImage("Player\\south2.png");
        GreenfootImage south3 = new GreenfootImage("Player\\south3.png");
        GreenfootImage west1 = new GreenfootImage("Player\\west1.png");
        GreenfootImage west2 = new GreenfootImage("Player\\west2.png");
        GreenfootImage west3 = new GreenfootImage("Player\\west3.png");
        GreenfootImage colMap = new GreenfootImage("colMap.png");
    public Player(String name)
    {
        this.playerName = name;
        north1.scale(48, 57);
        north2.scale(48, 57);
        north3.scale(48, 57);
        south1.scale(48, 57);
        south2.scale(48, 57);
        south3.scale(48, 57);
        east1.scale(48, 57);
        east2.scale(48, 57);
        east3.scale(48, 57);
        west1.scale(48, 57);
        west2.scale(48, 57);
        west3.scale(48, 57);
        setImage(north1);
    }
    /**
     * Act - do whatever the Rizzo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */;
    private static String playerName;
    private int moveSpeed = 4;
    private String directionFacing = "north";
    private int counter = 0;
    private int animationSpeed = 7;
    private static int newX;
    private static int newY;
    public void act() 
    {
        if (newX != -1 && newY != -1)
        {
            setLocation(newX, newY);
            newX = -1;
            newY = -1;
        }
        if (OverWorld.isMessageOpen == false)
        {
            if (Greenfoot.isKeyDown("right"))
            {
                directionFacing = "east";
                counter++;
                if (imageNumber == 2 && counter == animationSpeed)
                {
                    setImage(east3);
                    imageNumber = 3;
                    counter = 0;
                }else if (imageNumber == 3 && counter == animationSpeed)
                {
                    setImage(east2);
                    imageNumber= 2;
                    counter = 0;
                }
                setLocation(getX()+moveSpeed, getY());
            }
            else if (Greenfoot.isKeyDown("left"))
            {
                directionFacing = "west";
                counter++;
                if (imageNumber == 2 && counter == animationSpeed)
                {
                    setImage(west3);
                    imageNumber = 3;
                    counter = 0;
                }else if (imageNumber == 3 && counter == animationSpeed)
                {
                    setImage(west2);
                    imageNumber= 2;
                    counter = 0;
                }
                setLocation(getX()-moveSpeed, getY());
            }
            else if (Greenfoot.isKeyDown("up"))
            {
                directionFacing = "north";
                counter++;
                if (imageNumber == 2 && counter == animationSpeed)
                {
                    setImage(north3);
                    imageNumber = 3;
                    counter = 0;
                }else if (imageNumber == 3 && counter == animationSpeed)
                {
                    setImage(north2);
                    imageNumber= 2;
                    counter = 0;
                }
                setLocation(getX(), getY()-moveSpeed);
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                directionFacing = "south";
                counter++;
                if (imageNumber == 2 && counter == animationSpeed)
                {
                    setImage(south3);
                    imageNumber = 3;
                    counter = 0;
                }else if (imageNumber == 3 && counter == animationSpeed)
                {
                    setImage(south2);
                    imageNumber= 2;
                    counter = 0;
                }
                setLocation(getX(), getY()+moveSpeed);
            }
            else
            {
                counter = 4;
                if (directionFacing == "north")
                {
                    setImage(north1);
                }
                else if (directionFacing == "south")
                {
                    setImage(south1);
                }
                else if (directionFacing == "west")
                {
                    setImage(west1);
                }
                else if (directionFacing == "east")
                {
                    setImage(east1);
                }
            }
        }
        else
        {
            counter = 4;
            if (directionFacing == "north")
            {
                setImage(north1);
            }
            else if (directionFacing == "south")
            {
                setImage(south1);
            }
            else if (directionFacing == "west")
            {
                setImage(west1);
            }
            else if (directionFacing == "east")
            {
                setImage(east1);
            }
        }
        //System.out.println(directionFacing);
        runCollision();
        panWorld();
        //System.out.println(-GameWorld.getWorldRelX() + getX() + ", " + (-GameWorld.getWorldRelY() + getY()));
    }
    public void setMoveSpeed(int newMoveSpeed)
    {
        this.moveSpeed = newMoveSpeed;
    }
    public int getMoveSpeed()
    {
        return this.moveSpeed;
    }
    private void runCollision()
    {
        while (Greenfoot.isKeyDown("right") && ( getOneObjectAtOffset(20, 0, GameAI.class) != null || getOneObjectAtOffset(20, 28, GameAI.class) != null) )
        {
            GameAI temp = (GameAI)getObjectsInRange(65, GameAI.class).get(0);
            temp.displayMessage("west");
            setLocation(getX() - this.moveSpeed, getY());
        }
        while (Greenfoot.isKeyDown("left") && ( getOneObjectAtOffset(-20, 0, GameAI.class) != null || getOneObjectAtOffset(-20, 28, GameAI.class) != null) )
        {
            GameAI temp = (GameAI)getObjectsInRange(65, GameAI.class).get(0);
            temp.displayMessage("east");
            setLocation(getX() + this.moveSpeed, getY());
        }
        while (Greenfoot.isKeyDown("up") && ( getOneObjectAtOffset(-04, 0, GameAI.class) != null || getOneObjectAtOffset(20, 0, GameAI.class) != null) )
        {
            GameAI temp = (GameAI)getObjectsInRange(65, GameAI.class).get(0);
            temp.displayMessage("south");
            setLocation(getX(), getY() + this.moveSpeed);
        }
        while (Greenfoot.isKeyDown("down") && ( getOneObjectAtOffset(-20, 28, GameAI.class) != null || getOneObjectAtOffset(20, 28, GameAI.class) != null) )
        {
            GameAI temp = (GameAI)getObjectsInRange(65, GameAI.class).get(0);
            temp.displayMessage("north");
            setLocation(getX(), getY() - this.moveSpeed);
        }
        /*
         * AI collision is run above.
         * Map collision is run below.
         */
        while (Greenfoot.isKeyDown("right") && colMap.getColorAt((-GameWorld.getWorldRelX()+GameWorld.getWorldWidth()/2+25 + getX())/50,
                            (-GameWorld.getWorldRelY()+GameWorld.getWorldHeight()/2 + getY())/50).equals(java.awt.Color.RED))
        {
            //System.out.println("collision");
            setLocation(getX()-1, getY());
        }
        while (Greenfoot.isKeyDown("up") && colMap.getColorAt((-GameWorld.getWorldRelX()+GameWorld.getWorldWidth()/2 + getX())/50,
                            (-GameWorld.getWorldRelY()+GameWorld.getWorldHeight()/2 - 10 + getY())/50).equals(java.awt.Color.RED))
        {
            //System.out.println("collision");
            setLocation(getX(), getY()+1);
        }
        while (Greenfoot.isKeyDown("left") && colMap.getColorAt((-GameWorld.getWorldRelX()+GameWorld.getWorldWidth()/2-25 + getX())/50,
                            (-GameWorld.getWorldRelY()+GameWorld.getWorldHeight()/2 + getY())/50).equals(java.awt.Color.RED))
        {
            //System.out.println("collision");
            setLocation(getX()+1, getY());
        }
        while (Greenfoot.isKeyDown("down") && colMap.getColorAt((-GameWorld.getWorldRelX()+GameWorld.getWorldWidth()/2 + getX())/50,
                            (-GameWorld.getWorldRelY()+GameWorld.getWorldHeight()/2 + 30 + getY())/50).equals(java.awt.Color.RED))
        {
            //System.out.println("collision");
            setLocation(getX(), getY()-1);
        }
    }
    
    private void panWorld()
    {
        while (getX() > 624)
        {
            setLocation(getX()-1, getY());
            GameWorld.setWorldRelLocation(GameWorld.getWorldRelX()-1, GameWorld.getWorldRelY());
        }
        while (getX() < 400)
        {
            setLocation(getX()+1, getY());
            GameWorld.setWorldRelLocation(GameWorld.getWorldRelX()+1, GameWorld.getWorldRelY());
        }
        while (getY() < 250)
        {
            setLocation(getX(), getY()+1);
            GameWorld.setWorldRelLocation(GameWorld.getWorldRelX(), GameWorld.getWorldRelY()+1);
        }
        while (getY() > 350)
        {
            setLocation(getX(), getY()-1);
            GameWorld.setWorldRelLocation(GameWorld.getWorldRelX(), GameWorld.getWorldRelY()-1);
        }
    }
    public static String getName()
    {
        return playerName;
    }
    public static void setNewPos(int posX, int posY)
    {
        newX = posX;
        newY = posY;
    }
}