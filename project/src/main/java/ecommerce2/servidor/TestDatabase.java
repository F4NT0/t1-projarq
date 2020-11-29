package ecommerce2.servidor;

public class TestDatabase {
    public static void main(String[] args) throws Exception {
        Database dao = new Database();
        dao.readDatabase();
    }
}