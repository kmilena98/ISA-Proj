package ISA.Team54.shared.service.interfaces;

import ISA.Team54.shared.model.EmailForm;

public interface EmailService {
	void sendEmail(String sendTo, String subject, String text) ;
}
