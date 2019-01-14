/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajedrez.modelo;

/**
 *
 * @author sebas
 */
public class Coordenada {
    
    private byte columna ;
    private byte fila;

    public Coordenada() {
    }

    public Coordenada(byte fila ,byte columna) {
        this.columna = columna;
        this.fila = fila;
    }

    public byte getColumna() {
        return columna;
    }

    public void setColumna(byte columna) {
        this.columna = columna;
    }

    public byte getFila() {
        return fila;
    }

    public void setFila(byte fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "columna=" + columna + ", fila=" + fila + '}';
    }
}
