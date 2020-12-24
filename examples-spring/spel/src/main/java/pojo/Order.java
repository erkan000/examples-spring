package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
	
	@Value("#{5.32 + 10.11 + 32.01}")
    private double price;
	
    @Value("#{order.price >= 6 ? order.price * 15 / 100 : 0}")
    private double discount;
    
    @Value("#{user.country == 'TR' ? 1 : 8}")
    private int days;
    
    @Value("#{user.country}")
    private String origin;
    
    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.price)}")
    private String formattedProperty;
    
    @Value("#{user.name} order price is #{order.formattedProperty} and 15% discount : #{order.price - order.discount}")
    private String summary;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getFormattedProperty() {
		return formattedProperty;
	}

	public void setFormattedProperty(String formattedProperty) {
		this.formattedProperty = formattedProperty;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
