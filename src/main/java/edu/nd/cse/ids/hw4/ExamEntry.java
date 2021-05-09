package edu.nd.cse.ids.hw4; 

import com.opencsv.bean.CsvBindByName; 

public class ExamEntry
{
	@CsvBindByName
	private int rowid; 
	
	@CsvBindByName
	private String pl_discmethod; 

	@CsvBindByName
	private int pl_pnum; 

	@CsvBindByName
	private double pl_orbper; 

	@CsvBindByName
	private double pl_msinij; 

	@CsvBindByName
	private double st_dist; 

	@CsvBindByName 
	private int pl_disc; 

	public int getRowId()
	{
		return rowid; 
	}

	public String getDiscMethod() 
	{
		return pl_discmethod; 
	}

	public int getNumberPlanets() 
	{
		return pl_pnum; 
	}

	public double getNumberOrbital() 
	{
		return pl_orbper; 
	}

	public double getPlanetMass()
	{
		return pl_msinij; 
	}

	public double getDist()
	{
		return st_dist; 
	}

	public int getYearDiscovered() 
	{
		return pl_disc; 
	}

}
