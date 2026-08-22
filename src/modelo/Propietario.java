/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * * Representa a un propietario dentro del sistema de alquileres GuanaRent.
 * Contiene los datos personales necesarios para registrar, identificar
 * y contactar a la persona dueña de una o varias viviendas.
 * 
 * @author graci
 */
public class Propietario {
    
    /**
     * Cédula del propietario, usada como identificador único.
     */
    private String cedPropiet;
    
    /**
     * Nombre completo del propietario.
     */
    private String nomPropiet;
    
    /**
     * Género del propietario.
     */
    private String genero;
    
    /**
     * Dirección de residencia del propietario.
     */
    private String direccion;
    
    /**
     * Número de teléfono de contacto del propietario.
     */
    private String telefono;
    
    /**
     * Correo electrónico de contacto del propietario.
     */
    private String email;

    /**
     * Crea un propietario vacío, con todos sus atributos de texto
     * inicializados como cadena vacía.
     */
    public Propietario() {
        this.cedPropiet = "";
        this.nomPropiet = "";
        this.genero = "";
        this.direccion = "";
        this.telefono = "";
        this.email = "";
    }

     /**
     * Crea un propietario con todos sus datos ya definidos.
     *
     * @param cedPropiet cédula del propietario
     * @param nomPropiet nombre del propietario
     * @param genero género del propietario
     * @param direccion dirección del propietario
     * @param telefono teléfono del propietario
     * @param email correo electrónico del propietario
     */
    public Propietario(String cedPropiet, String nomPropiet, String genero, String direccion, String telefono, String email) {
        this.cedPropiet = cedPropiet;
        this.nomPropiet = nomPropiet;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene la cédula del propietario.
     *
     * @return la cédula del propietario
     */
    public String getCedPropiet() {
        return cedPropiet;
    }

    /**
     * Establece la cédula del propietario.
     *
     * @param cedPropiet la nueva cédula del propietario
     */
    public void setCedPropiet(String cedPropiet) {
        this.cedPropiet = cedPropiet;
    }

    /**
     * Obtiene el nombre del propietario.
     *
     * @return el nombre del propietario
     */
    public String getNomPropiet() {
        return nomPropiet;
    }

    /**
     * Establece el nombre del propietario.
     *
     * @param nomPropiet el nuevo nombre del propietario
     */
    public void setNomPropiet(String nomPropiet) {
        this.nomPropiet = nomPropiet;
    }

    /**
     * Obtiene el género del propietario.
     *
     * @return el género del propietario
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del propietario.
     *
     * @param genero el nuevo género del propietario
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección del propietario.
     *
     * @return la dirección del propietario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del propietario.
     *
     * @param direccion la nueva dirección del propietario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene el teléfono del propietario.
     *
     * @return el teléfono del propietario
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece el teléfono del propietario.
     *
     * @param telefono el nuevo teléfono del propietario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el correo electrónico del propietario.
     *
     * @return el correo electrónico del propietario
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece el correo electrónico del propietario.
     *
     * @param email el nuevo correo electrónico del propietario
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Devuelve una representación textual del propietario, usando su nombre.
     * Esto permite que el propietario se muestre correctamente cuando se
     * agrega a componentes visuales como un JComboBox.
     *
     * @return el nombre del propietario
     */
    @Override
    public String toString() {
        return nomPropiet;
    }
}
