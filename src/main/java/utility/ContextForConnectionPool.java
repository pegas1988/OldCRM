package utility;

public class ContextForConnectionPool {

    private static ConnectionPool connectionPool;

    public static ConnectionPool get()  {
        try {
            if (connectionPool == null) {
                connectionPool = new ConnectionPool();
                connectionPool.init();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionPool;
    }
}
