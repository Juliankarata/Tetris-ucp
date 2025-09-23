// File: src/main/java/com/tetris/PiezaI.java
package com.tetris;

public class PieceStick extends Pieza {
    public PieceStick(){
        super(4,4);
    }

    @Override
    public boolean[][] obtenerForma(){
        boolean[][] base = new boolean[4][4];
        switch(orientacion){
            case 0:
            case 2: // horizontal
                base[1][0] = true;
                base[1][1] = true;
                base[1][2] = true;
                base[1][3] = true;
                break;
            case 1:
            case 3: // vertical
                base[0][2] = true;
                base[1][2] = true;
                base[2][2] = true;
                base[3][2] = true;
                break;
        }
        return base;
    }
}
