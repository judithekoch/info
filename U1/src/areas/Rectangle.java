package areas;



public class Rectangle extends Square implements Rectangles {
		
	float height;
	
	public Rectangle(float width, float height) {
		super(width);
		this.height = height;
	}
	@Override
	public float getArea(){
		return width * height;
	}
	
}
