public class HeptadecaDemo
{
	public static void main(String[] args)
	{
		Heptadeca heptadeca1 = new Heptadeca();
		Heptadeca heptadeca2 = new Heptadeca();
		heptadeca1.read();
		heptadeca2.read();
		Heptadeca heptadeca4, heptadeca5, heptadeca6, heptadeca7;
		Heptadeca heptadeca8 = new Heptadeca();
		heptadeca8.read();
		System.out.println ("Heptadeca  number heptadeca8: " + heptadeca8);
		System.out.println ("First Heptadeca  number: " + heptadeca1);
		System.out.println  ("Second Heptadeca  number: " + heptadeca2);
		if (heptadeca1.equals(heptadeca2))
			System.out.println ("heptadeca1 and heptadeca2 are equal.");
		else
			System.out.println ("heptadeca1 and heptadeca2 are NOT equal.");
		heptadeca4 = heptadeca1.add(heptadeca2);
		heptadeca5 = heptadeca1.subtract(heptadeca2);
		heptadeca6 = heptadeca1.multiply(heptadeca2);
		heptadeca7 = heptadeca1.divide(heptadeca2);
		System.out.println (heptadeca1 + " + " + heptadeca2 + " is: " + heptadeca4);
		System.out.println (heptadeca1 + " - " + heptadeca2 + " is: " + heptadeca5);
		System.out.println (heptadeca1 + " * " + heptadeca2 + " is: " + heptadeca6);
		System.out.println (heptadeca1 + " / " + heptadeca2 + " is: " + heptadeca7);
		System.out.println ();
		int number = 6;
	}
}