import java.util.Arrays;

public class TestMyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.add("Nate");
		list.add("Peter");
		list.add("Stewie");
		list.add("Lois");
		list.add("Brian");
		list.add("Chris");
		list.add("Meg");
		System.out.println("Full list: " + list.toString());
		
		System.out.println("----------");
		
		list.remove(0);
		System.out.println("remove(0): " + list.toString());
		
		System.out.println("----------");

		System.out.println("get(2): " + list.get(2));
		System.out.println("getNodeAt(2): " + list.getNodeAt(2));
		System.out.println("IndexOf(Lois): " + list.indexOf("Lois"));
		System.out.println("lastIndexOf(Brian): " + list.lastIndexOf("Brian"));

		System.out.println("----------");

		System.out.println("contains(Meg): " + list.contains("Meg"));
		System.out.println("remove(Meg): " + list.remove("Meg"));
		System.out.println("contains(Meg): " + list.contains("Meg"));
		list.add(2, "Greased Up Deaf Guy");
		
		System.out.println("----------");

		
		System.out.println("toArray(): " + Arrays.toString(list.toArray()));
	}
}