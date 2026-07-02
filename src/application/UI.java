package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // método para limpar a tela do terminal, e a deixar menos poluida
    //
    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método para ler a posição inserida pela usuário
    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    // Método para printar a partida
    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured); // Printando a lista de peças capturadas
        System.out.println();
        System.out.println("Turn :" + chessMatch.getTurn());
        System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
    }
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8 - i) + " "); // Imprimindo os numeros do tabuleiro
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false); // Imprimindo as peças
            }
            System.out.println(); // Para quebra de linha
        }
        System.out.println("  a b c d e f g h");

    }

    // Printando na tela as possiveis movimentações de uma peça
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8 - i) + " "); // Imprimindo os numeros do tabuleiro
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]); // Imprimindo as peças
            }
            System.out.println(); // Para quebra de linha
        }
        System.out.println("  a b c d e f g h");

    }

    // Método auxiliar para imprimir uma peça
    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND); // Colorindo as possiveis movimentações de uma peça
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    // Imprime na tela as peças capturadas

    private static void printCapturedPieces(List<ChessPiece> captured) {

        // Filtrando as peças capturadas
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());

        // Lógica de imprimir na tela as peças capturadas
        System.out.println("Captured pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE); // Escolhendo a cor branca para usar no print
        System.out.println(Arrays.toString(white.toArray())); // Lista das peças brancas
        System.out.print(ANSI_RESET); // Limpando a cor escolhida
        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW); // Escolhendo a cor branca para usar no print
        System.out.println(Arrays.toString(black.toArray())); // Lista das peças brancas
        System.out.print(ANSI_RESET); // Limpando a cor escolhida

    }
}
