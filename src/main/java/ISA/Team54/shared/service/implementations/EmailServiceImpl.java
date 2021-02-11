package ISA.Team54.shared.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ISA.Team54.shared.model.EmailForm;
import ISA.Team54.shared.service.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;
	@Async
	public void sendEmail(String sendTo, String subject, String text) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(sendTo);
		msg.setFrom(env.getProperty("spring.mail.username"));
		msg.setSubject(subject);
		msg.setText(text);
		javaMailSender.send(msg);
		System.out.println("Email sent.");
	}
}
