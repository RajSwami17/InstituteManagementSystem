package com.institute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.entity.Institute;
import com.institute.exception.InstituteServiceCustomException;
import com.institute.repository.InstituteRepository;

@Service
public class InstituteServiceImpl implements InstituteService
{
	@Autowired
	private InstituteRepository instituteRepository;

	@Override
	public Institute registerInstitute(Institute institute) 
	{
		Institute registerInstitute = instituteRepository.save(institute);
		return registerInstitute;
	}

	@Override
	public Institute modifyInstitute(Long id, Institute updatedInstitute) 
	{
		Optional<Institute> optionalInstitute = instituteRepository.findById(id);

        if (optionalInstitute.isPresent()) {
            Institute existingInstitute = optionalInstitute.get();
            existingInstitute.setName(updatedInstitute.getName());
            existingInstitute.setLocation(updatedInstitute.getLocation());
            existingInstitute.setEmail(updatedInstitute.getEmail());
            existingInstitute.setContactNumber(updatedInstitute.getContactNumber());
            return instituteRepository.save(existingInstitute);
        }
        else
        {
        	throw new InstituteServiceCustomException("Institute with given id is not found","INSTITUTE_NOT_FOUND");
        }  
	}

	@Override
	public Institute getInstituteById(Long id) 
	{
		Institute institute = instituteRepository.findById(id)
				.orElseThrow(()-> new InstituteServiceCustomException("Institute with given id is not found","INSTITUTE_NOT_FOUND"));
		
		return institute;
	}

	@Override
	public List<Institute> getAllInstitutes() 
	{
		List<Institute> allInstitutes = instituteRepository.findAll();
		return allInstitutes;
	}

	@Override
	public void deleteInstituteById(Long id) 
	{
		if(!instituteRepository.existsById(id))
		{
			throw new InstituteServiceCustomException(
					"Institute With Given Id : " + id + " Not Found",
					"INSTITUTE_NOT_FOUND");
		}
		instituteRepository.deleteById(id);
	}

}
