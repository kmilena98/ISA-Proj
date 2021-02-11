package ISA.Team54.loyalty.model;

import javax.persistence.Embeddable;

@Embeddable
public class LoyaltyCategoryIntertval {
	private int upper;
	private int lower;
	
	public LoyaltyCategoryIntertval(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}

	public LoyaltyCategoryIntertval() {
		super();
	}	
}
