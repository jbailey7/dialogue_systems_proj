package edu.nd.cse.ids.hw4;

import com.opencsv.bean.*;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;

public class TeamEntryReader
{
	private List<TeamEntry> entries; 

    public TeamEntryReader()
    {
        entries = null;
    }

    public void readTeamEntryFile(String filename)
    {
        try {
            this.entries = new CsvToBeanBuilder(new FileReader(filename))
                                .withType(TeamEntry.class).build().parse();
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public List<TeamEntry> getEntries()
    {
        return this.entries;
    }

}
