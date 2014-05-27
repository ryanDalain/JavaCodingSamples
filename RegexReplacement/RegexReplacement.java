import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;


// purpose is to pass in a file name and replace all numbers in the format xxx-xxx-xxxx with (xxx)xxx-xxxx
public class RegexReplacement
{
	private Pattern phoneNumberPattern;
	
	RegexReplacement()
	{
		phoneNumberPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // of the format xxx-xxx-xxxx
	}
	
	// find phone numbers that match the regex type
	public void regexFindPhoneNumbers(String filelocation)
	{
		BufferedReader br;
		
		// try opening the file
		try
		{
			br = new BufferedReader(new FileReader(filelocation));
			
			String line;
			StringBuilder filecontents = new StringBuilder();
			
			while((line = br.readLine()) != null)
			{
				filecontents.append(line);
			}
			
			//System.out.println(filecontents.toString());
		
			Matcher matcher = phoneNumberPattern.matcher(filecontents.toString());
			
			while(matcher.find())
				System.out.println("Found phone number: " + matcher.group());
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Could not open file.");
			System.exit(0);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(0);
		}
		
		
	}

}