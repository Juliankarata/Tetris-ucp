// File: src/main/java/com/tetris/PiezaL.java
package com.tetris;

public class PiezaL extends Pieza {
    public PiezaL(){
        super(3,3);
    }

    @Override
    public boolean[][] obtenerForma(){
        boolean[][] base = new boolean[3][3];
        switch(orientacion){
            case 0: // L normal
                base[0][0] = true;
                base[1][0] = true;
                base[2][0] = true; base[2][1] = true;
                break;
            case 1: // L rotada 90
                base[2][0] = true; base[2][1] = true; base[2][2] = true;
                base[1][2] = true;
                break;
            case 2: // L rotada 180
                base[0][1] = true; base[0][2] = true;
                base[1][2] = true;
                base[2][2] = true;
                break;
            case 3: // L rotada 270
                base[0][0] = true; base[0][1] = true; base[0][2] = true;
                base[1][0] = true;
                break;
        }
        return base;
    }
}
