public class Test01 {
	public static int i = 1;
	
	public int sum(int n1, int n2) {
		return n1 + n2;
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		board.no = 1;
		board.name = "~~~";
		
		BoardDao boardDao = new BoardDao();
		System.out.println(board);
		System.out.println(boardDao.updateBoard());
	}
}

class Board {
	int no;
	String name;
}

class BoardDao {
	public String updateBoard() {
		return "111";
	}
}