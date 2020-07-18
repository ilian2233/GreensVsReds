import Exceptions.BoardNotCompatibleException;
import Exceptions.VariantNotFoundException;
import Objects.Board;
import Objects.BoardService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //declaration of the variables and validations
        int x = 0, y = 0;
        boolean incorrectInput = false;
        do {
            if (incorrectInput) {
                System.out.println("Incorrect input!");
                incorrectInput = false;
            }
            System.out.println("Please enter the dimensions of the array: ");
            String string = input.nextLine();
            String[] dimensions = string.split(",");
            try {
                x = Integer.parseInt(dimensions[0]);
                y = Integer.parseInt(dimensions[1]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                incorrectInput = true;
            }
        } while (x > y || x > 1000 || x < 0 || incorrectInput);

        //initialization of the board and validations
        Board board = null;
        incorrectInput = false;
        do {
            if (incorrectInput) {
                System.out.println("Incorrect input!");
                incorrectInput = false;
            }
            System.out.println("Please fill the board: ");
            String[] rows = new String[y];
            for (int i = 0; i < y; i++) {
                rows[i] = input.nextLine();
            }
            try {
                board = new Board(x, y, rows);
            } catch (VariantNotFoundException | BoardNotCompatibleException e) {
                System.out.println(e.getMessage());
                incorrectInput = true;
            }
        } while (incorrectInput);

        //initialises and validates final set of variables
        int x1 = 0, y1 = 0, N = 0;
        incorrectInput = false;
        do {
            if (incorrectInput) {
                System.out.println("Incorrect input!");
                incorrectInput = false;
            }
            System.out.println("Please enter the position of the observed cell and iterations: ");
            String string = input.nextLine();
            String[] data = string.split(",");
            try {
                x1 = Integer.parseInt(data[0]);
                y1 = Integer.parseInt(data[1]);
                N = Integer.parseInt(data[2]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                incorrectInput = true;
            }
        } while (x1 < 0 || y1 < 0 || N<0 || x1 > x || y1 > y || incorrectInput);

        System.out.println("result: " + BoardService.countGenerationInWitchCellIsGreen(x1, y1, N, board));
    }

}
