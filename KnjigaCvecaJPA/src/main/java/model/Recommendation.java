package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the recommendations database table.
 * 
 */
@Entity
@Table(name="recommendations")
@NamedQuery(name="Recommendation.findAll", query="SELECT r FROM Recommendation r")
public class Recommendation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recommendation_id")
	private int recommendationId;

	@Column(name="recommendation_text")
	private String recommendationText;

	private Timestamp timestamp;

	@Column(name="user_id")
	private int userId;

	public Recommendation() {
	}

	public int getRecommendationId() {
		return this.recommendationId;
	}

	public void setRecommendationId(int recommendationId) {
		this.recommendationId = recommendationId;
	}

	public String getRecommendationText() {
		return this.recommendationText;
	}

	public void setRecommendationText(String recommendationText) {
		this.recommendationText = recommendationText;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}