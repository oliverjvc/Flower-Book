package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the care_instructions database table.
 * 
 */
@Entity
@Table(name="care_instructions")
@NamedQuery(name="CareInstruction.findAll", query="SELECT c FROM CareInstruction c")
public class CareInstruction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instruction_id")
	private int instructionId;

	@Column(name="indoor_outdoor")
	private Object indoorOutdoor;

	private String season;

	@Column(name="soil_type")
	private String soilType;

	@Column(name="spraying_frequency")
	private int sprayingFrequency;

	@Column(name="sunlight_requirements")
	private String sunlightRequirements;

	@Column(name="watering_frequency")
	private int wateringFrequency;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public CareInstruction() {
	}

	public int getInstructionId() {
		return this.instructionId;
	}

	public void setInstructionId(int instructionId) {
		this.instructionId = instructionId;
	}

	public Object getIndoorOutdoor() {
		return this.indoorOutdoor;
	}

	public void setIndoorOutdoor(Object indoorOutdoor) {
		this.indoorOutdoor = indoorOutdoor;
	}

	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSoilType() {
		return this.soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	public int getSprayingFrequency() {
		return this.sprayingFrequency;
	}

	public void setSprayingFrequency(int sprayingFrequency) {
		this.sprayingFrequency = sprayingFrequency;
	}

	public String getSunlightRequirements() {
		return this.sunlightRequirements;
	}

	public void setSunlightRequirements(String sunlightRequirements) {
		this.sunlightRequirements = sunlightRequirements;
	}

	public int getWateringFrequency() {
		return this.wateringFrequency;
	}

	public void setWateringFrequency(int wateringFrequency) {
		this.wateringFrequency = wateringFrequency;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}