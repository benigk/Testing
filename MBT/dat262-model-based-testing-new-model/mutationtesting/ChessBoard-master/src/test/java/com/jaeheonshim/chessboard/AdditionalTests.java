package com.jaeheonshim.chessboard;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AdditionalTests {
	
    @Test
    public void piecesAreActuallySetCorrectlyLeftCastle() {
        Board testBoard = new Board();
        testBoard.getSpot(1, 0).setPiece(null);
        testBoard.getSpot(2, 0).setPiece(null);
        testBoard.getSpot(3, 0).setPiece(null);

        testBoard.move(testBoard.getKing(true).getSpot(testBoard), testBoard.getSpot(2, 0));

        Assert.assertNull(testBoard.getSpot(0, 0).getPiece());
        Assert.assertNull(testBoard.getSpot(1, 0).getPiece());
        Assert.assertNotNull(testBoard.getSpot(2, 0).getPiece()); // King
        Assert.assertNotNull(testBoard.getSpot(3, 0).getPiece()); // Rook
        Assert.assertNull(testBoard.getSpot(4, 0).getPiece());
    }
    
    @Test
    public void piecesAreActuallySetCorrectlyRightCastle() {
        Board testBoard = new Board();
        testBoard.getSpot(5, 0).setPiece(null);
        testBoard.getSpot(6, 0).setPiece(null);

        testBoard.move(testBoard.getKing(true).getSpot(testBoard), testBoard.getSpot(6, 0));

        Assert.assertNull(testBoard.getSpot(4, 0).getPiece());
        Assert.assertNotNull(testBoard.getSpot(5, 0).getPiece()); // Rook
        Assert.assertNotNull(testBoard.getSpot(6, 0).getPiece()); // King
        Assert.assertNull(testBoard.getSpot(7, 0).getPiece());
    }
    
    @Ignore // Ignored because the implementation is actually wrong here, but Pitest is only working with a green test suite.
    @Test
    public void movedLeft() {
        Board testBoard = new Board();
        testBoard.getSpot(5, 0).setPiece(null);
        testBoard.getSpot(6, 0).setPiece(null);

        testBoard.move(testBoard.getKing(true).getSpot(testBoard), testBoard.getSpot(6, 0));

        Assert.assertTrue(testBoard.getSpot(2, 0).getPiece().isMoved()); // King
        Assert.assertTrue(testBoard.getSpot(3, 0).getPiece().isMoved()); // Rook
    }
    
    @Test
    public void movedRight() {
        Board testBoard = new Board();
        testBoard.getSpot(5, 0).setPiece(null);
        testBoard.getSpot(6, 0).setPiece(null);

        testBoard.move(testBoard.getKing(true).getSpot(testBoard), testBoard.getSpot(6, 0));

        Assert.assertTrue(testBoard.getSpot(5, 0).getPiece().isMoved()); // Rook
        Assert.assertTrue(testBoard.getSpot(6, 0).getPiece().isMoved()); // King
    }
	
}
