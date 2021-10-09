package dao;

import dao.dao.constant.DaoConstant;
import entity.DailyReport;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DailyReportDao {
    private static final String SELECT_ALL = "select from daily_report";
    private static final String SELECT_BY_DATE = "select * from daily_report where date_of_report = ?";
    private static final String CREATE_REPORT = "insert into daily_report (date_of_report, responsible_person) values (?,?)";

    ConnectionPool connectionPool;

    public List<DailyReport> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<DailyReport> dailyReports = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                DailyReport report = new DailyReport();
                report.setDate(resultSet.getDate(DaoConstant.DAO_REPORT_DATE));
                report.setResponsiblePerson(resultSet.getString(DaoConstant.DAO_RESPONSIBLE_PERSON));
                dailyReports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dailyReports;
    }

    public List<DailyReport> findByCreatingDate(Date date) {
        connectionPool = ContextForConnectionPool.get();
        List<DailyReport> dailyReports = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_DATE)) {
            preparedStatement.setDate(1, date);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DailyReport report = new DailyReport();
                report.setDate(resultSet.getDate(DaoConstant.DAO_REPORT_DATE));
                report.setResponsiblePerson(resultSet.getString(DaoConstant.DAO_RESPONSIBLE_PERSON));
                dailyReports.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dailyReports;
    }

    public void createReport(DailyReport report) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_REPORT)
        ) {
            preparedStatement.setString(2, report.getResponsiblePerson());
            preparedStatement.setDate(1, (Date) report.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
