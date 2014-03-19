import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Move extends Actor
{
    public void act() 
    {
        // Add your action code here.
    }
    private String name;
    private String type;
    private int power;
    
    public int getPower()
    {
        return this.power;
    }
    public void setPower(int newPower)
    {
        this.power = newPower;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    public String getType()
    {
        return this.type;
    }
    public void settype(String newType)
    {
        this.type = newType;
    }
}