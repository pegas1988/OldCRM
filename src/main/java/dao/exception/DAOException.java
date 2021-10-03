package dao.exception;

import java.sql.SQLException;

public class DAOException extends SQLException {
    public void dangerZone() {
        System.out.println("DAO Layer exception");
    }
}

