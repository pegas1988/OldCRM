package utility;

import java.sql.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.Executor;


public class ConnectionPool {

    private Queue<Connection> queue = new LinkedList<>();

    public void init() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < 4; i++) {
            Connection connection = PostgresUtil.getConnetion();
            queue.add(new ConnectionWrapper(connection));
        }
    }

    public Connection get() {
        while (queue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }

    public class ConnectionWrapper implements Connection {
        private Connection connection;

        public ConnectionWrapper(Connection connection) {
            this.connection = connection;
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String s) throws SQLException {
            return connection.prepareStatement(s);
        }

        @Override
        public CallableStatement prepareCall(String s) throws SQLException {
            return connection.prepareCall(s);
        }

        @Override
        public String nativeSQL(String s) throws SQLException {
            return connection.nativeSQL(s);
        }

        @Override
        public void setAutoCommit(boolean b) throws SQLException {

        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return false;
        }

        @Override
        public void commit() throws SQLException {

        }

        @Override
        public void rollback() throws SQLException {

        }

        @Override
        public void close() throws SQLException {
            queue.add(this);

        }

        @Override
        public boolean isClosed() throws SQLException {
            return false;
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean b) throws SQLException {

        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return false;
        }

        @Override
        public void setCatalog(String s) throws SQLException {

        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int i) throws SQLException {

        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return 0;
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {

        }

        @Override
        public Statement createStatement(int i, int i1) throws SQLException {
            return connection.createStatement(i, i1);
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i1) throws SQLException {
            return connection.prepareStatement(s, i, i1);
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i1) throws SQLException {
            return connection.prepareCall(s, i, i1);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

        }

        @Override
        public void setHoldability(int i) throws SQLException {

        }

        @Override
        public int getHoldability() throws SQLException {
            return 0;
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String s) throws SQLException {
            return connection.setSavepoint(s);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {

        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {

        }

        @Override
        public Statement createStatement(int i, int i1, int i2) throws SQLException {
            return connection.createStatement(i, i1, i2);
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i, int i1, int i2) throws SQLException {
            return connection.prepareStatement(s, i, i1, i2);
        }

        @Override
        public CallableStatement prepareCall(String s, int i, int i1, int i2) throws SQLException {
            return connection.prepareCall(s, i, i1, i2);
        }

        @Override
        public PreparedStatement prepareStatement(String s, int i) throws SQLException {
            return connection.prepareStatement(s, i);
        }

        @Override
        public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
            return connection.prepareStatement(s, ints);
        }

        @Override
        public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
            return connection.prepareStatement(s, strings);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int i) throws SQLException {
            return false;
        }

        @Override
        public void setClientInfo(String s, String s1) throws SQLClientInfoException {

        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {

        }

        @Override
        public String getClientInfo(String s) throws SQLException {
            return connection.getClientInfo(s);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String s, Object[] objects) throws SQLException {
            return connection.createArrayOf(s, objects);
        }

        @Override
        public Struct createStruct(String s, Object[] objects) throws SQLException {
            return connection.createStruct(s, objects);
        }

        @Override
        public void setSchema(String s) throws SQLException {

        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {

        }

        @Override
        public void setNetworkTimeout(Executor executor, int i) throws SQLException {

        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return 0;
        }

        @Override
        public <T> T unwrap(Class<T> aClass) throws SQLException {
            return connection.unwrap(aClass);
        }

        @Override
        public boolean isWrapperFor(Class<?> aClass) throws SQLException {
            return false;
        }
    }
}
