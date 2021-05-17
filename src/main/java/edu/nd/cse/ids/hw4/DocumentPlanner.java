//package edu.nd.cse.ids.mlwkr;
package edu.nd.cse.ids.hw4;

import edu.nd.cse.ids.hw4.messages.*;

import java.io.File; 
import java.util.Arrays; 
import org.deeplearning4j.nn.api.Layer; 
import org.deeplearning4j.nn.api.OptimizationAlgorithm; 
import org.deeplearning4j.nn.conf.layers.DenseLayer; 
import org.deeplearning4j.nn.conf.layers.LossLayer; 
import org.nd4j.linalg.activations.Activation; 
import org.nd4j.linalg.lossfunctions.LossFunctions; 

import java.util.List;
import java.util.LinkedList;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport; 
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
//import org.nd4j.linalg.io.ClassPathResource;
import org.deeplearning4j.nn.modelimport.keras.preprocessing.text.KerasTokenizer; 
import java.io.IOException;
import org.deeplearning4j.nn.modelimport.keras.preprocessing.text.TokenizerMode; 
//import org.nd4j.common.resources.Resources;


public class DocumentPlanner
{
    private List<Message> teammessages;
	private List<Message> leaguemessages; 
	private MultiLayerNetwork model; 
	private KerasTokenizer tokenizer; 
	private String message; 
	private int classification;
   	private int type; 	

	/*
    public DocumentPlanner()     {
        messages = new LinkedList<Message>();

		

		String simpleMlp = ""; 
		
		// load in model 
		try {
			simpleMlp = "qa_g_lstm.h5"; 
		}
		catch(Exception e) {
			e.printStackTrace();
		   	System.out.println("loading h5 file did not work"); 	
		}
		
		try {
			model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp); 
		}
		catch(Exception e) {
			e.printStackTrace(); 
			System.out.println("creating the model from the h5 file did not work"); 
		}

		
		// load in tokenizer
		String path = "qa_tok.json"; 
		try {
			tokenizer = KerasTokenizer.fromJson(path); 
    	}
		catch (Exception e) {
			e.printStackTrace(); 
			System.out.println("loading tokenizer did not work"); 
		}

		
	}
	*/

	public DocumentPlanner(String type) {
		teammessages = new LinkedList<Message>(); 
		leaguemessages = new LinkedList<Message>(); 

		String simpleMlp = ""; 
		String tokenPath = ""; 

		// load in model and tokenizer based on question type
		if (type.equals("team")) {
			simpleMlp = "team_lstm.h5"; 
			tokenPath = "team_tok.json"; 
			this.setType(0); 
			
			try {
				model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp); 
			} catch (Exception e) {
				e.printStackTrace(); 
				System.out.println("creating the team model from the h5 file did not work"); 
			}

			try {
				tokenizer = KerasTokenizer.fromJson(tokenPath); 
			} catch (Exception e) {
				e.printStackTrace(); 
				System.out.println("loading team tokenizer did not work"); 
			}
		} else {
			simpleMlp = "league_lstm.h5"; 
			tokenPath = "league_tok.json"; 
			this.setType(1); 
			
			try {
				model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp); 
			} catch (Exception e) {
				e.printStackTrace(); 
				System.out.println("creating the league model from the h5 file did not work"); 
			}

