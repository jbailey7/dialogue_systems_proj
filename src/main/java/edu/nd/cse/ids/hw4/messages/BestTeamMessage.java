package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class BestTeamMessage extends Message
{
    private String bestTeam;
    
    public BestTeamMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.bestTeam = entry.getBestTeam(); 
    }
    
    public void setBestTeam(String bt)
    {
		this.bestTeam = bt; 
    }
    
    public String getBestTeam()
    {
		return this.bestTeam; 
    }
}
