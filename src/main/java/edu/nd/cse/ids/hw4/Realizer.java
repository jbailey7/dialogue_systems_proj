package edu.nd.cse.ids.hw4;

import java.util.List;
import java.util.LinkedList;
import java.util.*; 

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class Realizer
{
    private Lexicon lexicon;
    private Realiser realizer;
    
    public Realizer()
    {
        lexicon = Lexicon.getDefaultLexicon();
        realizer = new Realiser(lexicon);
    }
    
    public List<String> realize(List<SPhraseSpec> sentences)
    {
        // your code here
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < sentences.size(); i ++) {
			String output = this.realizer.realiseSentence(sentences.get(i)); 
			result.add(output); 
		}
	   	return result; 	
    }
}
