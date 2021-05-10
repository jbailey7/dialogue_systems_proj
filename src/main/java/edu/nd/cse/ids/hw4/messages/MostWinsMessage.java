package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class MostWinsMessage extends Message
{
    private String mostWins;
    
    public MostWinsMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.mostWins = entry.getMostWins(); 
    }
    
    public void setMostWins(String mw)
    {
		this.mostWins = mw; 
    }
    
    public String getMostWins()
    {
		return this.mostWins; 
    }
}
