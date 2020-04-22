package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.DTO.DataDTO;
import com.example.demo.Mappers.Mappers;
import com.example.demo.Service.DataService;
import com.example.demo.VO.DataVO;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DAO dao;
	@Autowired
	private Mappers mappers;
	@Autowired
	private DataDTO dataDTO;
	
	@Override
	public String ToInsertSingleData(DataVO dataVO) {
		
		dataDTO = mappers.convertsVOToDTO(dataVO);
		dao.save(dataDTO);
		return null;
	}
	@Override
	public List<DataDTO> ToInsertData(List<DataVO> dataVOList) {
		List<DataDTO> dataDTOList = new ArrayList<DataDTO>();
		dataDTOList=mappers.convertsVOToDTOList(dataVOList);	
		for (DataDTO item :dataDTOList ) {
			dao.save(item);
		}
		
		return dataDTOList;
	}
	@Override
	public List<DataDTO> ToGetTheDataByName (String name) {
		List<DataDTO> dataDTOList = new ArrayList<DataDTO>();
		dataDTOList=dao.findByName(name);
		return dataDTOList;
		
	}
	@Override
	public String ToDeleteTheData(int no) {
		dao.deleteById(no);
		return "Record Sucessfully Deleted";
	}
	@Override
	public DataDTO ToUpdateTheData(String name, DataVO dataVO) {
		
	 dao.save(mappers.convertsVOToDTO(dataVO)); 
		return dataDTO;
	}
	
}

