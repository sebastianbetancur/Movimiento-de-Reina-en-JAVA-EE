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
public class FichaPosicion {

    private String tipoFicha;
    private Coordenada coordenada ;

    public FichaPosicion() {
    }

    public FichaPosicion(String tipoFicha, Coordenada coordenada) {
        this.tipoFicha = tipoFicha;
        this.coordenada = coordenada;
    }

    public String getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public String toString() {
        return "FichaPosicion{" + "tipoFicha=" + tipoFicha + ", coordenada=" + coordenada + '}';
    }

}
