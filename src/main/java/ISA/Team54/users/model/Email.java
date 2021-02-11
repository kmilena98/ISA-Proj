package ISA.Team54.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Embeddable
public class Email {
	
	private String email;

	public Email(String email) {
		super();
		this.email = email;
		Validate();
	}

	private boolean Validate() {
		/*try {
			if(email == null) {
				throw new ValidationExeption("Email cant be null",error);
			} else if(email.equals("")) {
				throw new ValidationExeption("Email cant be empty");
			} 
		} catch(Exception err) {
			
		}		 */		
		return true;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
