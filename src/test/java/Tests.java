import Exceptions.BoardNotCompatibleException;
import Exceptions.VariantNotFoundException;
import Objects.Board;
import Objects.BoardService;
import org.junit.jupiter.api.Test;

public class Tests {

    Board board;

    @Test
    public void BoardTest() {
        try {
            board = new Board(3, 3, new String[]{"111", "1111", "111"});
        } catch (BoardNotCompatibleException | VariantNotFoundException e) {
            //e.printStackTrace();
            assert true;
        }

        try {
            board = new Board(3, 3, new String[]{"111", "111", "111", "111"});
        } catch (BoardNotCompatibleException | VariantNotFoundException e) {
            //e.printStackTrace();
            assert true;
        }
    }

    @Test
    public void generationTest() {
        try {
            board = new Board(3, 3, new String[]{"000", "111", "000"});
        } catch (BoardNotCompatibleException | VariantNotFoundException e) {
            e.printStackTrace();
            assert false;
        }

        int count = BoardService.countGenerationInWitchCellIsGreen(1,0,10, board);

        assert count == 5;
    }

    @Test
    public void generation1Test() {
        try {
            board = new Board(4, 4, new String[]{"1001", "1111", "0100", "1010"});
        } catch (BoardNotCompatibleException | VariantNotFoundException e) {
            e.printStackTrace();
            assert false;
        }

        int count = BoardService.countGenerationInWitchCellIsGreen(2,2,15, board);

        assert count == 14;
    }
}
