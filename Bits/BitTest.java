import java.nio.ByteOrder;

public class BitTest
{

	public static void printEndianness()
	{
		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) 
			System.out.println("Big-endian");
		else 
			System.out.println("Little-endian");
	}
	
	public static void printIntAsBits(int input)
	{
		// example: 10 in binary = 1010
		// remember: 1 in binary can be 1 or 01 or 001 or 0001 etc...
		// 1010 & 0001 = 0 (insert into beginning of string; string now = "0")
		// 1010 >>> 1 = 101
		// 101 & 0001 = 1 (insert into beginning of string; string now = "01")
		// 101 >>> 1
		// 10 & 0001 = 0 (insert into beginning of string; string now = "010")
		// 10 >>> 1 = 1
		// 1 & 0001 = 1 (insert into beginning of string; string now = "0101")
		// result = 0101 = backwards, either flip once, or insert to index 0 at each insertion
		// corrected result = 1010
		StringBuilder binaryRepresentation = new StringBuilder();
		while(input != 0)
		{
			// apparently inserting into the beginning is terrible inefficient for StringBuilder.
			// as this shifts over every letter in the string by 1 every time its called
			// better solution would be to simply append each letter and reverse string after you are done
			// with StringBuilder function 'reverse()'
			binaryRepresentation.insert(0,Integer.toString(input & 1));
			input = input >> 1;
		}
		System.out.println("My functions results: \n" + binaryRepresentation);
	}

	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage is: java BitTest <number>");
			System.exit(0);
		}
		int input = Integer.parseInt(args[0]);
		printIntAsBits(input);
		
		System.out.println("Check answer using native functionality: ");
		System.out.println(Integer.toBinaryString(input));
	}

}