package topic4.db;

public class MainDB {

	public static void main(String[] args) {
		MySqlDB db = new MySqlDB();
		try {
			db.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