			try {
				tokenizer = KerasTokenizer.fromJson(tokenPath); 
			} catch (Exception e) {
				e.printStackTrace(); 
				System.out.println("loading league tokenizer did not work"); 
			}


		}
	}


    public void createMessages(TeamEntry entry)
    {

		AveragePointDifferentialMessage avgPointDiff = new AveragePointDifferentialMessage(); 
		avgPointDiff.generate(entry); 
		teammessages.add(avgPointDiff); 

		BestTeamMessage bestTeam = new BestTeamMessage(); 
		bestTeam.generate(entry); 
		leaguemessages.add(bestTeam); 

		DefensiveQualityMessage defQual = new DefensiveQualityMessage(); 
		defQual.generate(entry); 
		teammessages.add(defQual); 

		MostLossesMessage mostLosses = new MostLossesMessage(); 
		mostLosses.generate(entry); 
		leaguemessages.add(mostLosses); 

		MostWinsMessage mostWins = new MostWinsMessage(); 
		mostWins.generate(entry); 
		leaguemessages.add(mostWins); 

		NumLossesMessage numLosses = new NumLossesMessage(); 
		numLosses.generate(entry); 
		teammessages.add(numLosses); 

		NumTiesMessage numTies = new NumTiesMessage(); 
		numTies.generate(entry); 
		teammessages.add(numTies); 

		NumWinsMessage numWins = new NumWinsMessage(); 
		numWins.generate(entry); 
		teammessages.add(numWins); 

		OffensiveQualityMessage offQual = new OffensiveQualityMessage(); 
		offQual.generate(entry); 
		teammessages.add(offQual); 

		PointDifferentialMessage pointDiff = new PointDifferentialMessage(); 
		pointDiff.generate(entry); 
		teammessages.add(pointDiff);

		PointsAgainstMessage pointsAgainst = new PointsAgainstMessage(); 
		pointsAgainst.generate(entry); 
		teammessages.add(pointsAgainst); 

		PointsForMessage pointsFor = new PointsForMessage(); 
		pointsFor.generate(entry); 
		teammessages.add(pointsFor); 

		ScheduleToughnessMessage schedTough = new ScheduleToughnessMessage(); 
		schedTough.generate(entry); 
		teammessages.add(schedTough); 

		SuperBowlLoserMessage bowlLoser = new SuperBowlLoserMessage(); 
		bowlLoser.generate(entry); 
		leaguemessages.add(bowlLoser); 

		SuperBowlWinnerMessage bowlWinner = new SuperBowlWinnerMessage(); 
		bowlWinner.generate(entry); 
		leaguemessages.add(bowlWinner); 

		TeamQualityMessage qual = new TeamQualityMessage(); 
		qual.generate(entry); 
		teammessages.add(qual); 

		WinPercentageMessage winPercent = new WinPercentageMessage(); 
		winPercent.generate(entry); 
		teammessages.add(winPercent); 

		WorstTeamMessage worstTeam = new WorstTeamMessage(); 
		worstTeam.generate(entry); 
		leaguemessages.add(worstTeam); 
	




    }

		    
	public int[] padcrop(Integer[][] seqp, int seqlen) 
	{
		//int[] temp = new int[20]; 
		//return temp; 
		int[] padcrop = new int[seqlen]; 
		for (Integer[] oneD : seqp) {
			for (int i = 0; i < seqlen; i ++) {
				if (i >= oneD.length) {
					break; 
				}
				padcrop[i] = oneD[i]; 
			}
		}

		return padcrop; 
	}

    /**
    * Provide access to the list of message objects.
    * Note that the method createMessages() may be called many times for
    * different houses, or it may have been cleared.
    *
    * @return           a list of messages about the house (just one for hw3)
    */
    public List<Message> getMessages()
    {
		
		try {
			String text = this.message;
			
			text = text.replace("\n", " "); 
			text = text.replaceAll("[^0-9a-zA-Z]+", " "); 
			text = text.toLowerCase(); 
			

			int seqlen = 200; 

			String[] texts = new String[1]; 
			texts[0] = text; 
		
			Integer[][] seq = tokenizer.textsToSequences(texts); 



			int newseq[] = padcrop(seq, seqlen); 
	

			
	
			INDArray input = Nd4j.create(1, seqlen); 
	
			for (int i = 0; i < seqlen; i ++) {
				input.putScalar(new int[] {i}, newseq[i]); 
			}
	
			INDArray output = model.output(input); 
	
			this.classification = output.argMax(1).getInt(0); 




			// Tried to come up with a system where any category that was classified at more than 0.1 would 
			// be printed out, but couldn't get the INDArray syntax to work for any of the things
			// I tried below



			
			/*
			System.out.println("TESTING_____________"); 
			System.out.println("INDArray output: "); 
			System.out.println(output); 
			System.out.println("output.argMax(1): "); 
			System.out.println(output.argMax(1)); 
			
			System.out.println(output.getInt(0)); 
			System.out.println(output.getInt(3)); 
			System.out.println((List<int>)output); 
			//System.out.println(output.get(0).get(3)); 
			System.out.println("output.argMax(2)"); 
			System.out.println(output.argMax(2)); 
			System.out.println(output.argMax(3)); 
			System.out.println(output.argMax(4)); 
			
			//List<Message>result = new LinkedList<Message>();	
			for (int i = 0; i < 4; i ++) {
				if (output.get(i) > 0.10) {
					result.add(messages.get(i)); 
				}
			}*/
	
		} catch (Exception ex) {
			ex.printStackTrace(); 
			System.out.println("getMessages did not work"); 
		}

		List<Message> result = new LinkedList<Message>(); 
		if (this.getType() == 0) {
			result.add(teammessages.get(this.classification)); 
		} else {
			result.add(leaguemessages.get(this.classification)); 
		}



		return result; 
    }

	public void setMessage(String m) 
	{
		this.message = m; 
	}

	public String getMessage() 
	{
		return this.message; 
	}

	public int getClassification()
	{
		return this.classification; 
	}

	public void setType(int t) 
	{
		this.type = t; 
	}

	public int getType() 
	{
		return this.type; 
	}
}
