package com.tetris;

import java.util.Random;

public class Juego {
    private final Board tablero;
    private final Reloj reloj;
    private boolean enEjecucion;
    private final Random random;

    public Juego(int ancho, int alto){
        this.tablero = new Board(ancho, alto);
        this.reloj = new Reloj();
        this.enEjecucion = false;
        this.random = new Random();
    }

    public void iniciar(){
        enEjecucion = true;
        crearYColocarPiezaAleatoria();
    }

    public void avanzarTick(){
        if(!enEjecucion) return;
        reloj.tick();
        if(tablero.obtenerPiezaActual() == null) {
            crearYColocarPiezaAleatoria();
        }
        tablero.moverAbajo();
    }

    
    private void crearYColocarPiezaAleatoria(){
        Pieza p = crearPiezaAleatoria();
    
        int rotaciones = random.nextInt(4);
        for(int i=0;i<rotaciones;i++) p.rotarDerecha();
        tablero.ponerPiezaActual(p);
    }

    private Pieza crearPiezaAleatoria(){
        int n = random.nextInt(7);
        switch(n){
            case 0: return new PieceStick();
            case 1: return new PieceSquare();
            case 2: return new PieceT();
            case 3: return new PieceDog();
           
        }
        return null;
    }

   public Board getTablero(){ return tablero; }
    public Reloj getReloj(){ return reloj; }
    public boolean isEnEjecucion(){ return enEjecucion; }
}
