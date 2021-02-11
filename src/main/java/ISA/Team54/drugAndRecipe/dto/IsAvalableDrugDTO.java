package ISA.Team54.drugAndRecipe.dto;

import java.util.ArrayList;
import java.util.List;

public class IsAvalableDrugDTO {
	private boolean isAvailable;
	private List<DrugDTO> drugsDTO = new ArrayList<DrugDTO>();
	
	public IsAvalableDrugDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IsAvalableDrugDTO(boolean isAvailable, List<DrugDTO> drugsDTO) {
		super();
		this.isAvailable = isAvailable;
		this.drugsDTO = drugsDTO;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<DrugDTO> getDrugsDTO() {
		return drugsDTO;
	}

	public void setDrugsDTO(List<DrugDTO> drugsDTO) {
		this.drugsDTO = drugsDTO;
	}
	
	
	
}
