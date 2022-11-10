package BuilderPrototipo.objetos;

import java.util.Arrays;

public class Tablero implements IComponenteTablero {

    private static final int BOARD_LENGTH = 20;
    private IComponenteTablero[][] boardSquares = new IComponenteTablero[BOARD_LENGTH][BOARD_LENGTH];

    public Tablero() {
    }

    public Tablero(IComponenteTablero[][] cuadrados) {
        setBoardSquares(cuadrados);
    }

    public void setBoardSquares(IComponenteTablero[][] cuadrados) {
        this.boardSquares = cuadrados;
    }

    public IComponenteTablero[][] getBoardSquares() {
        return boardSquares;
    }

    public void printBoard() {
        for (IComponenteTablero[] row : boardSquares) {
            for (IComponenteTablero square : row) {
                System.out.println(square);
            }
            System.out.println();
        }
    }

    @Override
    public void agregarComponente(IComponenteTablero pComponente) throws Exception {
        throw new Exception("La función no está soportada.");
    }

    @Override
    public String mostrarInformacion() {
        return "Tablero [boardSquares=" + Arrays.toString(boardSquares) + "]";
    }
}
