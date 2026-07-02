package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>(); // Iniciando a lista de peças capturadas

       while (true) {
           try {
               UI.clearScreen(); // Chamando o método para limpar a tela
               UI.printMatch(chessMatch, captured);
               System.out.println();
               System.out.print("Source: ");
               ChessPosition source = UI.readChessPosition(sc); // sc = Scanner

               // Mostrando os possiveis movimentos de uma peça
               boolean[][] possibleMoves = chessMatch.possibleMoves(source);
               UI.clearScreen();
               UI.printBoard(chessMatch.getPieces(), possibleMoves);

               System.out.println();
               System.out.print("Target: ");
               ChessPosition target = UI.readChessPosition(sc);

               ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

               if (capturedPiece != null) {
                   captured.add(capturedPiece); // Adicionando as peças capturadas a lista CapturedPiece
               }
           }
           catch (ChessException e) {
               System.out.println(e.getMessage());
               sc.nextLine();
           }
           catch (InputMismatchException e) {
               System.out.println(e.getMessage());
               sc.nextLine();
           }
       }
    }
}
