package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cargo {
	
	@Value("#{cargo.locationsByCountry[user.country]}")
    private List<City> shippingLocations;
	
    @Value("#{cargo.shippingLocations.?[isCapital != true]}")
    private List<City> nonCapitalShippingLocations;
    
    @Value("#{(cargo.locationsByCountry.?[key=='UK' or key=='TR' or key=='DE'])}")
    private Map<String,List<City>> westernShippingLocations;
    
    @Value("#{cargo.shippingLocations.?[shipping<10].size()}")
    private Integer noOfCheapShippingLocations;
    
    private Map<String, List<City>> locationsByCountry;
    private Map<String, List<City>> chargesByLocation;

	public List<City> getShippingLocations() {
		return shippingLocations;
	}
	
	public Cargo() {
		List<City> trCities = new ArrayList<>();
        trCities.add(new City("Ankara",2.50,true));
        trCities.add(new City("İstanbul",1.50,false));
        trCities.add(new City("İzmir",6.50,false));

        List<City> ukCities = new ArrayList<>();
        ukCities.add(new City("London",12.50,true));
        ukCities.add(new City("Cambridge",3.00,false));

        List<City> deCities = new ArrayList<>();
        deCities.add(new City("Hamburg",6.4,true));
        deCities.add(new City("Berlin",11.99,false));
        deCities.add(new City("Cologne",16.57,false));
        
		this.locationsByCountry = new HashMap<>();
        this.locationsByCountry.put("TR",trCities);
        this.locationsByCountry.put("UK",ukCities);
        this.locationsByCountry.put("DE",deCities);

        this.chargesByLocation = new HashMap<>();
        this.chargesByLocation.put("TR", trCities);
        this.chargesByLocation.put("UK", ukCities);
        this.chargesByLocation.put("DE", deCities);
	}

	public void setShippingLocations(List<City> shippingLocations) {
		this.shippingLocations = shippingLocations;
	}

	public List<City> getNonCapitalShippingLocations() {
		return nonCapitalShippingLocations;
	}

	public void setNonCapitalShippingLocations(List<City> nonCapitalShippingLocations) {
		this.nonCapitalShippingLocations = nonCapitalShippingLocations;
	}

	public Map<String, List<City>> getWesternShippingLocations() {
		return westernShippingLocations;
	}

	public void setWesternShippingLocations(Map<String, List<City>> westernShippingLocations) {
		this.westernShippingLocations = westernShippingLocations;
	}

	public Integer getNoOfCheapShippingLocations() {
		return noOfCheapShippingLocations;
	}

	public void setNoOfCheapShippingLocations(Integer noOfCheapShippingLocations) {
		this.noOfCheapShippingLocations = noOfCheapShippingLocations;
	}

	public Map<String, List<City>> getLocationsByCountry() {
		return locationsByCountry;
	}

	public void setLocationsByCountry(Map<String, List<City>> locationsByCountry) {
		this.locationsByCountry = locationsByCountry;
	}

	public Map<String, List<City>> getChargesByLocation() {
		return chargesByLocation;
	}

	public void setChargesByLocation(Map<String, List<City>> chargesByLocation) {
		this.chargesByLocation = chargesByLocation;
	}
    
}
