package view;

import model.Board;

public class ViewControl implements ViewObs {
	@Override
    public void updateBoard(Board board) {
        for (int[] matrix : board.getPlan()) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

