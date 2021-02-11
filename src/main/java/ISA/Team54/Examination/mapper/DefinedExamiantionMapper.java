package ISA.Team54.Examination.mapper;

import ISA.Team54.Examination.dto.DefinedExaminationDTO;
import ISA.Team54.Examination.model.Examination;

public class DefinedExamiantionMapper {

	public DefinedExaminationDTO examinationToDefinedExaminationDTO(Examination examination) {
		return new DefinedExaminationDTO(examination.getId(),examination.getTerm().getStart(),examination.getPrice());
	}
}
