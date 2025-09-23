// File: src/main/java/com/tetris/PiezaO.java
package com.tetris;

public class PieceSquare extends Pieza {
    public PieceSquare(){
        super(2,2);
    }

    @Override
    public boolean[][] obtenerForma(){
        boolean[][] base = new boolean[2][2];
        base[0][0] = true;
        base[0][1] = true;
        base[1][0] = true;
        base[1][1] = true;
        return base;
    }
}
