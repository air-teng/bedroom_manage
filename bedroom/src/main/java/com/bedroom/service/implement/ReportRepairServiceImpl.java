package com.bedroom.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.ReportRepair;
import com.bedroom.dao.ReportRepairDao;
import com.bedroom.service.ReportRepairService;

/**
 * 报修申请实现类
 * @author Administrator
 */
@Service
public class ReportRepairServiceImpl implements ReportRepairService {
	@Autowired
	private ReportRepairDao reportRepairDao;

	@Override
	public void addReportRepair(ReportRepair reportRepair) {
		reportRepairDao.addReportRepair(reportRepair);
	}
	
}
