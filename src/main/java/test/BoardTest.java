package test;

import org.junit.Test;
import org.assertj.core.api.Assertions.*;
import is2.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    @Test
    public void return_an_empty_board_given_empty_board(){
        Board board = new Board(Cases.emptyBoard).next();
        assertThat(board.state()).isEqualTo(Cases.emptyBoard);
    }
    @Test
    public void return_dead_cell_given_dead_cell(){
        Board board = new Board (Cases.oneDeadCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }

    @Test
    public void return_a_dead_cell_given_alive_cell(){
        Board board = new Board (Cases.oneAliveCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }



    @Test
    public void return_2x2_all_alive_cells_given_2x2_alive_cells(){
        Board board = new Board(Cases.allAliveCells2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAliveCells2x2);
    }

    @Test
    public void return_2x2_given_triangule_structure_cells(){
        Board board = new Board(Cases.trianguleStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAliveCells2x2);
    }

    @Test
    public void return_2x2_given_line(){
        Board board = new Board(Cases.lineStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDeadCells2x2);
    }

    @Test
    public void return_3x3_square_structure_given_triangle_structure(){
        Board board = new Board(Cases.trianguleStructure3x3).next();
        assertThat(board.state()).isEqualTo(Cases.squareStructure3x3);
    }

    public static  class  Cases {
        static final String [][] emptyBoard = {{}};
        static final String[][] oneDeadCell = {{"."}};
        static final String [][] oneAliveCell = {{"X"}};
        static final String[][] allDeadCells2x2 = {{".","."},{".","."}};
        static final String [][] allAliveCells2x2 = {{"X", "X"},{"X", "X"}};
        static final String[][] trianguleStructure2x2 = {{".","X"},{"X","X"}};
        static final String[][] lineStructure2x2 = {{".","."},{"X","X"}};
        static final String[][] trianguleStructure3x3 = {{".",".","X"},{".","X","X"},{".",".","."}};
        static final String[][] squareStructure3x3 = {{".","X","X"},{".","X","X"},{".",".","."}};
    }
}
