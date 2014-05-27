public class RegexDriver
{
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.err.println("Usage: java RegexReplacement infile.txt");
			System.exit(0);
		}
		
		RegexReplacement rr = new RegexReplacement();
		
		rr.regexFindPhoneNumbers(args[0]);
	}
}