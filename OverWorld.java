import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class OverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverWorld extends World
{
    public static boolean isMessageOpen = false;
    private GreenfootImage worldOne = new GreenfootImage("worldOne.png");
    private static ArrayList<TextBox> messageQue = new ArrayList<TextBox>(0);
    /**
     * Constructor for objects of class OverWorld.
     * 
     */
    public OverWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1, false);
        Setup();
    }
    public void Setup()
    {
        addObject(new GameWorld(worldOne), 0, 0);
        addObject(new GameAI(1025, 0, false, "Steve", new TextBox("Hi. My name is Steve! You can call me Stevie.", "I am a member of Steve Squad,", "our goal is to take over the world of", "<INSERT_GAME_NAME_HERE>", "", true),
                                new TextBox("...", "", "", "", "", true)), 0, 0);
        //loadWorld(worldOne, 2400, 500, true);
        String userInput = JOptionPane.showInputDialog("Please enter a name.");
        addObject(new Player(userInput), 0, 0);
        Player.setNewPos(-525, 0);
        act();
        
        addToMessageQue(new TextBox("Welcome " + Player.getName() + ",", "To wonderus land full of strange creatures unlike any seen before...","<INSERT_GAME_NAME_HERE>","","", true));
        addToMessageQue(new TextBox("Can you find the elusive Stevie?", "Only time will tell.", "Have fun Exploring the map!", "", "",true));
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("i") && isMessageOpen == false)
        {
            addToMessageQue(new TextBox("This is a test of a really long String object in a text box. I need to keep typing in", "order for this to new line.","","","", true));
        }
        if (messageQue.isEmpty() == false && isMessageOpen == false)
        {
            Greenfoot.getKey();
            addObject(getNextMessage(), 512, 550);
            isMessageOpen = true;
        }
        //System.out.println(isMessageOpen);
    }
    public static void addToMessageQue(TextBox newTextBox)
    {
        messageQue.add(newTextBox);
    }
    public static TextBox getNextMessage()
    {
        TextBox temp = messageQue.get(0);
        messageQue.remove(0);
        return temp;
    }
}
