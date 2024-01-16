package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	// http://localhost:8080/app/getTestEmp?lastName=Hong&hireDate=2024/01/16
	@GetMapping("getTestEmp")
	@ResponseBody // JSP가 아닌 데이터를 반환한다
	public EmpVO getEmpInfo(EmpVO empVO) { // emp안에 매칭이되면 값을담고 값을 넘겨 주지않으면 그냥 버린다
		empVO.setEmployeeId(1000);
		return empVO; // return을 줘야함
	}

	@PostMapping("getTestEmp")
	@ResponseBody // JSP가 아닌 데이터를 반환한다
	public EmpVO getEmpInfoPost(EmpVO empVO) {
		empVO.setEmployeeId(9000);
		return empVO; // return을 줘야함
	}

	@GetMapping("paramTestEmp")
	@ResponseBody
	public Map<String, Object> paramTestEmpGet(String name,  Integer age){
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("age", age);
		return map;
	}

	@PostMapping("paramTestEmp")
	@ResponseBody
	public Map<String, Object> paramTestEmpPost(@RequestParam String name, 
												@RequestParam(defaultValue = "20") Integer age){ // @RequestParam 이게 정의되어 있으면 필수 값 무조건 넣어줘야함
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("age", age);
		return map;
	}
	
	@GetMapping("pathTestEmp/{id}/{password}")
	@ResponseBody
	public String pathTestEmpGet(@PathVariable String id, @PathVariable(name = "password") String pwd) { //@PathVariable
		return id;
	}
	
	@PostMapping("jsonTestEmp")
	@ResponseBody
	public EmpVO jsonTestEmpPost(@RequestBody EmpVO empVO) {
		return empVO;
	}
	
	
}
