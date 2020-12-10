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

public class PersonDetail implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean, DisposableBean{
	
		private Person person;
		
		public PersonDetail() {
			System.out.println("PersonDetail no-arg constructor");
		}
		
		public PersonDetail(Person p) {
			System.out.println("*** PersonDetail constructor injection");
		}
		
		public Person getPerson() {
			return person;
		}
		
		public void setPerson(Person person) {
			this.person = person;
			System.out.println("*** PersonDetail setter injection");
		}
		
		@Override
		public void setApplicationContext(ApplicationContext arg0) throws BeansException {
			System.out.println("Person Detail setApplicationContext");		
		}

		@Override
		public void setBeanClassLoader(ClassLoader arg0) {
			System.out.println("Person Detail setBeanClassLoader");		
		}

		@Override
		public void setBeanFactory(BeanFactory arg0) throws BeansException {
			System.out.println("Person Detail setBeanFactory");
		}

		@Override
		public void setBeanName(String arg0) {
			System.out.println("Person Detail setBeanName");
		}
		
		@Override
		public void destroy() throws Exception {
			System.out.println("Person Detail destroy");
		}

		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("Person Detail afterPropertiesSet");
		}

}
