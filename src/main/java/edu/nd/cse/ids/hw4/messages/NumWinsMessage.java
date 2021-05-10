package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class NumWinsMessage extends Message
{
    private int numWins;
    
    public NumWinsMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.numWins = entry.getWins(); 
    }
    
    public void setNumWins(int nw)
    {
		this.numWins = nw; 
    }
    
    public int getNumWins()
    {
		return this.numWins; 
    }
}
