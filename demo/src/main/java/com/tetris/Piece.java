// File: src/main/java/com/tetris/Pieza.java
package com.tetris;

public abstract class Piece {
    protected int filas;       // alto de la matriz de la forma
    protected int columnas;    // ancho de la matriz de la forma
    protected int orientacion; // 0,1,2,3 (rotaciones de 90°)

    protected Piece(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.orientacion = 0; // empieza sin rotación
    }

    // Devuelve la matriz booleana con la forma actual de la pieza
    public abstract boolean[][] obtenerForma();

    // Rota 90° a la derecha
    public void rotarDerecha(){
        orientacion = (orientacion + 1) % 4;
    }

    // Rota 90° a la izquierda
    public void rotarIzquierda(){
        orientacion = (orientacion + 3) % 4;
    }

    public int getOrientacion(){
        return orientacion;
    }
}
