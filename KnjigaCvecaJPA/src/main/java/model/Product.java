package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	private Object description;

	@Column(name="image_url")
	private String imageUrl;

	private String name;

	private BigDecimal price;

	//bi-directional many-to-one association to CareInstruction
	@OneToMany(mappedBy="product")
	private List<CareInstruction> careInstructions;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	private List<Comment> comments;

	//bi-directional many-to-one association to GardenPlant
	@OneToMany(mappedBy="product")
	private List<GardenPlant> gardenPlants;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<CareInstruction> getCareInstructions() {
		return this.careInstructions;
	}

	public void setCareInstructions(List<CareInstruction> careInstructions) {
		this.careInstructions = careInstructions;
	}

	public CareInstruction addCareInstruction(CareInstruction careInstruction) {
		getCareInstructions().add(careInstruction);
		careInstruction.setProduct(this);

		return careInstruction;
	}

	public CareInstruction removeCareInstruction(CareInstruction careInstruction) {
		getCareInstructions().remove(careInstruction);
		careInstruction.setProduct(null);

		return careInstruction;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}

	public List<GardenPlant> getGardenPlants() {
		return this.gardenPlants;
	}

	public void setGardenPlants(List<GardenPlant> gardenPlants) {
		this.gardenPlants = gardenPlants;
	}

	public GardenPlant addGardenPlant(GardenPlant gardenPlant) {
		getGardenPlants().add(gardenPlant);
		gardenPlant.setProduct(this);

		return gardenPlant;
	}

	public GardenPlant removeGardenPlant(GardenPlant gardenPlant) {
		getGardenPlants().remove(gardenPlant);
		gardenPlant.setProduct(null);

		return gardenPlant;
	}

}