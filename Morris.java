import java.util.*;

public class Morris {
	int totalpositionevaluated;

	public static List<List<Character>> GenerateMovesOpening(List<Character> board) {

		List<List<Character>> possibleLists = new ArrayList<List<Character>>();
		possibleLists = GenerateAdd(board);

		return possibleLists;

	}

	public static List<List<Character>> GenerateMovesMidorEndgame(List<Character> board) {

		List<List<Character>> possibleLists = new ArrayList<List<Character>>();
		int countWhite = 0;
		countWhite = countofPlayer(board, 'W');

		if (countWhite == 3) {
			possibleLists = GenerateHopping(board);
		}

		else {
			possibleLists = GenerateMove(board);
		}

		return possibleLists;

	}

	public static int countofPlayer(List<Character> board, Character ch) {
		int countW = 0;
		int countB = 0;

		for (int i = 0; i < board.size(); i++) {

			if (board.get(i) == 'W')
				countW++;
			else if (board.get(i) == 'B')
				countB++;
		}

		if (ch == 'W')
			return countW;

		else
			return countB;

	}

	public static List<List<Character>> GenerateAdd(List<Character> board) {
		List<List<Character>> possibleList = new ArrayList<List<Character>>();

		for (int position = 0; position < board.size(); position++) {
			if (board.get(position) == 'x') {
				List<Character> templist = new ArrayList<>(board);
				templist.set(position, 'W');

				if (closeMill(position, templist)) {
					possibleList = generateRemove(templist, possibleList);
				} else {
					possibleList.add(templist);

				}
			}
		}

		return possibleList;
	}

	public static List<List<Character>> GenerateMove(List<Character> board) {
		List<List<Character>> MoveList = new ArrayList<List<Character>>();
		List<Integer> neigh = new ArrayList<>();

		for (int position = 0; position < board.size(); position++) {
			if (board.get(position) == 'W') {
				neigh = Neighbors(position);

				for (int i = 0; i < neigh.size(); i++) {
					if (board.get(neigh.get(i)) == 'x') {
						List<Character> temp = new ArrayList<>(board);
						temp.set(position, 'x');
						temp.set(neigh.get(i), 'W');

						if (closeMill(neigh.get(i), temp)) {
							MoveList = generateRemove(temp, MoveList);
						} else {
							MoveList.add(temp);
						}

					}
				}
			}
		}

		return MoveList;

	}

	public static List<List<Character>> GenerateHopping(List<Character> board) {
		List<List<Character>> MoveList = new ArrayList<List<Character>>();
		List<Character> temp;

		for (int hopalphaindex = 0; hopalphaindex < board.size(); hopalphaindex++) {
			if (board.get(hopalphaindex) == 'W') {
				for (int hopbetaindex = 0; hopbetaindex < board.size(); hopbetaindex++) {
					if (board.get(hopbetaindex) == 'x') {
						temp = new ArrayList<>(board);
						temp.set(hopalphaindex, 'x');
						temp.set(hopbetaindex, 'W');

						if (closeMill(hopbetaindex, temp)) {
							MoveList = generateRemove(temp, MoveList);
						} else {
							MoveList.add(temp);
						}
					}
				}
			}
		}
		return MoveList;
	}

