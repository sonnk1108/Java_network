package model;

public class Answer {
	private Student student;
	private boolean alreadyRegistration;
	static final long serialVersionUID = 2L;

	public Answer(Student student, boolean alreadyRegistration) {
		super();
		this.student = student;
		this.alreadyRegistration = alreadyRegistration;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public boolean isAlreadyRegistration() {
		return alreadyRegistration;
	}
	public void setAlreadyRegistration(boolean alreadyRegistration) {
		this.alreadyRegistration = alreadyRegistration;
	}

}
