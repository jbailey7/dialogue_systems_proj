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

				base = handlePointsAgainstMessage((PoinstAgainstMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof PointsForMessage) {

				base = handlePointsForMessage((PointsForMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof ScheduleToughnessMessage) {

				base = handleScheduleToughnessMessage((ScheduleToughnessMessage)documentPlan.get(i)); 
			
			} else if (documentPlan.get(i) instanceof SuperBowlWinnerMessage) {

				base = handleSuperBowlWinnerMessage((SuperBowlWinnerMessage)documentPlan.get(i)); 
			
			} else if (documentPlane.get(i) instanceof SuperBowlLoserMessage) {
				
				base = handleSuperBowlLoserMessage((SuperBowlLostMessge)documentPlan.get(i)); 

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
		
		return s1; 
	}

	public SPhraseSpec handleBestTeamMessage(BestTeamMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleDefensiveQualityMessage(DefensiveQualityMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

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

		return s1; 
	}

	public SPhraseSpec handleNumTiesMessages(NumTiesMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}
	
	public SPhraseSpec handleNumWinsMessage(NumWinsMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleOffensiveQualityMessage(OffensiveQualityMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handlePointDifferentialMessage(PointDifferentialMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}
	
	public SPhraseSpec handlePointsAgainstMessage(PoinstAgainstMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handlePointsForMessage(PointsForMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleScheduleToughnessMessage(ScheduleToughnessMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

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

		return s1; 
	}

	public SPhraseSpec handleWinPercentageMessage(WinPercentageMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

	public SPhraseSpec handleWorstTeamMessage(WorstTeamMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 

		return s1; 
	}

}
