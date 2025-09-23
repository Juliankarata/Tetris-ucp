package com.tetris;

import java.util.Arrays;

public class Board {
    private final int ancho;
    private final int alto;
    private boolean[][] grilla; // true = celda ocupada
    private Pieza piezaActual;
    private int piezaFila;     // fila superior donde está la pieza actual
    private int piezaColumna;  // columna izquierda donde está la pieza actual

    public Board(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        this.grilla = new boolean[alto][ancho];
        for(int i=0; i<alto; i++) Arrays.fill(this.grilla[i], false);
    }

    public int getAncho(){ return ancho; }
    public int getAlto(){ return alto; }

    // Representación en texto (para debug y tests)
    public String formato(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<alto; r++){
            for(int c=0; c<ancho; c++){
                sb.append(grilla[r][c] ? "X" : ".");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    // Coloca una nueva pieza en el tablero
    public void ponerPiezaActual(Pieza pieza){
        this.piezaActual = pieza;
        this.piezaFila = 0;
        this.piezaColumna = Math.max(0, (ancho - pieza.obtenerForma()[0].length) / 2);
    }

    public Pieza obtenerPiezaActual(){ return piezaActual; }

    // Intenta mover la pieza una fila hacia abajo
    // Si no puede, la fija en la grilla y la elimina como pieza actual
    public boolean moverAbajo(){
        if(piezaActual == null) return false;
        if(puedeMoverAbajo()){
            piezaFila++;
            return true;
        } else {
            fijarPiezaEnGrilla();
            eliminarLineasCompletas();
            piezaActual = null;
            return false;
        }
    }

    // Comprueba límites y colisiones
    public boolean puedeMoverAbajo(){
        boolean[][] forma = piezaActual.obtenerForma();
        int filas = forma.length;
        int cols = forma[0].length;

        for(int r=0; r<filas; r++){
            for(int c=0; c<cols; c++){
                if(!forma[r][c]) continue;
                int grFila = piezaFila + r + 1;
                int grCol = piezaColumna + c;
                if(grFila >= alto) return false;
                if(grilla[grFila][grCol]) return false;
            }
        }
        return true;
    }

    // Fija la pieza en la grilla
    private void fijarPiezaEnGrilla(){
        boolean[][] forma = piezaActual.obtenerForma();
        for(int r=0; r<forma.length; r++){
            for(int c=0; c<forma[0].length; c++){
                if(forma[r][c]){
                    int grFila = piezaFila + r;
                    int grCol = piezaColumna + c;
                    if(grFila >= 0 && grFila < alto && grCol >= 0 && grCol < ancho){
                        grilla[grFila][grCol] = true;
                    }
                }
            }
        }
    }

    // Elimina líneas completas y devuelve cuántas eliminó
    public int eliminarLineasCompletas(){
        int eliminadas = 0;
        for(int r=0; r<alto; r++){
            boolean completa = true;
            for(int c=0; c<ancho; c++){
                if(!grilla[r][c]){
                    completa = false;
                    break;
                }
            }
            if(completa){
                eliminadas++;
                for(int rr=r; rr>0; rr--){
                    grilla[rr] = Arrays.copyOf(grilla[rr-1], ancho);
                }
                grilla[0] = new boolean[ancho]; // fila vacía arriba
            }
        }
        return eliminadas;
    }
}
