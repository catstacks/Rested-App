package com.qa.rested.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "water", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "user_id"})
)
public class Water {
	
	public enum ServingSize {
		
		CENTILITRE(1), FL_OZ(3), CUP(25), LITRE(100), CUSTOM(0);

        private double value;

        ServingSize(final double value) {
            this.value = value;
        }
		
        public static ServingSize fromValue(final double value) {
            ServingSize match = null;
            for (final ServingSize servingType : ServingSize.values()) {
                if (servingType.getValue() == value) {
                    match = servingType;
                }
            }
            return match;
        }
        
        public static ServingSize fromString(final String str) {
            ServingSize match = null;
            for (final ServingSize servingSize : ServingSize.values()) {
                if (servingSize.toString().equalsIgnoreCase(str)) {
                    match = servingSize;
                }
            }
            return match;
        }

        public final double getValue() {
            return this.value;
        }


	}
	
	@Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private RestedUser user;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "default_serving", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private ServingSize defaultServing;

    @Column(name = "serving_size_amount", nullable = false)
    private Double servingSizeAmount;

	public Water(UUID id, RestedUser user, String name, ServingSize defaultServing, Double servingSizeAmount) {
		this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
		this.user = user;
		this.name = name;
		this.defaultServing = defaultServing;
		this.servingSizeAmount = servingSizeAmount;
	}
    
	public Water() {
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public RestedUser getUser() {
		return user;
	}

	public void setUser(RestedUser user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServingSize getDefaultServing() {
		return defaultServing;
	}

	public void setDefaultServing(ServingSize defaultServing) {
		this.defaultServing = defaultServing;
	}

	public Double getServingSizeAmount() {
		return servingSizeAmount;
	}

	public void setServingSizeAmount(Double servingSizeAmount) {
		this.servingSizeAmount = servingSizeAmount;
	}
    
	


}
