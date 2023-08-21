package servlet.model.vo;

public class MemberDTO {
	private String id;
	private String pasword;
	private String name;
	private String address;
	
	public MemberDTO() {}
	public MemberDTO(String id, String pasword, String name, String address) {

		this.id = id;
		this.pasword = pasword;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pasword=" + pasword + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}
