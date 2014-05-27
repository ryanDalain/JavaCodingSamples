public class StringReverse
{


	// Returns a string which is the reverse of input string
	public static String reverseString(String source)
	{
		String retval = "";
		
		for(int i = source.length() - 1; i >= 0; i--)
			retval = retval + source.charAt(i);
		
		return retval;
	}
	
	public static char[] reverseString2(char[] source, int length)
	{
		char[] retval = new char[length];
		
		for(int i = 0; i <= length/2; i++)
		{
			char temp = source[i];
			retval[i] = source[length - 1 - i];
			retval[length - 1 - i] = temp;
		}
		
		return retval;
	}
	
	// pass in a word in the arguments and have it reversed in 2 ways
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage is java StringReverse \"word\"");
			System.exit(0);
		}

		String s = args[0];
		StringBuilder sb = new StringBuilder(s);
		
		// Reverse a string with a custom function
		System.out.println("String reversed using my custom function 'reverseString()'");
		System.out.println(reverseString(s));
		// Reverse a string with the built in feature of StringBuilder class
		System.out.println("String reversed using StringBuilder function 'reverse()'");
		System.out.println(sb.reverse().toString());
		// Reverse a string with a custom function
		System.out.println("String reversed using my custom function 'reverseString2()'");
		System.out.println("This function takes a character array and reverses in O(n/2)");
		System.out.println(reverseString2(s.toCharArray(), s.length()));
		
	}

}