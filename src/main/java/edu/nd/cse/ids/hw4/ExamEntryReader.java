package edu.nd.cse.ids.hw4;

import com.opencsv.bean.*;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;

public class ExamEntryReader
{
	private List<ExamEntry> entries; 

    public ExamEntryReader()
    {
        entries = null;
    }

    public void readExamEntryFile(String filename)
    {
        try {
            this.entries = new CsvToBeanBuilder(new FileReader(filename))
                                .withType(ExamEntry.class).build().parse();
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public List<ExamEntry> getEntries()
    {
        return this.entries;
    }

}
