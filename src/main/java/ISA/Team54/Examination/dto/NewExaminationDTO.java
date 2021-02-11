package ISA.Team54.Examination.dto;

public class NewExaminationDTO {
	private long currentExaminationId;
	private long newExaminationId;
	
	public NewExaminationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NewExaminationDTO(long currentExaminationId, long newExaminationId) {
		super();
		this.currentExaminationId = currentExaminationId;
		this.newExaminationId = newExaminationId;
	}

	public long getCurrentExaminationId() {
		return currentExaminationId;
	}
	public void setCurrentExaminationId(long currentExaminationId) {
		this.currentExaminationId = currentExaminationId;
	}
	public long getNewExaminationId() {
		return newExaminationId;
	}
	public void setNewExaminationId(long newExaminationId) {
		this.newExaminationId = newExaminationId;
	}
}
