package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@CrossOrigin("*") // 모든 cers를 허용하겠다
//@Controller
@RestController // rest 방식을 기반으로하나 컨트롤러 이러면 내부에 있는 메서드를 데이터를 반환한다 라는 의미 컨트롤러 위에 RestController컨트롤러를 붙여주면 각 메서드가 가지고 있는 ResponseBody를 생략할수 있다
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	
	//전체조회
	@GetMapping("emps")
	//@ResponseBody
	public List<EmpVO> getEmpList(){ // 더이상 모델을 사용하지 않는다 페이지가 없는자리에 바로 리턴하면 되기때문에
		return empService.getEmpAll();
	}
	//단건조회
	@GetMapping("emps/{id}")
	//@ResponseBody
	public EmpVO getEmpInfo(@PathVariable Integer id) { // 단건이기 때문에 조건이 필요함 id 라는 조건
		EmpVO empVO = new EmpVO(); // rest 방식 서비스에 객체가 아닌 단일 값으로도 생각해봐야한다
		empVO.setEmployeeId(id); 
		return empService.getEmpInfo(empVO);
	}
	
	//등록
	@PostMapping("emps")
	//@ResponseBody
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO){ // 객체로받을꺼면 객체로 통일성이 필요하다
		
		int eid = empService.insertEmpInfo(empVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map;
	}
	
	//수정
	@PutMapping("emps/{id}") // 얘도 누구를 수정할건지 알려주고 id로, 동시에 무엇을 수정할지 @PathVariable, @RequestBody 
	//@ResponseBody
	public Map<String, Object> updateEmpInfo(@PathVariable Integer id, @RequestBody EmpVO empVO){ // 객체로받을꺼면 객체로 통일성이 필요하다
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO);
		
		
	}
	//삭제
	@DeleteMapping("emps")
	//@ResponseBody
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
	
	
	
	
	
}
