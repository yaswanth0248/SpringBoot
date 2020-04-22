package com.example.demo.Mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.demo.DTO.DataDTO;
import com.example.demo.VO.DataVO;

@Component
public class Mappers {
	public DataVO convertsDTOToVo(DataDTO dataDTO) {

		DataVO dataVO = new DataVO();
		dataVO.setNo(dataDTO.getNo());
		dataVO.setName(dataDTO.getName());
		dataVO.setAge(dataDTO.getAge());
		dataVO.setSex(dataDTO.getSex());

		return dataVO;
	}

	public DataDTO convertsVOToDTO(DataVO dataVO) {

		DataDTO dataDTO = new DataDTO();
		dataDTO.setNo(dataVO.getNo());
		dataDTO.setAge(dataVO.getAge());
		dataDTO.setName(dataVO.getName());
		dataDTO.setSex(dataVO.getSex());

		return dataDTO;
	}

	public List<DataDTO> convertsVOToDTOList(List<DataVO> dataVOList) {
		List<DataDTO> dataDTOList = new ArrayList<DataDTO>();
		DataDTO dataDTO = new DataDTO();
		for (DataVO item : dataVOList) {
			dataDTO = convertsVOToDTO(item);
			dataDTOList.add(dataDTO);
			
		}
		return dataDTOList;

	}
	public List<DataVO> convertsDTOToVoList(List<DataDTO> dataDTOList){
		List<DataVO> dataVOList =new ArrayList<DataVO>();
		DataVO dataVO =new DataVO();
		for (DataDTO item:dataDTOList) {
			dataVO =convertsDTOToVo(item);
			dataVOList.add(dataVO);
		}
		
		return dataVOList;
	}

} 
