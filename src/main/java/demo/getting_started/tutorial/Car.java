package demo.getting_started.tutorial;

public class Car {

	private Integer id;
	private String model;
	private String make;
	private String preview;
	private String description;
	private Integer price;
	public enum COLOUR_TYPES {red(""), yellow(""), green(""), white(""), black(""); 
	
		private String value;
		
		COLOUR_TYPES(String value) {
			this.value = value;
		}
		public static COLOUR_TYPES getColourType(String value) {
			COLOUR_TYPES defaultColour = white;
			for(COLOUR_TYPES type : COLOUR_TYPES.values()) {
				if(type.getValue().equalsIgnoreCase(value))
					return type;
			}
			return defaultColour;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public static COLOUR_TYPES getDefaultColour() {
			return white;
		}
	};
	private COLOUR_TYPES colour;

	public Car() {
	}

	public Car(Integer id, String model, String make, String description, String preview, Integer price, COLOUR_TYPES colour) {
		this.id = id;
		this.model = model;
		this.make = make;
		this.preview = preview;
		this.description = description;
		this.price = price;
		this.colour = colour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public COLOUR_TYPES getColour() {
		return colour;
	}
	public void setColour(COLOUR_TYPES colour) {
		this.colour = colour;
	}

}
