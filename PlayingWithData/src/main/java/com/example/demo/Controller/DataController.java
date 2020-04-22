package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DataDTO;
import com.example.demo.Service.DataService;
import com.example.demo.VO.DataVO;

@RestController
public class DataController {

	@Autowired
	private DataService dataService;
	@Autowired
	private List<DataDTO> dataDTOList;

	@PostMapping(path = "/insertData", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public List<DataVO> InsertData(@RequestBody List<DataVO> dataVOList) throws IOException {

		dataService.ToInsertData(dataVOList);
		return dataVOList;
	}

	@PostMapping(path = "/singleData", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public DataVO SingleData(@RequestBody DataVO dataVO) throws IOException {

		dataService.ToInsertSingleData(dataVO);
		return dataVO;
	}
	/*
	 * if we use @RequestBody we have to mention input with out key value and 
	 * quotations.i.e yaswanth
	 */	
	@GetMapping(path = "/findByName", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DataDTO> FindByName(@RequestParam String name) throws Exception {

		dataDTOList = dataService.ToGetTheDataByName(name);
		return dataDTOList;
	}
	/*
	 * if we use @RequestBody we have to mention input with out key value and
	 * quotations.i.e 2 not like "2" or "no":"2"
	 */
	@PostMapping(value = "/toDelete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String ToDeleteTheRecord(@RequestParam int no) throws Exception {

		dataService.ToDeleteTheData(no);
		return "Deleted";
	}

	@GetMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DataVO ToUpdateData(@RequestParam String name,@RequestBody DataVO dataVO) throws IOException {
		dataService.ToUpdateTheData(name, dataVO);
		return dataVO;
	}
}
