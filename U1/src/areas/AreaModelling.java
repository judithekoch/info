package areas;


public class AreaModelling {
	
	static Rectangles r1 = new Rectangle(40, 50);
	static Rectangles r2 = new Rectangle(30, 50);
	static Rectangles q1 = new Square(35);
	static Rectangles q2 = new Square(60);
	
	public static void main(String[] args) {
		getAreas();

		
	}		
	
	public static void getAreas(){
		System.out.println(r1.getArea());
		System.out.println(r2.getArea());
		System.out.println(q1.getArea());
		System.out.println(q2.getArea());
	}

	}
