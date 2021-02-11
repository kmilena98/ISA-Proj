package ISA.Team54.drugAndRecipe.dto;

public class DrugDTO {
	private long id;
	private String code;
	private int loyalityPoints;
	private String name;
	public DrugDTO() {
		super();
	}
	public DrugDTO(long id,String code, int loyalityPoints, String name) {
		super();
		this.id = id;
		this.code = code;
		this.loyalityPoints = loyalityPoints;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLoyalityPoints() {
		return loyalityPoints;
	}
	public void setLoyalityPoints(int loyalityPoints) {
		this.loyalityPoints = loyalityPoints;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
