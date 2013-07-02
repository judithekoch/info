package areas;


public class Square implements Squares {

	float width;	
	
	public Square(float width) {
		this.width = width;
	}

	@Override
	public float getArea() {
		return width * width;
		
	}
	
	
	

}
