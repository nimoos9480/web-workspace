package member.vo;

public class StudentVO {
	private int studentNumber;
	private String studentName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	public StudentVO() {}
	public StudentVO(int studentNumber, String studentName, int koreanScore, int englishScore, int mathScore) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

}
