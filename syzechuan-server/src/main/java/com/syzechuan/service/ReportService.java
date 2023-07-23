package com.syzechuan.service;

import com.syzechuan.vo.OrderReportVO;
import com.syzechuan.vo.SalesTop10ReportVO;
import com.syzechuan.vo.TurnoverReportVO;
import com.syzechuan.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {

    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
