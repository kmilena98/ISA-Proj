package ISA.Team54.users.dto;

import java.util.Date;

public class DermatologistPatientDTO extends PatientDTO {
	private Date term;

	public DermatologistPatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DermatologistPatientDTO(int id,String name, String surname,Date term) {
		super(id, name, surname);
		this.term = term;
		// TODO Auto-generated constructor stub
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}	
}
