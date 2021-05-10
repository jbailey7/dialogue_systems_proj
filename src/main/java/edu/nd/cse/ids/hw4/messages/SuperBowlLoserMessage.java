package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class SuperBowlLoserMessage extends Message
{
    private String superBowlLoser;
    
    public SuperBowlLoserMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.superBowlLoser = entry.getSuperBowlLoser(); 
    }
    
    public void setSuperBowlLoser(String sl)
    {
		this.superBowlLoser = sl; 
    }
    
    public String getSuperBowlLoser()
    {
		return this.superBowlLoser; 
    }
}
