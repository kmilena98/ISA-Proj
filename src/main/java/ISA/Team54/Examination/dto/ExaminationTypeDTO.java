package ISA.Team54.Examination.dto;

import ISA.Team54.Examination.enums.ExaminationType;

public class ExaminationTypeDTO {
	
	private ExaminationType type;

	public ExaminationTypeDTO() {
		super();
	}

	public ExaminationTypeDTO(ExaminationType type) {
		super();
		this.type = type;
	}

	public ExaminationType getType() {
		return type;
	}

	public void setType(ExaminationType type) {
		this.type = type;
	}

}
