package com.example.demo.Service;

import java.util.List;

import com.example.demo.DTO.DataDTO;
import com.example.demo.VO.DataVO;

public interface DataService {
	// To insert Single Data
	String ToInsertSingleData(DataVO dataVO);

	// To insert List of Data
	public List<DataDTO> ToInsertData(List<DataVO> dataVOList);

	// To Get Data by Name
	List<DataDTO> ToGetTheDataByName(String name);
	
	//To Delete Data by using id
	String ToDeleteTheData(int no);
	
	//To Update Data 
	DataDTO ToUpdateTheData(String name, DataVO dataVO);
}
