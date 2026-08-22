/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * Representa a un inquilino dentro del sistema de alquileres GuanaRent.
 * Contiene los datos personales necesarios para registrar, identificar
 * y contactar a la persona que alquila una vivienda.
 * 
 * @author graci
 */
public class Inquilino {
    /**
     * Número de cédula del inquilino. Se utiliza como identificador único.
     */
    private String cedInqui;
    
    /**
     * Nombre completo del inquilino.
     */
    private String nomInqui;
    
    /**
     * Género del inquilino.
     */
    private String genero;
    
    /**
     * Fecha de nacimiento del inquilino.
     */
    private LocalDate fechNac;
    
    /**
     * Dirección de residencia del inquilino.
     */
    private String direccion;
    
     /**
     * Número de teléfono de contacto del inquilino.
     */
    private String telefono;
    
    /**
     * Correo electrónico de contacto del inquilino.
     */
    private String email;
    
    /**
     * Ocupación o profesión del inquilino.
     */
    private String ocupacion;
    
    /**
     * Crea un inquilino vacío, con los atributos de texto inicializados
     * como cadena vacía y la fecha de nacimiento en null.
     */
    public Inquilino() {
        this.cedInqui = "";
        this.nomInqui = "";
        this.genero = "";
        this.fechNac = null;
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.ocupacion = "";
    }
    
    /**
     * Crea un inquilino con todos sus datos ya definidos.
     *
     * @param cedInqui cédula del inquilino
     * @param nomInqui nombre del inquilino
     * @param genero género del inquilino
     * @param fechNac fecha de nacimiento del inquilino
     * @param direccion dirección del inquilino
     * @param telefono teléfono del inquilino
     * @param email correo electrónico del inquilino
     * @param ocupacion ocupación del inquilino
     */
    public Inquilino(String cedInqui, String nomInqui, String genero, LocalDate fechNac, String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }

    /**
     * Obtiene la cédula del inquilino.
     *
     * @return la cédula del inquilino
     */
    public String getCedInqui() {
        return cedInqui;
    }

    /**
     * Establece la cédula del inquilino.
     *
     * @param cedInqui la nueva cédula del inquilino
     */
    public void setCedInqui(String cedInqui) {
        this.cedInqui = cedInqui;
    }

    /**
     * Obtiene el nombre del inquilino.
     *
     * @return el nombre del inquilino
     */
    public String getNomInqui() {
        return nomInqui;
    }

    /**
     * Establece el nombre del inquilino.
     *
     * @param nomInqui el nuevo nombre del inquilino
     */
    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    /**
     * Obtiene el género del inquilino.
     *
     * @return el género del inquilino
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del inquilino.
     *
     * @param genero el nuevo género del inquilino
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento del inquilino.
     *
     * @return la fecha de nacimiento del inquilino
     */
    public LocalDate getFechNac() {
        return fechNac;
    }

    /**
     * Establece la fecha de nacimiento del inquilino.
     *
     * @param fechNac la nueva fecha de nacimiento del inquilino
     */
    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

    /**
     * Obtiene la dirección de residencia del inquilino.
     *
     * @return la dirección del inquilino
     */
    public String getDireccion() {
        return direccion;
    }

     /**
     * Establece la dirección de residencia del inquilino.
     *
     * @param direccion la nueva dirección del inquilino
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene el teléfono de contacto del inquilino.
     *
     * @return el teléfono del inquilino
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece el teléfono de contacto del inquilino.
     *
     * @param telefono el nuevo teléfono del inquilino
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del inquilino.
     *
     * @return el correo electrónico del inquilino
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del inquilino.
     *
     * @param email el nuevo correo electrónico del inquilino
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la ocupación del inquilino.
     *
     * @return la ocupación del inquilino
     */
    public String getOcupacion() {
        return ocupacion;
    }
    
    /**
     * Establece la ocupación del inquilino.
     *
     * @param ocupacion la nueva ocupación del inquilino
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    /**
     * Devuelve una representación textual del inquilino, usando su nombre.
     * 
     * @return el nombre del inquilino, usado para mostrarlo en componentes
     * visuales como un JComboBox
     */
    @Override
    public String toString() {
        return nomInqui;
    }
}
