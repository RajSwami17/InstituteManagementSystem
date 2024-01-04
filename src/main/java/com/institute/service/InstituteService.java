package com.institute.service;

import java.util.List;

import com.institute.entity.Institute;

public interface InstituteService 
{
	//To Register Institute Details
	Institute registerInstitute(Institute institute);
	
	//To Update Registered Institute Details
    Institute modifyInstitute(Long id, Institute updatedInstitute);
    
    //To Get Institute Details By Their Id
    Institute getInstituteById(Long id);
    
    //To Get all Institute Details Who Registered.
    List<Institute> getAllInstitutes();
    
    //To Delete Registered Institute Details By Id
    void deleteInstituteById(Long id); 
}
