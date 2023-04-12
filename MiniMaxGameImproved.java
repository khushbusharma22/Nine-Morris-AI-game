
import java.io.*;
import java.util.*;

public class MiniMaxGameImproved extends Morris {

	static int totalpositionevaluated;
	static int score = Integer.MIN_VALUE;

	public static List<Character> minimaxgame(List<Character> board, int depth) {
		List<List<Character>> allPossibleMoves;
		List<Character> successmove = new ArrayList<>();
		int tempscore;

		allPossibleMoves = Morris.GenerateMovesMidorEndgame(board);

		for (List<Character> alist : allPossibleMoves) {
			tempscore = minimax(alist, 2, depth - 1);

			if (tempscore > score) {
				score = tempscore;
				successmove = new ArrayList<>(alist);

			}

		}

		return successmove;
	}

	public static int minimax(List<Character> list1, int player, int depth) {
		int fscore = 0;
		int tempscore;

		List<Character> list2 = new ArrayList<>(list1);
		List<List<Character>> allPossMove = new ArrayList<List<Character>>();

		if (depth == 0) {

			totalpositionevaluated++;
			return Morris.stestMidgameImproved(list2);

		}

		if (player == 1) {

			allPossMove = Morris.GenerateMovesMidorEndgame(list2);
			fscore = Integer.MIN_VALUE;
			for (List<Character> alist : allPossMove) {

				tempscore = minimax(alist, 2, depth - 1);
				fscore = Math.max(fscore, tempscore);

			}

		}

		else {

			int i = 0;
			fscore = Integer.MAX_VALUE;
			while (i < list2.size()) {
				if (list2.get(i) == 'W') {
					list2.set(i, 'B');
				}

				else if (list2.get(i) == 'B') {
					list2.set(i, 'W');
				}

				i++;
			}

			allPossMove = Morris.GenerateMovesMidorEndgame(list2);

			for (i = 0; i < allPossMove.size(); i++) {
				for (int j = 0; j < allPossMove.get(i).size(); j++) {
					if (allPossMove.get(i).get(j) == 'W') {
						allPossMove.get(i).set(j, 'B');
					}

					else if (allPossMove.get(i).get(j) == 'B') {
						allPossMove.get(i).set(j, 'W');
					}
				}

				List<Character> alist = allPossMove.get(i);

				tempscore = minimax(alist, 1, depth - 1);
				fscore = Math.min(fscore, tempscore);

			}

		}

		return fscore;
	}

	public static void main(String[] args) throws IOException {
		List<Character> board = new ArrayList<Character>();
		List<Character> successmove = new ArrayList<Character>();

		Scanner sc = new Scanner(System.in);

		System.out.println("\nGive the name of the input board ");
		String inputboard = sc.next();

		System.out.println("\nGive the name of the output board  ");
		String outputboard = sc.next();

		System.out.println("\nEnter the depth of the tree (integer) : ");
		int depth = sc.nextInt();

		File board1 = new File(inputboard);
		FileReader fr = new FileReader(board1);
		BufferedReader br = new BufferedReader(fr);
		String line;
		line = br.readLine();
		for (Character ch : line.toCharArray()) {
			board.add(ch);
		}

		System.out.println("*** Mid or End phase for White Move ***\n");
		System.out.println("Input Board Move: " + board);
		System.out.print("depth :" + depth + "\n");

		// Printing in the file
		FileWriter myWriter = new FileWriter(outputboard, false);
		myWriter.write("*** Mid or End phase for White Move***\n");
		myWriter.write("Input Board Position: " + board + "\n");

		successmove = minimaxgame(board, depth);

		myWriter.write("MINIMAX estimate: " + score + "\n");
		myWriter.write("OutPut Board Position: " + successmove + "\n");
		myWriter.write("Positions evaluated by static estimation: " + totalpositionevaluated);
		myWriter.close();

		// Printing on the IDE

		System.out.println("Minimax estimate: " + score);
		System.out.println("Output Board/Best Move:" + successmove);
		System.out.println("Total position evaluated:" + totalpositionevaluated);

	}

}
