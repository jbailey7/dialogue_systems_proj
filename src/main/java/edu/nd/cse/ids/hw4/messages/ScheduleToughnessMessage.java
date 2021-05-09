package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class ScheduleToughnessMessage extends Message
{
    private double scheduleToughness;
    
    public ScheduleToughnessMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.scheduleToughness = entry.getScheduleToughness(); 
    }
    
    public void setScheduleToughness(double st)
    {
		this.schedulteToughness = st; 
    }
    
    public double getScheduleToughness()
    {
		return this.scheduleToughness; 
    }
}
