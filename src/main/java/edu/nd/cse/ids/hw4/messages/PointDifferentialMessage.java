package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class PointDifferentialMessage extends Message
{
    private int pointDifferential;
    
    public PointDifferentialMessage()
    {
    }
    
    public void generate(TeamEntry entry)
    {
		this.pointDifferential = entry.getPointDiff(); 
    }
    
    public void setPointDifferential(int pd)
    {
		this.pointDifferential = pd; 
    }
    
    public int getPointDifferential()
    {
		return this.pointDifferential; 
    }
}
