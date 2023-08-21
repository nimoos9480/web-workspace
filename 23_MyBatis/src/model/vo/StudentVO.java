package model.vo;

public class StudentVO {
	private String studentNO;
	private String studentName;
	private String studentAddress;
	
	private DepartmentVO department; // departmentVO 전부를 담아옴
	
	public StudentVO() {}

	public StudentVO(String studentNO, String studentName, String studentAddress, DepartmentVO department) {
		this.studentNO = studentNO;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.department = department;
	}

	public String getStudentNO() {
		return studentNO;
	}

	public void setStudentNO(String studentNO) {
		this.studentNO = studentNO;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "StudentVO [studentNO=" + studentNO + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", department=" + department + "]";
	}

	

	
}
