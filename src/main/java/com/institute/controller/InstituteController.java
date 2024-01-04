package com.institute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.entity.Institute;
import com.institute.service.InstituteService;

@RestController
@RequestMapping("/institute")
public class InstituteController 
{
	@Autowired
	private InstituteService instituteService;
	
	@PostMapping("/register")
	public ResponseEntity<Institute> regsiterInstitute(@RequestBody Institute institute)
	{
		Institute registeredInstitute = instituteService.registerInstitute(institute);
		return new ResponseEntity<>(registeredInstitute,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Institute> modifyInstitute(@PathVariable("id")Long id,@RequestBody Institute institute)
	{
		Institute updatedInstitute = instituteService.modifyInstitute(id, institute);
		return new ResponseEntity<>(updatedInstitute,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Institute> getInstituteById(@PathVariable("id")Long id)
	{
		Institute instituteById = instituteService.getInstituteById(id);
		return new ResponseEntity<>(instituteById,HttpStatus.OK);
	}
	
	@GetMapping("/allInstitutes")
	public ResponseEntity<List<Institute>> getAllInstitutes()
	{
		List<Institute> allInstituteList = instituteService.getAllInstitutes();
		return new ResponseEntity<>(allInstituteList,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInstituteById(@PathVariable("id")Long id)
	{
		instituteService.deleteInstituteById(id);
		return ResponseEntity.noContent().build();
	}
}
