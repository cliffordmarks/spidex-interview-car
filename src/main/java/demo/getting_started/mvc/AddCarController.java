package demo.getting_started.mvc;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;

import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.Textbox;

import demo.getting_started.tutorial.Car;
import demo.getting_started.tutorial.Car.COLOUR_TYPES;
import demo.getting_started.tutorial.CarService;
import demo.getting_started.tutorial.CarServiceImpl;

public class AddCarController extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Selectbox colourSelectbox;
	private ListModel<COLOUR_TYPES> coloursModel;
	@Wire
	private Textbox tbModel;
	@Wire
	private Textbox tbMake;
	@Wire
	private Textbox tbDescription;
	@Wire
	private Textbox tbPreview;
	@Wire
	private Intbox tbPrice;

	private CarService carService = new CarServiceImpl();
	private COLOUR_TYPES colourSelected;

	private Listbox param;
	
	
	/**
	 * Default constructor
	 */
	public AddCarController() {
		COLOUR_TYPES[] arrayOfColours = COLOUR_TYPES.values();
		List<COLOUR_TYPES> listOfColourTypes = Arrays.asList(arrayOfColours);
		coloursModel = new ListModelList<COLOUR_TYPES>(listOfColourTypes);
		 
		colourSelected = COLOUR_TYPES.getDefaultColour();
	}
	
	public void setParam(Listbox param) {
		this.param = param;
	}
	
	public Listbox getParam() {
		return param;
	}
	
	
	public ListModel<COLOUR_TYPES> getColoursModel() {
		return coloursModel;
	}
	
	public void setColoursModel(ListModel<COLOUR_TYPES> model) {
		coloursModel = model;
	}
	
	
	@Listen("onClick = #saveCarButton")
	public void addCar() {
		//car = new Car();
		String model = tbModel.getValue();
		String make = tbMake.getValue();
		String description = tbDescription.getValue();
		String preview = tbPreview.getValue();
		Integer price = tbPrice.getValue();
		
		Car car = new Car(null, model, make, description, preview, price, colourSelected);
		carService.save(car);
	}

	@Listen("onSelect = #colourSelectbox")
	public void changeColour() {
	    Set<COLOUR_TYPES> types = ((ListModelList<COLOUR_TYPES>)coloursModel).getSelection();
	    COLOUR_TYPES type = types.iterator().next();
	    colourSelected = type;
	}

}
