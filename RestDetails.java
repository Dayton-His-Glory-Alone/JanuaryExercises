
public class RestDetails {

	public String name;
	public String price;
	public String category;
	
	public RestDetails() {
		
		
	}
	
	public RestDetails(String name, String price, String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
