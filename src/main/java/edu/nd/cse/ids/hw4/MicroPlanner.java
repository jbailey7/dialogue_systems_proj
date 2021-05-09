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

			if (documentPlan.get(i) instanceof YearDiscoveredMessage) {
				base = handleYearDiscoveredMessage((YearDiscoveredMessage)documentPlan.get(i)); 
			} else if (documentPlan.get(i) instanceof PlanetMassMessage) {
				base = handlePlanetMassMessage((PlanetMassMessage)documentPlan.get(i)); 
			} else if (documentPlan.get(i) instanceof NumberPlanetsMessage) {
				base = handleNumberPlanetsMessage((NumberPlanetsMessage)documentPlan.get(i)); 
			} else if (documentPlan.get(i) instanceof NumberOrbitalMessage) {
				base = handleNumberOrbitalMessage((NumberOrbitalMessage)documentPlan.get(i)); 
			} else {
				System.out.println("Error in MicroPlanner line 60! Wack instance"); 

			}

			specs.add(base); 
		}

		return specs; 
    }
    
    public SPhraseSpec handleYearDiscoveredMessage(YearDiscoveredMessage message)
    {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("planet"); 
		s1.setVerb("was"); 
		String obj = "discovered in " + (int)message.getYearDiscovered(); 
		s1.setObject(obj); 
		s1.addFrontModifier("this"); 
		
		return s1; 
	}

	public SPhraseSpec handlePlanetMassMessage(PlanetMassMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("planet"); 
		s1.setVerb("has"); 
		String obj = "a mass of " + (int)message.getPlanetMass() + " Jupiters"; 
		s1.setObject(obj); 
		s1.setFrontModifier("this"); 

		return s1; 
	}

	public SPhraseSpec handleNumberPlanetsMessage(NumberPlanetsMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("planet"); 
		s1.setVerb("is"); 
		String obj = "one of " + (int)message.getNumberPlanets() + " known in its system"; 
		s1.setObject(obj); 
		s1.setFrontModifier("this"); 

		return s1; 
	}

	public SPhraseSpec handleNumberOrbitalMessage(NumberOrbitalMessage message) {
		SPhraseSpec s1 = nlgFactory.createClause(); 
		s1.setSubject("planet"); 
		s1.setVerb("takes"); 
		String obj = (int)message.getNumberOrbital() + " days to orbit its star"; 
		s1.setObject(obj); 
		s1.setFrontModifier("this"); 

		return s1; 
	}
}
