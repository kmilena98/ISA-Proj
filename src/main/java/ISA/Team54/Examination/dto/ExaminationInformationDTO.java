package ISA.Team54.Examination.dto;

import java.util.List;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;

public class ExaminationInformationDTO {
	public Long id;
	public int therapyDuration;
	public String diagnosis;
	public List<DrugDTO> drugs;
	
	public ExaminationInformationDTO() {
		super();
	}

	public ExaminationInformationDTO(Long id, int therapyDuration, String diagnosis, List<DrugDTO> drugs) {
		super();
		this.id = id;
		this.therapyDuration = therapyDuration;
		this.diagnosis = diagnosis;
		this.drugs = drugs;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<DrugDTO> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<DrugDTO> drugs) {
		this.drugs = drugs;
	}

	public int getTherapyDuration() {
		return therapyDuration;
	}

	public void setTherapyDuration(int therapyDuration) {
		this.therapyDuration = therapyDuration;
	}

	
}

