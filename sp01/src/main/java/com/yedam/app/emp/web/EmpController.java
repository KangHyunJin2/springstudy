package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 경로 저장 컨트롤러
public class EmpController {
	@Autowired
	EmpService empService;
	
	//@Autowired
	//DeptService deptService;
	
	//GET  : 조회 , 빈페이지 호출  보완이 약함
	//POST : 데이터 조작(등록, 수정, 삭제) GET보다는 보안이 좋음
	
	//전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList"; //"emp/ 이거는 폴더경로 empList는 그안에 경로"
	}
	
	//사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}
	
	//사원등록 - FROM 
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	//사원등록 - PROCESS 등록경우에는 경로는 같다 <form action="empInsert" method="post"> empInsert에 form태그
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		
		if(empId > -1) {
			path = "redirect:empInfo?employeeId="+empId; // 페이지가 아니라 경로를 알려준다
		} else {
			path = "redirect:empList";
		}
		return path;
	}
	
	//사원수정 - PROCESS : Ajax => @ResponseBody 아작스라면 정해져있음
	//1) QueryString => 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	
	//2) JSON 		=> @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	
	//사원삭제 - PROCESS
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) { // 단일값으로
		empService.deleteEmpInfo(eid);
		return "redirect: empList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
