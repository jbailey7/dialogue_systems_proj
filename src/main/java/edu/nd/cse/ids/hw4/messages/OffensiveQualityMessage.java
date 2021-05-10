package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class OffensiveQualityMessage extends Message
{
    private double offensiveQuality;
    
    public OffensiveQualityMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.offensiveQuality = entry.getOffenseQuality(); 
    }
    
    public void setOffensiveQuality(double oq)
    {
		this.offensiveQuality = oq; 
    }
    
    public double getOffensiveQuality()
    {
		return this.offensiveQuality; 
    }
}
