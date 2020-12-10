package pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean, DisposableBean{

	private int id;
	private String name;

	public Person() {
		System.out.println("Person no-arg constructor");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("Person setApplicationContext");		
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		System.out.println("Person setBeanClassLoader");		
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Person setBeanFactory");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Person setBeanName");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Person destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person afterPropertiesSet");
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Person object name setted to:" + name);
	}

}
