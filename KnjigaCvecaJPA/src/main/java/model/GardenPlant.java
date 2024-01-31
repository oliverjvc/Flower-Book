package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the garden_plants database table.
 * 
 */
@Entity
@Table(name="garden_plants")
@NamedQuery(name="GardenPlant.findAll", query="SELECT g FROM GardenPlant g")
public class GardenPlant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="garden_plant_id")
	private int gardenPlantId;

	//bi-directional many-to-one association to Garden
	@ManyToOne
	@JoinColumn(name="garden_id")
	private Garden garden;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public GardenPlant() {
	}

	public int getGardenPlantId() {
		return this.gardenPlantId;
	}

	public void setGardenPlantId(int gardenPlantId) {
		this.gardenPlantId = gardenPlantId;
	}

	public Garden getGarden() {
		return this.garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}