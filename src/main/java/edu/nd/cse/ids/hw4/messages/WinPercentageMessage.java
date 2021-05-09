package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class WinPercentageMessage extends Message
{
    private double winPercentage;
    
    public WinPercentageMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.winPercentage = entry.getWinPercentage(); 
    }
    
    public void setWinPercentage(double wp)
    {
		this.winPercentage = wp; 
    }
    
    public double getWinPercentage()
    {
		return this.winPercentage; 
    }
}
