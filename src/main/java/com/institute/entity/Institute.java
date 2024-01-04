package com.institute.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Institute_Details")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institute 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Institute_Id")
	private Long id;
	
	@Column(name="Institute_Name")
	private String name;
	
	@Column(name="Institute_Location")
	private String location;
	
	@Column(name="Institute_Email")
	private String email;
	
	@Column(name="Institute_Contact")
	private Long contactNumber;
}
