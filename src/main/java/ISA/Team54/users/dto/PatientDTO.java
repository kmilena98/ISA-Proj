package ISA.Team54.users.dto;

public class PatientDTO {
	private int id;
	private String Name;
	private String Surname;
	
	
	public PatientDTO() {
		super();
	}

	public PatientDTO(int id,String name, String surname) {
		super();
		this.id = id;
		Name = name;
		Surname = surname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
