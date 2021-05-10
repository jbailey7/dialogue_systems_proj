package edu.nd.cse.ids.hw4;

import edu.nd.cse.ids.hw4.messages.*;
import org.apache.commons.cli.HelpFormatter; 
import org.apache.commons.cli.Options; 
import org.apache.commons.cli.ParseException; 
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.CommandLine; 
import org.apache.commons.cli.CommandLineParser; 

import java.util.List;
import java.util.LinkedList;
import java.io.IOException; 
import java.util.*; 

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class TeamNLG {
    private TeamEntryReader reader;
	private MicroPlanner microplanner; 
	private int classification; 
	private String question; 

    public TeamNLG(String datfile, String q)
    {
        
		this.reader = new TeamEntryReader(); 
		this.reader.readTeamEntryFile(datfile); 

		this.microplanner = new MicroPlanner(); 

		this.question = q; 
    }

	public int getClassification() 
	{
		return this.classification; 
	}

    public List<String> describeEntryById(int entryid)
    {
        try
        {
            TeamEntry entry = this.reader.getEntries().get(entryid);
            return(this.describeEntry(entry));
        } catch(Exception ex)
        {
            return(null);
        }
    }



 
    public List<String> describeEntry(TeamEntry entry)
    {
		DocumentPlanner docplanner = new DocumentPlanner(); 

        docplanner.createMessages(entry);

		docplanner.setMessage(this.question); 
        
        List<Message> documentPlan = docplanner.getMessages();
        
        MicroPlanner microplanner = new MicroPlanner();
        
        List<SPhraseSpec> sentences = microplanner.lexicalize(documentPlan);
    
        Realizer realizer = new Realizer();
        
        return(realizer.realize(sentences));
    }

    public List<List<String>> describeAllEntries()
    {
        List<List<String>> allSentences = new LinkedList<List<String>>();
    
        for(TeamEntry entry: this.reader.getEntries())
        {
            allSentences.add(describeEntry(entry));
        }
        
        return(allSentences);
    }


    public static void main(String[] args) throws ParseException
    {
		
		Options gnuOptions = new Options(); 
		gnuOptions.addOption("s", true, "Scale")
				.addOption("h", true, "Scale")
	   			.addOption("q", true, "Scale");	

		CommandLineParser gnuParser = new GnuParser(); 
		CommandLine cmd = gnuParser.parse(gnuOptions, args); 

		String question = cmd.getOptionValue("q"); 
		String filename = "data/team_data.csv"; 	

		TeamNLG entryNlg = new TeamNLG(filename, question);


		int id = Integer.parseInt(cmd.getOptionValue("h"));

		List<String> description = new ArrayList<String>(); 
		description = entryNlg.describeEntryById(id); 

		for (int i = 0; i < description.size(); i ++) {
			System.out.println(description.get(i)); 
		}

		//System.out.println(description); 
}
}