	public static List<Integer> Neighbors(int position) {
		List<Integer> neighbor = new ArrayList<>();
		if (position == 0) {
			neighbor.add(1);
			neighbor.add(3);
			neighbor.add(19);

			return neighbor;

		}

		else if (position == 1) {
			neighbor.add(0);
			neighbor.add(2);
			neighbor.add(4);

			return neighbor;

		}

		else if (position == 2) {
			neighbor.add(1);
			neighbor.add(5);
			neighbor.add(12);

			return neighbor;
		}

		else if (position == 3) {
			neighbor.add(0);
			neighbor.add(4);
			neighbor.add(6);
			neighbor.add(8);

			return neighbor;
		}

		else if (position == 4) {
			neighbor.add(1);
			neighbor.add(3);
			neighbor.add(5);

			return neighbor;
		}

		else if (position == 5) {
			neighbor.add(2);
			neighbor.add(4);
			neighbor.add(7);
			neighbor.add(11);
			return neighbor;
		}

		else if (position == 6) {
			neighbor.add(3);
			neighbor.add(7);
			neighbor.add(9);

			return neighbor;

		}

		else if (position == 7) {
			neighbor.add(5);
			neighbor.add(6);
			neighbor.add(10);

			return neighbor;

		}

		else if (position == 8) {
			neighbor.add(3);
			neighbor.add(9);
			neighbor.add(16);

			return neighbor;
		}

		else if (position == 9) {
			neighbor.add(6);
			neighbor.add(8);
			neighbor.add(13);

			return neighbor;
		}

		else if (position == 10) {
			neighbor.add(7);
			neighbor.add(11);
			neighbor.add(15);

			return neighbor;
		}

		else if (position == 11) {
			neighbor.add(5);
			neighbor.add(10);
			neighbor.add(12);
			neighbor.add(18);

			return neighbor;
		}

		else if (position == 12) {
			neighbor.add(2);
			neighbor.add(11);
			neighbor.add(21);

			return neighbor;
		}

		else if (position == 13) {
			neighbor.add(9);
			neighbor.add(14);
			neighbor.add(16);

			return neighbor;
		} else if (position == 14) {
			neighbor.add(13);
			neighbor.add(15);
			neighbor.add(17);

			return neighbor;
		} else if (position == 15) {
			neighbor.add(10);
			neighbor.add(14);
			neighbor.add(18);

			return neighbor;
		} else if (position == 16) {
			neighbor.add(8);
			neighbor.add(13);
			neighbor.add(17);
			neighbor.add(19);

			return neighbor;
		} else if (position == 17) {
			neighbor.add(14);
			neighbor.add(16);
			neighbor.add(18);
			neighbor.add(20);

			return neighbor;

		} else if (position == 18) {
			neighbor.add(11);
			neighbor.add(15);
			neighbor.add(17);
			neighbor.add(21);

			return neighbor;
		} else if (position == 19) {
			neighbor.add(0);
			neighbor.add(16);
			neighbor.add(20);

			return neighbor;
		} else if (position == 20) {
			neighbor.add(17);
			neighbor.add(19);
			neighbor.add(21);

			return neighbor;
		} else if (position == 21) {
			neighbor.add(12);
			neighbor.add(18);
			neighbor.add(20);

			return neighbor;
		}

		return neighbor;
	}

