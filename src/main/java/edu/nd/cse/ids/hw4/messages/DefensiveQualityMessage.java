package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class DefensiveQualityMessage extends Message
{
    private double defensiveQuality;
    
    public DefensiveQualityMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.defensiveQuality = entry.getDefenseQuality(); 
    }
    
    public void setDefensiveQuality(double dq)
    {
		this.defensiveQuality = dq; 
    }
    
    public double getDefensiveQuality()
    {
		return this.defensiveQuality; 
    }
}
