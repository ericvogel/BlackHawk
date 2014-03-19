import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class TextBox extends Actor
{
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage textBox = getImage();
    private int frameCounter = 0;
    private boolean scrolling = false;
    private String writing1 = "";
    private String writing2 = "";
    private String writing3 = "";
    private String writing4 = "";
    private String writing5 = "";
    private int line = 1;
    public TextBox(String line1, String line2, String line3,
                                String line4, String line5, boolean scroll)
    {
        getImage().scale(1024, 100);
        textBox.setFont(new java.awt.Font("DIALOG", 0, 18));
        if (scroll == false)
        {
            drawAll(line1, line2, line3, line4, line5);
        }
        else if (scroll == true)
        {
            this.scrolling = true;
            this.writing1 = line1;
            this.writing2 = line2;
            this.writing3 = line3;
            this.writing4 = line4;
            this.writing5 = line5;
        }
    }
    public void drawAll(String line01, String line02, String line03, String line04, String line05)
    {
        getImage().drawString(line01, 40, 22);
        getImage().drawString(line02, 40, 40);
        getImage().drawString(line03, 40, 58);
        getImage().drawString(line04, 40, 76);
        getImage().drawString(line05, 40, 94); 
    }
    public void act() 
    {
        if (this.scrolling == true)
        {
            if (Greenfoot.getKey() == "enter")
            {
                this.scrolling = false;
                drawAll(writing1, writing2, writing3, writing4, writing5);
            }
            frameCounter++;
            //System.out.println("Frame: " + frameCounter);
            //System.out.println("Line: "+ line);
            //System.out.println(frameCounter/3 > writing1.length());
            if (line == 1 && frameCounter%3 == 0 && frameCounter/3 <=writing1.length())
            {
                getImage().drawString(writing1.substring(0, frameCounter/3), 40, 22);
            }
            else if (line == 1 && frameCounter/3 > writing1.length())
            {
               line++;
               frameCounter = 0;
            }
            if (line == 2 && frameCounter%3 == 0 && frameCounter/3 <=writing2.length())
            {
                getImage().drawString(writing2.substring(0, frameCounter/3), 40, 40);
            }
            else if (line == 2 && frameCounter/3 > writing2.length())
            {
               line++;
               frameCounter = 0;
            }
            if (line == 3 && frameCounter%3 == 0 && frameCounter/3 <=writing3.length())
            {
                getImage().drawString(writing3.substring(0, frameCounter/3), 40, 58);
            }
            else if (line == 3 && frameCounter/3 > writing3.length())
            {
               line++; 
               frameCounter = 0;
            }
            if (line == 4 && frameCounter%3 == 0 && frameCounter/3 <=writing4.length())
            {
                getImage().drawString(writing4.substring(0, frameCounter/3), 40, 76);
            }
            else if (line == 4 && frameCounter/3 > writing4.length())
            {
               line++;
               frameCounter = 0;
            }
            if (line == 5 && frameCounter%3 == 0 && frameCounter/3 <=writing5.length())
            {
                getImage().drawString(writing5.substring(0, frameCounter/3), 40, 94);
            }
            else if (line == 5 && frameCounter/3 > writing5.length())
            {
               this.scrolling = false;
               frameCounter = 0;
            }
        }
        else if (this.scrolling == false)
        {
            if (Greenfoot.getKey() == "enter")
            {
                OverWorld.isMessageOpen = false;
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
