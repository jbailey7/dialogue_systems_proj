package edu.nd.cse.ids.hw4; 

import com.opencsv.bean.CsvBindByName; 

public class TeamEntry
{
	@CsvBindByName
	private String name; 

	@CsvBindByName
	private int wins; 

	@CsvBindByName
	private int losses; 

	@CsvBindByName
	private int ties; 

	@CsvBindByName
	private double win_percentage; 

	@CsvBindByName
	private int points_for; 

	@CsvBindByName
	private int points_against; 

	@CsvBindByName
	private int point_diff; 

	@CsvBindByName
	private double avg_point_diff; 

	@CsvBindByName
	private double schedule_toughness; 

	@CsvBindByName
	private double team_quality; 

	@CsvBindByName
	private double offense_quality; 

	@CsvBindByName
	private double defense_quality; 

	@CsvBindByName
	private String super_bowl_winner; 

	@CsvBindByName
	private String super_bowl_loser; 

	@CsvBindByName
	private String most_wins; 

	@CsvBindByName
	private String most_losses; 

	@CsvBindByName
	private String worst_team; 

	@CsvBindByName
	private String best_team; 

	@CsvBindByName
	private String toughest_schedule; 
	
	@CsvBindByName
	private String easiest_schedule; 

	public String getName()
	{
		return name; 
	}

	public int getWins() 
	{
		return wins; 
	}

	public int getLosses()
	{
		return losses; 
	}

	public int getTies() 
	{	
		return ties; 
	}

	public double getWinPercentage()
	{
		return win_percentage; 
	}

	public int getPointsFor()
	{
		return points_for; 
	}

	public int getPointsAgainst()
	{
		return points_against; 
	}

	public int getPointDiff() 
	{
		return point_diff; 
	}

	public double getAvgPointDiff() 
	{
		return avg_point_diff; 
	}

	public double getScheduleToughness() 
	{
		return schedule_toughness; 
	}

	public double getTeamQuality()
	{
		return team_quality; 
	}

	public double getOffenseQuality() 
	{
		return offense_quality; 
	}

	public double getDefenseQuality() 
	{
		return defense_quality;
	}

	public String getSuperBowlWinner()
	{
		return super_bowl_winner; 
	}

	public String getSuperBowlLoser()
	{
		return super_bowl_loser; 
	}

	public String getMostWins() 
	{
		return most_wins; 
	}

	public String getMostLosses()
	{
		return most_losses; 
	}

	public String getWorstTeam()
	{
		return worst_team; 
	}

	public String getBestTeam()
	{	
		return best_team; 
	}


	
}
