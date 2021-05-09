package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class AveragePointDifferentialMessage extends Message
{
    private double averagePointDifferential;
    
    public AveragePointDifferentialMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.averagePointDifferential = entry.getAveragePointDifferential(); 
    }
    
    public void setAveragePointDifferential(double ad)
    {
		this.averagePointDifferential = ad; 
    }
    
    public double getAveragePointDifferential()
    {
		return this.averagePointDifferential; 
    }
}
