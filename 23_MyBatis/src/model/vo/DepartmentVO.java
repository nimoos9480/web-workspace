package model.vo;

public class DepartmentVO {
	private String deparmentNo;
	private String departmentName;
	private String category;

	
	public DepartmentVO() {}


	public DepartmentVO(String deparmentNo, String departmentName, String category) {
		this.deparmentNo = deparmentNo;
		this.departmentName = departmentName;
		this.category = category;
	}


	public String getDeparmentNo() {
		return deparmentNo;
	}


	public void setDeparmentNo(String deparmentNo) {
		this.deparmentNo = deparmentNo;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "DepartmentVO [deparmentNo=" + deparmentNo + ", departmentName=" + departmentName + ", category="
				+ category + "]";
	}


	
	
}
