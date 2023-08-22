package common;
public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		
		InputStream stream = Resources.getResourceAsStream(resource);
		
		
	}
}
