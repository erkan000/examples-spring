package start;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import pojo.Person;

public class BasicExpressionParser {
	
	public static void main(String[] args) {
		
//		System.setProperty("user.language", "fr");
//		System.setProperty("user.country", "fr");
//		System.setProperty("user.timezone", "Europe/Istanbul");
		
		SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("'Hello World'");
        String message = (String) exp1.getValue();
        System.out.println(message);
        
        Expression exp2 = parser.parseExpression("'Hello World'.length()");
        System.out.println(exp2.getValue());

        Expression exp3 = parser.parseExpression("'Hello World'.length() * 5");
        System.out.println(exp3.getValue());

        Expression exp4 = parser.parseExpression("'Hello World'.length() > 5");
        System.out.println(exp4.getValue());

        Expression exp5 = parser.parseExpression("'Hello World'.length() > 5 and 'Hello World'.length() < 15");
        System.out.println(exp5.getValue());

        StandardEvaluationContext ec1 = new StandardEvaluationContext();
        ec1.setVariable("var","Hello USA");
        String msg = (String) parser.parseExpression("#var.substring(6)").getValue(ec1);
        System.out.println(msg);

        StandardEvaluationContext ec2 = new StandardEvaluationContext();
        ec2.setVariable("var","Hello UK");
        String msg2 = (String) parser.parseExpression("#var.substring(6)").getValue(ec2);
        System.out.println(msg2);
        System.out.println("-----");

        Person person = new Person();
        StandardEvaluationContext userContext = new StandardEvaluationContext(person);

        parser.parseExpression("country").setValue(userContext,"USA");
        System.out.println(person.getCountry());

        parser.parseExpression("language").setValue(userContext,"en");
        System.out.println(person.getLanguage());

        parser.parseExpression("timeZone").setValue(userContext,"America/New_York");
        System.out.println(person.getTimeZone());
        System.out.println("------");

        StandardEvaluationContext propsContext = new StandardEvaluationContext();
        propsContext.setVariable("systemProperties",System.getProperties());
        Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
        parser.parseExpression("country").setValue(userContext,expCountry.getValue(propsContext));
        System.out.println(person.getCountry());

        Expression expLanguage = parser.parseExpression("#systemProperties['user.language']");
        parser.parseExpression("language").setValue(userContext,expLanguage.getValue(propsContext));
        System.out.println(person.getLanguage());

        Expression expTimeZone = parser.parseExpression("#systemProperties['user.timezone']");
        parser.parseExpression("timeZone").setValue(userContext,expTimeZone.getValue(propsContext));
        System.out.println(person.getTimeZone());
	}

}
