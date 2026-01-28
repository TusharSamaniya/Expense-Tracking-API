package com.tushar.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data                   
@NoArgsConstructor      
@AllArgsConstructor     
@Builder  
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserType userType;
	
	@Column(name = "tenant_id")
	private Long tenantId;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	public enum UserType{
		INDIVIDUAL,
	    FREELANCER,
	    COMPANY_ADMIN
	}

}
