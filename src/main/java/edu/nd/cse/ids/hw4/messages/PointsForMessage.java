package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class PointsForMessage extends Message
{
    private int pointsFor;
    
    public PointsForMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.pointsFor = entry.getPointsFor(); 
    }
    
    public void setPointsFor(int pf)
    {
		this.pointsFor = pf; 
    }
    
    public int getPointsFor()
    {
		return this.pointsFor; 
    }
}
