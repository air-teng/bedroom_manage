package com.bedroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedroom.common.AjaxResult;
import com.bedroom.common.pojo.ReportRepair;
import com.bedroom.service.ReportRepairService;

@Controller
@RequestMapping("/repair/")
public class ReportRepairController {
	@Autowired
	private ReportRepairService reportRepairService;
	
	@RequestMapping(value="reportRepair",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult reportRepair(ReportRepair reportRepair) {
		reportRepairService.addReportRepair(reportRepair);
		return AjaxResult.oK();
	}
}