	public static boolean closeMill(int position, List<Character> b) {
		Character ch = b.get(position);
		if (ch == 'B' || ch == 'W') {
			if (position == 0) {
				if ((b.get(1) == ch && b.get(2) == ch) || (b.get(3) == ch && b.get(6) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 1) {
				if (b.get(0) == ch && b.get(2) == ch) {
					return true;
				} else
					return false;
			}

			else if (position == 2) {
				if ((b.get(0) == ch && b.get(1) == ch) || (b.get(5) == ch && b.get(7) == ch)
						|| (b.get(12) == ch && b.get(21) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 3) {
				if ((b.get(0) == ch && b.get(6) == ch) || (b.get(4) == ch && b.get(5) == ch)
						|| (b.get(8) == ch && b.get(16) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 4) {
				if (b.get(3) == ch && b.get(5) == ch) {
					return true;
				} else
					return false;
			}

			else if (position == 5) {
				if ((b.get(2) == ch && b.get(7) == ch) || (b.get(3) == ch && b.get(4) == ch)
						|| (b.get(11) == ch && b.get(18) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 6) {
				if ((b.get(0) == ch && b.get(3) == ch) || (b.get(9) == ch && b.get(13) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 7) {
				if ((b.get(2) == ch && b.get(5) == ch) || (b.get(10) == ch && b.get(15) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 8) {
				if (b.get(3) == ch && b.get(16) == ch) {
					return true;
				} else
					return false;
			}

			else if (position == 9) {
				if (b.get(6) == ch && b.get(13) == ch) {
					return true;
				} else
					return false;
			}

			else if (position == 10) {
				if ((b.get(7) == ch && b.get(15) == ch) || (b.get(11) == ch && b.get(12) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 11) {
				if ((b.get(10) == ch && b.get(12) == ch) || (b.get(5) == ch && b.get(18) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 12) {
				if ((b.get(2) == ch && b.get(21) == ch) || (b.get(10) == ch && b.get(11) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 13) {
				if ((b.get(6) == ch && b.get(9) == ch) || (b.get(14) == ch && b.get(15) == ch)
						|| (b.get(16) == ch && b.get(19) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 14) {
				if ((b.get(15) == ch && b.get(13) == ch) || (b.get(17) == ch && b.get(20) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 15) {
				if ((b.get(7) == ch && b.get(10) == ch) || (b.get(13) == ch && b.get(14) == ch)
						|| (b.get(18) == ch && b.get(21) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 16) {
				if ((b.get(3) == ch && b.get(8) == ch) || (b.get(13) == ch && b.get(19) == ch)
						|| (b.get(17) == ch && b.get(18) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 17) {
				if ((b.get(14) == ch && b.get(20) == ch) || (b.get(16) == ch && b.get(18) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 18) {
				if ((b.get(16) == ch && b.get(17) == ch) || (b.get(15) == ch && b.get(21) == ch)
						|| (b.get(11) == ch && b.get(5) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 19) {
				if ((b.get(20) == ch && b.get(21) == ch) || (b.get(13) == ch && b.get(16) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 20) {
				if ((b.get(19) == ch && b.get(21) == ch) || (b.get(17) == ch && b.get(14) == ch)) {
					return true;
				} else
					return false;
			}

			else if (position == 21) {
				if ((b.get(19) == ch && b.get(20) == ch) || (b.get(15) == ch && b.get(18) == ch)
						|| (b.get(12) == ch && b.get(2) == ch)) {
					return true;
				} else
					return false;
			}

		}

		return false;
	}

	public static int[] countTotalMills(List<Character> b) {
		int totalMillsW = 0;
		int totalMillsB = 0;

		if ((b.get(0) == 'W' && b.get(1) == 'W' && b.get(2) == 'W'))
			totalMillsW++;
		else if ((b.get(0) == 'B' && b.get(1) == 'B' && b.get(2) == 'B'))
			totalMillsB++;

		if ((b.get(0) == 'W' && b.get(3) == 'W' && b.get(6) == 'W'))
			totalMillsW++;
		else if ((b.get(0) == 'B' && b.get(3) == 'B' && b.get(6) == 'B'))
			totalMillsB++;

		if ((b.get(2) == 'W' && b.get(12) == 'W' && b.get(21) == 'W'))
			totalMillsW++;
		else if ((b.get(2) == 'B' && b.get(12) == 'B' && b.get(21) == 'B'))
			totalMillsB++;

		if ((b.get(2) == 'W' && b.get(5) == 'W' && b.get(7) == 'W'))
			totalMillsW++;
		else if ((b.get(2) == 'B' && b.get(5) == 'B' && b.get(7) == 'B'))
			totalMillsB++;

		if ((b.get(3) == 'W' && b.get(4) == 'W' && b.get(5) == 'W'))
			totalMillsW++;
		else if ((b.get(3) == 'B' && b.get(4) == 'B' && b.get(5) == 'B'))
			totalMillsB++;

		if ((b.get(3) == 'W' && b.get(8) == 'W' && b.get(16) == 'W'))
			totalMillsW++;
		else if ((b.get(3) == 'B' && b.get(8) == 'B' && b.get(16) == 'B'))
			totalMillsB++;

		if ((b.get(5) == 'W' && b.get(11) == 'W' && b.get(18) == 'W'))
			totalMillsW++;
		else if ((b.get(5) == 'B' && b.get(11) == 'B' && b.get(18) == 'B'))
			totalMillsB++;

		if ((b.get(6) == 'W' && b.get(9) == 'W' && b.get(13) == 'W'))
			totalMillsW++;
		else if ((b.get(6) == 'B' && b.get(9) == 'B' && b.get(13) == 'B'))
			totalMillsB++;

		if ((b.get(7) == 'W' && b.get(10) == 'W' && b.get(15) == 'W'))
			totalMillsW++;
		else if ((b.get(7) == 'B' && b.get(10) == 'B' && b.get(15) == 'B'))
			totalMillsB++;

		if ((b.get(10) == 'W' && b.get(11) == 'W' && b.get(12) == 'W'))
			totalMillsW++;
		else if ((b.get(10) == 'B' && b.get(11) == 'B' && b.get(12) == 'B'))
			totalMillsB++;

		if ((b.get(13) == 'W' && b.get(14) == 'W' && b.get(15) == 'W'))
			totalMillsW++;
		else if ((b.get(13) == 'B' && b.get(14) == 'B' && b.get(15) == 'B'))
			totalMillsB++;

		if ((b.get(13) == 'W' && b.get(16) == 'W' && b.get(19) == 'W'))
			totalMillsW++;
		else if ((b.get(13) == 'B' && b.get(16) == 'B' && b.get(19) == 'B'))
			totalMillsB++;

		if ((b.get(14) == 'W' && b.get(17) == 'W' && b.get(20) == 'W'))
			totalMillsW++;
		else if ((b.get(14) == 'B' && b.get(17) == 'B' && b.get(20) == 'B'))
			totalMillsB++;

		if ((b.get(15) == 'W' && b.get(18) == 'W' && b.get(21) == 'W'))
			totalMillsW++;
		else if ((b.get(15) == 'B' && b.get(18) == 'B' && b.get(21) == 'B'))
			totalMillsB++;

		if ((b.get(16) == 'W' && b.get(17) == 'W' && b.get(18) == 'W'))
			totalMillsW++;
		else if ((b.get(16) == 'B' && b.get(17) == 'B' && b.get(18) == 'B'))
			totalMillsB++;

		if ((b.get(19) == 'W' && b.get(20) == 'W' && b.get(21) == 'W'))
			totalMillsW++;
		else if ((b.get(19) == 'B' && b.get(20) == 'B' && b.get(21) == 'B'))
			totalMillsB++;

		int[] a = { totalMillsW, totalMillsB };
		return a;
	}

	public static List<List<Character>> generateRemove(List<Character> tempList, List<List<Character>> possibleList)

	{
		List<List<Character>> pL = new ArrayList<List<Character>>(possibleList);

		Boolean addedToList = false;
		List<Character> tempList2 = new ArrayList<Character>();
		for (int position = 0; position < tempList.size(); position++) {
			if (tempList.get(position) == 'B') {
				if (closeMill(position, tempList) == false) {
					tempList2 = new ArrayList<>(tempList);
					tempList2.set(position, 'x');
					pL.add(tempList2);
					addedToList = true;

				}

			}
		}
		if (addedToList == false) {
			tempList2 = new ArrayList<>(tempList);
			pL.add(tempList2);
		}

		return pL;

	}

	public static int stestopening(List<Character> b) {
		int countWhite = 0;
		int countBlack = 0;

		countWhite = countofPlayer(b, 'W');
		countBlack = countofPlayer(b, 'B');

		int res = countWhite - countBlack;

		return res;
	}

	public static int stestMidgame(List<Character> b) {
		int countWhite = 0;
		int countBlack = 0;
		int countBlackMoves = 0;

		List<List<Character>> BlackMoves = new ArrayList<List<Character>>();

		countWhite = countofPlayer(b, 'W');
		countBlack = countofPlayer(b, 'B');
		int i = 0;
		List<Character> newb = new ArrayList<>(b);
		while (i < newb.size()) {
			if (newb.get(i) == 'W') {
				newb.set(i, 'B');
			}

			else if (newb.get(i) == 'B') {
				newb.set(i, 'W');
			}

			i++;
		}

		BlackMoves = GenerateMovesMidorEndgame(newb);
		countBlackMoves = BlackMoves.size();

		if (countBlack <= 2)
			return 10000;
		else if (countWhite <= 2)
			return -10000;
		else if (countBlackMoves == 0)
			return 10000;
		else
			return ((1000 * (countWhite - countBlack)) - countBlackMoves);
	}

	public static int stestMidgameImproved(List<Character> b) {
		int countWhite = 0;
		int countBlack = 0;
		int countBlackMoves = 0;

		List<List<Character>> BlackMoves = new ArrayList<List<Character>>();

		countWhite = countofPlayer(b, 'W');
		countBlack = countofPlayer(b, 'B');
		int i = 0;
		List<Character> newb = new ArrayList<>(b);
		while (i < newb.size()) {
			if (newb.get(i) == 'W') {
				newb.set(i, 'B');
			}

			else if (newb.get(i) == 'B') {
				newb.set(i, 'W');
			}

			i++;
		}

		BlackMoves = GenerateMovesMidorEndgame(newb);
		countBlackMoves = BlackMoves.size();
		int a[] = countTotalMills(b);

		int countWhiteMills = a[0];
		int countBlackMills = a[1];

		int MillsDifference = countWhiteMills - countBlackMills;

		if (countBlack <= 2)
			return 10000;
		else if (countWhite <= 2)
			return -10000;
		else if (countBlackMoves == 0)
			return 10000;
		else
			return ((1000 * MillsDifference) - countBlackMoves);
	}

	public static int stestopeningimprove(List<Character> b) {
		int countWhiteMills = 0;
		int countBlackMills = 0;
		int a[] = countTotalMills(b);

		countWhiteMills = a[0];
		countBlackMills = a[1];

		int res = countWhiteMills - countBlackMills;

		return res;
	}

}
