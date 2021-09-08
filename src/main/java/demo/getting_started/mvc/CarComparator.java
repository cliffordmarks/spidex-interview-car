package demo.getting_started.mvc;

import java.util.Comparator;

import demo.getting_started.tutorial.Car;

public class CarComparator implements Comparator<Car> {

	private String field;
	private boolean sortAscending;
	
	public static final String MAKE_FEILD = "MAKE";
	public static final String MODEL_FEILD = "MODEL";
	public static final String PRICE_FEILD = "PRICE";
	public static final String COLOUR_FEILD = "COLOUR";
	
	public CarComparator(String field, boolean sortAscending) {
		this.field = field;
		this.sortAscending = sortAscending;
	}
	
	@Override
	public int compare(Car car1, Car car2) {
		
		int result = -1;
		
		if(field.equalsIgnoreCase(MAKE_FEILD)) {
			result = car1.getMake().compareTo(car2.getMake());
		}
		else if(field.equalsIgnoreCase(MODEL_FEILD)) {
			result = car1.getModel().compareTo(car2.getMake());
		}
		else if(field.equalsIgnoreCase(PRICE_FEILD)) {
			result = car1.getPrice().compareTo(car2.getPrice());
		}
		//TODO://step through code to check colour comparator, need to compare them as strings
		//declaring a private value/description variable and constructor accepting a param to populate the variable
		
		else if(field.equalsIgnoreCase(COLOUR_FEILD)) {
			result = car1.getColour().compareTo(car2.getColour());
		}
		
		result = sortAscending ?  result * 1 : result * -1;
			
		return result;
	}

}
