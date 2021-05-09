package edu.nd.cse.ids.hw4.messages;

import edu.nd.cse.ids.hw4.*;

public class NumTiesMessage extends Message
{
    private int numTies;
    
    public NumTiesMessage()
    {
    }
    
    public void generate(ExamEntry entry)
    {
		this.numTies = entry.getNumTies(); 
    }
    
    public void setNumTies(int nt)
    {
		this.numTies = nt; 
    }
    
    public int getNumTies()
    {
		return this.numTies; 
    }
}
