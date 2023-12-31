package controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;  // false가 기본값
	
	public ModelAndView() {}
	public ModelAndView(String path) { // path만 보낼 땐 forward 방식
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) { // isRedirect 보낼 땐 sendRedirect! true 같이 넘겨서
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
}
