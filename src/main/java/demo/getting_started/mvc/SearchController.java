package demo.getting_started.mvc;


import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CreateEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import demo.getting_started.tutorial.Car;
import demo.getting_started.tutorial.CarService;
import demo.getting_started.tutorial.CarServiceImpl;
import demo.getting_started.tutorial.Car.COLOUR_TYPES;

public class SearchController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox carListbox;
	@Wire
	private Label modelLabel;
	@Wire
	private Label makeLabel;
	@Wire
	private Label priceLabel;
	@Wire
	private Label descriptionLabel;
	@Wire
	private Image previewImage;
	@Wire
	private Component detailBox;

	private CarService carService = new CarServiceImpl();
	
	/**
	 * Life cycle method that will call search method to prepopulate the car list when the window loads. 
	 */
	public void doAfterCompose(Component component) throws Exception {
		super.doAfterCompose(component);
		search();
	}
	//access http://localhost:8080/demo.zul, use chrome

	@Listen("onClick = #searchButton")
	public void search() {
		String keyword = keywordBox.getValue();
		List<Car> result = carService.search(keyword);
		
		carListbox.setModel(new ListModelList<Car>(result)); 
	}
	
	@Listen("onSelect = #carListbox")
	public void showDetail(){
		//TODO: if(list has items then do then show details)
		detailBox.setVisible(true);
		
		Set<Car> selection = ((Selectable<Car>)carListbox.getModel()).getSelection();
		if (selection!=null && !selection.isEmpty()){
			Car selected = selection.iterator().next();
			previewImage.setSrc(selected.getPreview());
			modelLabel.setValue(selected.getModel());
			makeLabel.setValue(selected.getMake());
			priceLabel.setValue(selected.getPrice().toString());
			descriptionLabel.setValue(selected.getDescription());
		}
	}
	
	 public void onCreate(CreateEvent ev){
		 int i = 0;
	 }
}
