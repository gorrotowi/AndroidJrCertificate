package com.gorrotowi.dinamicfragment;

/**
 * Created by gorro on 07/10/15.
 */
public class Persona {

    private String nombre, telefono, twitter, correo;

    public Persona(String nombre, String telefono, String twitter, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.twitter = twitter;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
