import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pokemon extends Actor
{
    private int pokemonID;
    private String name;
    private String nickName;
    private int level;
    private int HP;
    private String type;
    private Move[] moveArray;
    private int EXP;
    private Pokemon evolvesInto;
    private GreenfootImage pokemonImage;
    
    /**
     * Pokemon Constructor:
     * Constructs a pokemon with the ID provided, and a default level as defined in the pokemon config file.
     *
     * @param ID The ID value of a pokemon
     * 
     */
    public Pokemon(int ID)
    {
        //look up properties of pokemon with said ID
        //calculate properties
        //add proerties to this pokemon
    }
     
    public Pokemon()
    {
        
    }
    public void act() 
    {
        // Add your action code here.
    }
    
    public int getIDValue()
    {
        return this.pokemonID;
    }
    private void setIDValue(int newpokemonID)
    {
        this.pokemonID = newpokemonID;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    public String getNickName()
    {
        return this.nickName;
    }
    public void setNickName(String newNickName)
    {
        this.nickName = newNickName;
    }
    public int getLevel()
    {
        return this.level;
    }
    public void setLevel(int newLevel)
    {
        this.level = newLevel;
    }
    public int getHP()
    {
        return this.HP;
    }
    public void setHP(int newHP)
    {
        this.HP = newHP;
    }
    public String getType()
    {
        return this.type;
    }
    public void setType(String newType)
    {
        this.type = newType;
    }
    public Move[] getMoveArray()
    {
        return this.moveArray;
    }
    public void setMoveArray(Move[] newMoveArray)
    {
        this.moveArray = newMoveArray;
    }
    public Move getOneMove(int index)
    {
        if (index > this.moveArray.length)
        {
            return null;
        }
        else
        {
            return this.moveArray[index];
        }
    }
    public void setOneMove(Move newMove, int index)
    {
        if (index > this.moveArray.length)
        {
            //error
        }
        else
        {
            this.moveArray[index] = newMove;
        }
    }
    public int getEXP()
    {
        return this.EXP;
    }
    public void setEXP(int newEXP)
    {
        this.EXP = newEXP;
    }
    public void addEXP(int EXPToAdd)
    {
        this.EXP += EXPToAdd;
    }
    public Pokemon getSvolvesInto()
    {
        return this.evolvesInto;
    }
    public void setEvolvesInto(Pokemon newEvolvesInto)
    {
        this.evolvesInto = newEvolvesInto;
    }
    public GreenfootImage getpokemonImage()
    {
        return this.pokemonImage;
    }
    public void setpokemonImage(GreenfootImage newPokemonImage)
    {
        this.pokemonImage = newPokemonImage;
    }
}
