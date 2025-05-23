package namedEntity;


/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
    String name;
    String category; // Clase principal (ej: persona, lugar, organización)
    String subcategory; // Subclase (ej: apellido, ciudad, país)
    String topic; // Tema (ej: deportes, cultura)
    int frequency;
	
    public NamedEntity(String name, String category, String subcategory, String topic, int frequency) {
		super();
		this.name = name;
		this.category = category;
		this.frequency = frequency;
	    this.subcategory = subcategory;
        this.topic = topic;
        this.frequency = frequency;
	}

    // Constructor para compatibilidad
    public NamedEntity(String name, String category, int frequency) {
        this(name, category, null, null, frequency);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSubcategory() { return subcategory; }
    public void setSubcategory(String subcategory) { this.subcategory = subcategory; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public int getFrequency() { return frequency; }
    public void setFrequency(int frequency) { this.frequency = frequency; }
    public void incFrequency() { this.frequency++; }

	@Override
	public String toString() {
		return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + "]";
	}
	public void prettyPrint(){
		System.out.println(this.getName() + " " + this.getFrequency());
	}
}



