package ISA.Team54.shared.model;

public class EmailForm {
	private String sendTo;
	private String subject;
	private String text;
	public EmailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailForm(String sendTo, String subject, String text) {
		super();
		this.sendTo = sendTo;
		this.subject = subject;
		this.text = text;
	}
	
	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
