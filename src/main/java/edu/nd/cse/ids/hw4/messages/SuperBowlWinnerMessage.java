package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class SuperBowlWinnerMessage extends Message
{
    private String superBowlWinner;
    
    public SuperBowlWinnerMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.superBowlWinner = entry.getSuperBowlWinner(); 
    }
    
    public void setSuperBowlWinner(String sw)
    {
		this.superBowlWinner = sw; 
    }
    
    public String getSuperBowlWinner()
    {
		return this.superBowlWinner; 
    }
}
