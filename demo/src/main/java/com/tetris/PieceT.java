// File: src/main/java/com/tetris/PiezaT.java
package com.tetris;

public class PieceT extends Pieza {
    public PieceT(){
        super(3,3);
    }

    @Override
    public boolean[][] obtenerForma(){
        boolean[][] base = new boolean[3][3];
        switch(orientacion){
            case 0: // T con base abajo
                base[0][1] = true;
                base[1][0] = true; base[1][1] = true; base[1][2] = true;
                break;
            case 1: // T con base a la izquierda
                base[0][0] = true; base[1][0] = true; base[2][0] = true;
                base[1][1] = true;
                break;
            case 2: // T con base arriba
                base[2][1] = true;
                base[1][0] = true; base[1][1] = true; base[1][2] = true;
                break;
            case 3: // T con base a la derecha
                base[0][1] = true; base[1][1] = true; base[2][1] = true;
                base[1][0] = true;
                break;
        }
        return base;
    }
}
