package application;

import chess.ChessPiece;

public class UI {

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8 - i) + " "); // Imprimindo os numeros do tabuleiro
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]); // Imprimindo as peças
            }
            System.out.println(); // Para quebra de linha
        }
        System.out.println("  a b c d e f g h");

    }

    // Método auxiliar para imprimir uma peça
    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        }
        else {
            System.out.print(piece);
        }
        // Para as peças não ficarem grudadas umas nas outras
        System.out.print(" ");
    }
}
