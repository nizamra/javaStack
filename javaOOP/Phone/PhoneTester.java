public class PhoneTester {
	public static void main (String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "verizon", "ring ding ming!");
		IPhone iphoneTen = new IPhone("X", 100, "AT&T", "Zingggg");
		
		s9.displayInfo();
		System.out.println();
		System.out.println(s9.ring());
		System.out.println();
		System.out.println(s9.unlock());
		System.out.println();
		
		
		
		iphoneTen.displayInfo();
		System.out.println();
		System.out.println(iphoneTen.ring());
		System.out.println();
		System.out.println(iphoneTen.unlock());
		System.out.println();
	}

}
