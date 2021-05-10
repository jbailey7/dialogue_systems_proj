package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class TeamQualityMessage extends Message
{
    private double teamQuality;
    
    public TeamQualityMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.teamQuality = entry.getTeamQuality(); 
    }
    
    public void setTeamQuality(double tq)
    {
		this.teamQuality = tq; 
    }
    
    public double getTeamQuality()
    {
		return this.teamQuality; 
    }
}
