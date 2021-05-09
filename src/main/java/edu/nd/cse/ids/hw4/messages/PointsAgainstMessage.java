package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class PointsAgainstMessage extends Message
{
    private int pointsAgainst;
    
    public PointsAgainstMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.pointsAgainst = entry.getPointsAgainst(); 
    }
    
    public void setPointsAgainst(int pa)
    {
		this.pointsAgainst = pa; 
    }
    
    public int getPointsAgainst()
    {
		return this.pointsAgainst; 
    }
}
