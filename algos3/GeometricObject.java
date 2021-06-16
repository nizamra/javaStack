import java.util.Date;
public class GeometricObject{
	protected String color;
	protected boolean filled;
	protected Date dateCreated;
	
	public GeometricObject() {
		
	}
	public GeometricObject(String color, boolean filled) {
		super();
		this.color = color;
		this.filled = filled;		
	}
	
	
	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Date getDate() {
		return dateCreated;
	}
	
	
	
	
}