import java.util.ArrayList;

public class StringPermutation
{

	// returns a list of all permutations of a given string
	public static ArrayList<String> permutations(String source)
	{
		ArrayList<String> perms = new ArrayList<String>();
		
		if(source == null)
			return null;
		else if(source.length() == 0)
		{
			perms.add("");
			return perms;
		}
		
		char first = source.charAt(0);
		String rest = source.substring(1);
		ArrayList<String> words = permutations(rest);
		
		for(String word : words)
		{
			for(int i = 0; i <= word.length(); i++)
			{
				perms.add(insertCharAtLocation(word, first, i));
			}
		}
		
		
		return perms;
	}
	
	public static String insertCharAtLocation(String source, char c, int location)
	{	
		int i = location;
		if(location > source.length())
			i = source.length();
		String firstpart = source.substring(0, i);
		String lastpart = source. substring(i);
		
		return firstpart + c + lastpart;
	}

	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage: java StringPermutation \"word\"");
			System.exit(0);
		}
		
		ArrayList<String> set = permutations(args[0]);
		
		for(String s : set)
			System.out.println(s);
	}
}