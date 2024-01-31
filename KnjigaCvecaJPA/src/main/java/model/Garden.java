package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the gardens database table.
 * 
 */
@Entity
@Table(name="gardens")
@NamedQuery(name="Garden.findAll", query="SELECT g FROM Garden g")
public class Garden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="garden_id")
	private int gardenId;

	@Column(name="garden_name")
	private String gardenName;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to GardenPlant
	@OneToMany(mappedBy="garden")
	private List<GardenPlant> gardenPlants;

	public Garden() {
	}

	public int getGardenId() {
		return this.gardenId;
	}

	public void setGardenId(int gardenId) {
		this.gardenId = gardenId;
	}

	public String getGardenName() {
		return this.gardenName;
	}

	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<GardenPlant> getGardenPlants() {
		return this.gardenPlants;
	}

	public void setGardenPlants(List<GardenPlant> gardenPlants) {
		this.gardenPlants = gardenPlants;
	}

	public GardenPlant addGardenPlant(GardenPlant gardenPlant) {
		getGardenPlants().add(gardenPlant);
		gardenPlant.setGarden(this);

		return gardenPlant;
	}

	public GardenPlant removeGardenPlant(GardenPlant gardenPlant) {
		getGardenPlants().remove(gardenPlant);
		gardenPlant.setGarden(null);

		return gardenPlant;
	}

}