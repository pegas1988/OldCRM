package service;

import dao.DailyReportDao;
import entity.DailyReport;

import java.sql.Date;
import java.util.List;

public class DailyReportService {
    DailyReportDao dailyReportDao = new DailyReportDao();

    public List<DailyReport> findAll() {
        return dailyReportDao.findAll();
    }

    public List<DailyReport> findByCreatingDay(Date date) {
        return dailyReportDao.findByCreatingDate(date);
    }

    public void createDailyReport(DailyReport dailyReport) {
        dailyReportDao.createReport(dailyReport);
    }
}
