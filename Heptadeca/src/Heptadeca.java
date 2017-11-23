import java.util.Scanner;
public class Heptadeca 
{
	private String number;
	private int decimal;
	private int sign = 1;
	private Scanner keyboard;
	private final String[] HEPTADECA_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G"};
	private final String HEPTADECA_STRING = "0123456789ABCDEFG";

	public Heptadeca()
	{
		keyboard = new Scanner(System.in);
		number = "";
		decimal = 0;
	}
	
	public Heptadeca(int decimal)
	{
		this();
		this.decimal = decimal;
	}

	public Heptadeca(String number) 
	{
		this();
		this.number = number;
		preCalculate();
	}
	private String decimalToHeptadeca(int decimal)
	{
		String output = "";
		int sign = 1;
		if (decimal < 0) {
			sign = -1;
			decimal *= sign;
		}
		while (decimal >= 17) {
			output = HEPTADECA_ARRAY[decimal % 17] + output;
			decimal = decimal / 17;
		};
		output = HEPTADECA_ARRAY[decimal] + output;
		if (sign == -1) {
			output = "-" + output;
		}
		return output;
	}
	
	public int heptadecaToDecimal(String number) 
	{
		char ch;
		int output = 0;
		int len = number.length();
		for (int i=(len-1); i>-1; i--) {
			ch = number.charAt(i);
			output += (HEPTADECA_STRING.indexOf(ch)*(int)Math.pow(17, Math.abs(len-i-1)));
		}
		return output;
	}
	
	private void preCalculate() 
	{
		int len = this.number.length() - 1;
		char firstChar = this.number.charAt(0);
		char lastChar = this.number.charAt(len);
		
		if (lastChar != 'h') 
		{
			System.out.println("Heptadeca number should end with 'h'");
			System.exit(0);
		}
		if (firstChar == '-') 
		{
			sign = -1;
			this.number = this.number.substring(1, (len));
		}
		else 
		{
			this.number = this.number.substring(0, (len));
		}
	}

	public void read()
	{
		System.out.print("Enter Heptadeca number : ");
		this.number = keyboard.nextLine();
		this.preCalculate();
	}

	public void set(String number)
	{
		this.number = number;
	}

	public void set(int decimal)
	{
		this.decimal = decimal;
	}

	public void set(Heptadeca heptadeca)
	{
		this.number = heptadeca.number;
		this.decimal = heptadeca.decimal;
	}

	public Heptadeca get()
	{
		Heptadeca dummy = new Heptadeca();
		dummy.set(this);
		return dummy;
	}

	public Heptadeca add(Heptadeca heptadeca)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(heptadeca.number);
		int result = decimal1 + decimal2;

		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca subtract(Heptadeca heptadeca)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(heptadeca.number);
		int result = decimal1 - decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca multiply(Heptadeca heptadeca)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(heptadeca.number);
		int result = decimal1 * decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca divide(Heptadeca heptadeca)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(heptadeca.number);
		int result = decimal1 / decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca add(int decimal)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int result = decimal1 + decimal;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca subtract(int decimal)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int result = decimal1 - decimal;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca multiply(int decimal)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int result = decimal1 * decimal;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca divide(int decimal)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int result = decimal1 + decimal;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca add(String number)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(number);
		int result = decimal1 + decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca subtract(String number)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(number);
		int result = decimal1 - decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca multiply(String number)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(number);
		int result = decimal1 * decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public Heptadeca divide(String number)
	{
		int decimal1 = this.heptadecaToDecimal(this.number);
		int decimal2 = this.heptadecaToDecimal(number);
		int result = decimal1 / decimal2;
		
		Heptadeca dummy = new Heptadeca(this.decimalToHeptadeca(result) + "h");
		return dummy;
	}

	public boolean equals(Heptadeca heptadeca)
	{
		if (heptadeca.number.equals(this.number)) {
			return true;
		}
		return false;
	}

	public String toString()
	{
		if (!number.equals("")) {
			if (sign == -1) {
				return "-" + number + "h";
			}
			return number + "h";
		}
		if (decimal != 0) {
			return decimalToHeptadeca(decimal) + "h";
		}
		return "No number set";
	}
}