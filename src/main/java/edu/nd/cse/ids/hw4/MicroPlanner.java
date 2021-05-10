package edu.nd.cse.ids.hw4;

import edu.nd.cse.ids.hw4.messages.*;

import java.util.List;
import java.util.LinkedList;
import java.util.*;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class MicroPlanner
{
    private Lexicon lexicon;
    private NLGFactory nlgFactory;
    
    public MicroPlanner()
    {
       	this.lexicon = Lexicon.getDefaultLexicon(); 
		this.nlgFactory = new NLGFactory(this.lexicon); 
    }

    public List<SPhraseSpec> lexicalize(List<Message> documentPlan)
    {


		List<SPhraseSpec> specs = new ArrayList<SPhraseSpec>(); 

		for (int i = 0; i < documentPlan.size(); i ++) {
			SPhraseSpec base = nlgFactory.createClause(); 

			if (documentPlan.get(i) instanceof AveragePointDifferentialMessage) {

				base = handleAveragePointDifferentialMessage((AveragePointDifferentialMessage)documentPlan.get(i)); 

			} else if (documentPlan.get(i) instanceof BestTeamMessage) {

				base = handleBestTeamMessage((BestTeamMessage)documentPlan.get(i)); 

			} else if (documentPlan.get(i) instanceof DefensiveQualityMessage) {

				base = handleDefensiveQualityMessage((DefensiveQualityMessage)documentPlan.get(i)); 

			} else if (documentPlan.get(i) instanceof MostLossesMessage) {

				base = handleMostLossesMessage((MostLossesMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof MostWinsMessage) {

				base = handleMostWinsMessage((MostWinsMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof NumLossesMessage) {

				base = handleNumLossesMessage((NumLossesMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof NumTiesMessage) {

				base = handleNumTiesMessage((NumTiesMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof NumWinsMessage) {

				base = handleNumWinsMessage((NumWinsMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof OffensiveQualityMessage) {

				base = handleOffensiveQualityMessage((OffensiveQualityMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof PointDifferentialMessage) {

				base = handlePointDifferentialMessage((PointDifferentialMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof PointsAgainstMessage) {

				base = handlePointsAgainstMessage((PointsAgainstMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof PointsForMessage) {

				base = handlePointsForMessage((PointsForMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof ScheduleToughnessMessage) {

				base = handleScheduleToughnessMessage((ScheduleToughnessMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof SuperBowlWinnerMessage) {

				base = handleSuperBowlWinnerMessage((SuperBowlWinnerMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof SuperBowlLoserMessage) {
				
				base = handleSuperBowlLoserMessage((SuperBowlLoserMessage)documentPlan.get(i)); 

			} else if (documentPlan.get(i) instanceof TeamQualityMessage) {

				base = handleTeamQualityMessage((TeamQualityMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof WinPercentageMessage) {

				base = handleWinPercentageMessage((WinPercentageMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof WorstTeamMessage) {

				base = handleWorstTeamMessage((WorstTeamMessage)documentPlan.get(i)); 
			
			} else {
				System.out.println("Error in MicroPlanner line 104! Wack instance"); 

			}

			specs.add(base); 
		}

		return specs; 
    }
    
    public SPhraseSpec handleAveragePointDifferentialMessage(AveragePointDifferentialMessage message)
    {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 

		String obj = "a per game point differential of " + message.getAveragePointDifferential(); 

		if (message.getAveragePointDifferential() > 6.0) {
			obj += " which is among the best in the league"; 
		} else if (message.getAveragePointDifferential() > 3.0) {
			obj += " which is above average"; 
		} else if (message.getAveragePointDifferential() >= 0.0) {
			obj += " which is average"; 
		} else if (message.getAveragePointDifferential() > -3.0) {
			obj += " which is below average"; 
		} else {
			obj += " which is among the worst in the league"; 
		}

		s1.setObject(obj); 
		
		return s1; 
	}

	public SPhraseSpec handleBestTeamMessage(BestTeamMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleDefensiveQualityMessage(DefensiveQualityMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 
		 
		String obj = "a defensive quality rating of " + message.getDefensiveQuality(); 

		if (message.getDefensiveQuality() > 4.5) {
			obj += " which is among the best in the league"; 
		} else if (message.getDefensiveQuality() > 2.0) {
			obj += " which is above average"; 
		} else if (message.getDefensiveQuality() > 0.0) {
			obj += " which is average"; 
		} else if (message.getDefensiveQuality() > -2.0) {
			obj += " which is below average"; 
		} else {
			obj += " which is among the worst in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleMostLossesMessage(MostLossesMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleMostWinsMessage(MostWinsMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleNumLossesMessage(NumLossesMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("lost"); 
		s1.setTense(Tense.PAST); 

		String description = ""; 
		if (message.getNumLosses() > 12) {
			description = "a shockingly bad "; 
		} else if (message.getNumLosses() > 9) {
			description = "an embarassing "; 
		} else if (message.getNumLosses() > 7) {
			description = "a mediocre "; 
		} else {
			description = "only "; 
		}

		String obj = description + message.getNumLosses() + " games"; 
		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleNumTiesMessage(NumTiesMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("tie"); 
		s1.setTense(Tense.PAST); 

		String obj = message.getNumTies() + " "; 
		if (message.getNumTies() == 1) {
			obj += "game";
		} else {
			obj += "games"; 
		}
		s1.setObject(obj); 

		return s1; 
	}
	
	public SPhraseSpec handleNumWinsMessage(NumWinsMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("won"); 
		s1.setTense(Tense.PAST); 

		String description = ""; 
		if (message.getNumWins() > 12) {
			description = "an extremely impressive "; 
		} else if (message.getNumWins() > 9) {
			description = "an impressive "; 
		} else if (message.getNumWins() > 7) {
			description = "a solid "; 
		} else 	{		 
			description = "only "; 
		} 

		String obj = description + message.getNumWins() + " games"; 
		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleOffensiveQualityMessage(OffensiveQualityMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setObject("has"); 
		s1.setTense(Tense.PAST); 

		String obj = "an offensive quality score of " + message.getOffensiveQuality(); 

		if (message.getOffensiveQuality() > 4.5) {
			obj += " which is among the best in the league"; 
		} else if (message.getOffensiveQuality() > 2.0) {
			obj += " which is above average"; 
		} else if (message.getOffensiveQuality() > 0.0) {
			obj += " which is average"; 
		} else if (message.getOffensiveQuality() > -2.0) {
			obj += " which is below average"; 
		} else {
			obj += " which is among the worst in the league"; 
		}

		s1.setObject(obj); 
		

		return s1; 
	}

	public SPhraseSpec handlePointDifferentialMessage(PointDifferentialMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause();
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 

		String obj = " a point differential of " + message.getPointDifferential(); 

		if (message.getPointDifferential() > 110) {
			obj += " which is among the best in the league"; 
		} else if (message.getPointDifferential() > 50) {
			obj += " which is above average"; 
		} else if (message.getPointDifferential() > 0) {
			obj += " which is average";
		} else if (message.getPointDifferential() > -50) {
			obj += " which is below average"; 
		} else {
			obj += " which is among the worst in the league"; 
		}

		s1.setObject(obj); 
			
		return s1; 
	}
	
	public SPhraseSpec handlePointsAgainstMessage(PointsAgainstMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause();
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 
		
		String obj = message.getPointsAgainst() + " points scored against them"; 

		if (message.getPointsAgainst() > 448) {
			obj += " which is among the worst in the league"; 
		} else if (message.getPointsAgainst() > 400) {
			obj += " which is below average"; 
		} else if (message.getPointsAgainst() > 380) {
			obj += " which is average"; 
		} else if (message.getPointsAgainst() > 360) {
			obj += " which is above average"; 
		} else {
			obj += " which is among the best in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handlePointsForMessage(PointsForMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("scored"); 
		s1.setTense(Tense.PAST); 

		String obj = message.getPointsFor() + " points"; 

		if (message.getPointsFor() > 448) {
			obj += " which is among the best in the league"; 
		} else if (message.getPointsFor() > 400) {
			obj += " which is above average"; 
		} else if (message.getPointsFor() > 380) {
			obj += " which is average"; 
		} else if (message.getPointsFor() > 360) {
			obj += " which is below average"; 
		} else {
			obj += " which is among the worst in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleScheduleToughnessMessage(ScheduleToughnessMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 

		String obj = "a schedule toughness score of " + message.getScheduleToughness(); 

		if (message.getScheduleToughness() > 1.5) {
			obj += " making it one of the most difficult schedules faced in the league"; 
		} else if (message.getScheduleToughness() > 0.75) {
			obj += " making it tougher than average schedule"; 
		} else if (message.getScheduleToughness() > 0.0) {
			obj += " making it an averagely difficult schedule"; 
		} else if (message.getScheduleToughness() > -0.75) {
			obj += " making it a easier than average schedule"; 
		} else {
			obj += " making it one of the easiest schedules in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleSuperBowlWinnerMessage(SuperBowlWinnerMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleSuperBowlLoserMessage(SuperBowlLoserMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleTeamQualityMessage(TeamQualityMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 
		
		String obj = "a team quality rating of " + message.getTeamQuality(); 

		if (message.getTeamQuality() > 7.0) {
			obj += " which makes them one of the best teams in the league"; 
		} else if (message.getTeamQuality() > 4.5) {
			obj += " which makes them an above average team"; 
		} else if (message.getTeamQuality() > 0.0) {
			obj += " which makes them an average team"; 
		} else if (message.getTeamQuality() > -4.5) {
			obj += " which makes them a below average team"; 
		} else {
			obj += " which makes them one of the worst teams in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleWinPercentageMessage(WinPercentageMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("they"); 
		s1.setVerb("had"); 
		s1.setTense(Tense.PAST); 

		String obj = "a win percentage of " + message.getWinPercentage(); 

		if (message.getWinPercentage() > 0.75) {
			obj += " which makes them one of the winningest teams in the league"; 
		} else if (message.getWinPercentage() > 0.5652) {
			obj += " which makes them an above average team in terms of wins"; 
		} else if (message.getWinPercentage() > 0.4375) {
			obj += " which makes them a below average team in terms of wins"; 
		} else {
			obj += " which means they had one of the lowest win totals in the league"; 
		}

		s1.setObject(obj); 

		return s1; 
	}

	public SPhraseSpec handleWorstTeamMessage(WorstTeamMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

}
