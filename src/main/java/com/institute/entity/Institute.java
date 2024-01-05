package com.institute.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message = "Institute name cannot be blank")
    @Size(max = 255, message = "Institute name cannot exceed 255 characters")
	@Column(name="Institute_Name")
	private String name;
	
	@NotBlank(message = "Institute location cannot be blank")
    @Size(max = 255, message = "Institute location cannot exceed 255 characters")
	@Column(name="Institute_Location")
	private String location;
	
	@Email(message = "Invalid email format")
    @NotBlank(message = "Institute email cannot be blank")
    @Size(max = 255, message = "Institute email cannot exceed 255 characters")
	@Column(name="Institute_Email")
	private String email;
	
	@NotNull(message = "Contact number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid contact number format")
	@Column(name="Institute_Contact")
	private Long contactNumber;
}
