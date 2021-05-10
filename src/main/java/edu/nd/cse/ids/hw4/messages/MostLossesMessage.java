package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class MostLossesMessage extends Message
{
    private String mostLosses;
    
    public MostLossesMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.mostLosses = entry.getMostLosses(); 
    }
    
    public void setMostLosses(String ml)
    {
		this.mostLosses = ml; 
    }
    
    public String getMostLosses()
    {
		return this.mostLosses; 
    }
}
