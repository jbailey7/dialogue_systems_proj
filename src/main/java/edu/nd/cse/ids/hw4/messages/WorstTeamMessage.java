package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class WorstTeamMessage extends Message
{
    private String worstTeam;
    
    public WorstTeamMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.worstTeam = entry.getWorstTeam(); 
    }
    
    public void setWorstTeam(String wt)
    {
		this.worstTeam = wt; 
    }
    
    public String getWorstTeam()
    {
		return this.worstTeam; 
    }
}
