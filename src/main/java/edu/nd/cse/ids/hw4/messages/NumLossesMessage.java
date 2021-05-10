package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class NumLossesMessage extends Message
{
    private int numLosses;
    
    public NumLossesMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.numLosses = entry.getLosses(); 
    }
    
    public void setNumLosses(int nl)
    {
		this.numLosses = nl; 
    }
    
    public int getNumLosses()
    {
		return this.numLosses; 
    }
}
