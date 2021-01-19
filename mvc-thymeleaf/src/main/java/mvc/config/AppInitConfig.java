package mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}	
	
	// H2 Database Interface Start-up
	// http://localhost:8080/mvc/console/
	
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		ServletRegistration.Dynamic sevlet = servletContext.addServlet("h2-console", new WebServlet());
//		sevlet.setLoadOnStartup(2);
//		sevlet.addMapping("/console/*");
//		System.out.println("H2 interface started ! ------------------");
//		
//	}

}
