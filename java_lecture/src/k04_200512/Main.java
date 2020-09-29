package k04_200512;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws SQLException {
		System.out.println("1원 이상의 아이템 목록");

		// SELECT * FROM ITEM WHERE PRICE > 1;
		ArrayList<Item> items = ItemDAO.findByMinimumPrice(1); // ItemDAO 안에 있는 ArrayList 메서드를 가져옴
		for (Item item : items) { // findByMinimumPrice를 모두 검색하여 출력한다
			System.out.println(item.getName() + ", " + item.getPrice() + ", " + item.getWeight());
		}
	}
}
