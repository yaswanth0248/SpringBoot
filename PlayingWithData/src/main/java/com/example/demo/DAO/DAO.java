package com.example.demo.DAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.DataDTO;

@Repository
public interface DAO extends CrudRepository<DataDTO, Serializable>{
	
	@Query("{name : ?0}")
	List<DataDTO> findByName(String name);
	/* public List<DataDTO> findByName(String name); */
	
	@SuppressWarnings("unchecked")
	public DataDTO save(DataDTO dataDTO);
	
	
}
