import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends Actor
{
    public static int worldRelX = 0;
    public static int worldRelY = 0;
    private static int worldWidth;
    private static int worldHeight;
    GameWorld(GreenfootImage worldToGen)
    {
        setWorldRelLocation(0, 0);
        setLocation(worldRelX, worldRelY);
        
        
        worldWidth = worldToGen.getWidth() * 50;
        worldHeight = worldToGen.getWidth()* 50;
        
        GreenfootImage worldMap = new GreenfootImage(worldWidth, worldWidth);
        GreenfootImage waterTile = new GreenfootImage("Water1.png");
        waterTile.scale(50, 50);
        GreenfootImage grassTile = new GreenfootImage("GrassTile.png");
        grassTile.scale(50, 50);
        GreenfootImage sandTile = new GreenfootImage("sand2.png");
        sandTile.scale(50, 50);
        GreenfootImage pathTile = new GreenfootImage("path1.png");
        pathTile.scale(50, 50);
        
        for (int i = 0; i < worldWidth/50; i++)
        {
            for (int j = 0; j < worldHeight/50; j++)
            {
                if (worldToGen.getColorAt(i, j).equals(Color.BLUE))
                {
                    worldMap.drawImage(waterTile, i * 50, j* 50);
                    //System.out.print("found BLUE,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.RED))
                {
                    worldMap.drawImage(sandTile, i * 50, j* 50);
                    //System.out.print("found RED,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.GREEN))
                {
                    worldMap.drawImage(grassTile, i * 50, j* 50);
                    //System.out.print("found GREEN,================================== ");
                }
                if (worldToGen.getColorAt(i, j).equals(Color.MAGENTA))
                {
                    worldMap.drawImage(pathTile, i * 50, j* 50);
                    //System.out.print("found MAGENTA,================================== ");
                }
                //System.out.println("found " + worldToGen.getColorAt(i, j));
            }
        }
        setImage(worldMap);
    }
    
    /**
     * Act - do whatever the TempWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setLocation(worldRelX, worldRelY);
    }    
    public static void setWorldRelLocation(int newRelX, int newRelY)
    {
        worldRelX = newRelX;
        worldRelY = newRelY;
    }
    public static int getWorldRelX()
    {
        return worldRelX;
    }
    public static int getWorldRelY()
    {
        return worldRelY;
    }
    public static int getWorldWidth()
    {
        return worldWidth;
    }
    public static int getWorldHeight()
    {
        return worldHeight;
    }
}
