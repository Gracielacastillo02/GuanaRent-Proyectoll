/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa una vivienda que la empresa GuanaRent tiene disponible, alquilada o inactiva. 
 * Cada vivienda pertenece a un propietario que debe existir previamente en el sistema.
 *
 * @author Erick
 */
public class Vivienda {

    /**
     * Identificador único de la vivienda, generado automáticamente.
     */
    private int idVivienda;

    /**
     * Nombre o descripción que identifica la vivienda.
     */
    private String descripcion;

    /**
     * Dirección completa de ubicación de la vivienda.
     */
    private String direccion;

    /**
     * Cantidad de metros cuadrados de construcción.
     */
    private double mtsConstruc;

    /**
     * Cantidad de metros cuadrados del lote donde está construida la casa.
     */
    private double mtsLote;

    /**
     * Tipo de material de construcción (Block, Baldosa, super block, madera, mixta).
     */
    private String materialConstruc;

    /**
     * Indica si la vivienda tiene cochera o no.
     */
    private boolean cochera;

    /**
     * Cantidad de habitaciones que posee la casa.
     */
    private int cantHabitac;

    /**
     * Cantidad de baños que posee la casa (admite valores decimales, ej. 1.5).
     */
    private double cantBanios;

    /**
     * Tipo de carretera de acceso (lastre, pavimento, etc).
     */
    private String carretera;

    /**
     * Precio base de alquiler fijado por el propietario.
     */
    private double precioBase;

    /**
     * Monto cobrado por adelantado como garantía.
     */
    private double depositoGarantia;

    /**
     * Propietario dueño de la vivienda. Debe existir previamente en el registro de propietarios.
     */
    private Propietario propietario;

    /**
     * Estado actual de la vivienda (disponible, alquilada, inactiva).
     */
    private String estado;

    /**
     * Lleva la cuenta para asignar un número único a cada vivienda nueva.
     */
    private static int consecutivo = 1;

    /**
     * Crea una vivienda vacía, con valores por defecto.
     */
    public Vivienda() {
        this.idVivienda = 0;
        this.descripcion = "";
        this.direccion = "";
        this.mtsConstruc = 0;
        this.mtsLote = 0;
        this.materialConstruc = "";
        this.cochera = false;
        this.cantHabitac = 0;
        this.cantBanios = 0;
        this.carretera = "";
        this.precioBase = 0;
        this.depositoGarantia = 0;
        this.propietario = null;
        this.estado = "";
    }

    /**
     * Crea una vivienda con todos sus datos. El idVivienda se genera automáticamente mediante un consecutivo único.
     *
     * @param descripcion nombre o descripción de la vivienda
     * @param direccion dirección completa de ubicación
     * @param mtsConstruc metros cuadrados de construcción
     * @param mtsLote metros cuadrados del lote
     * @param materialConstruc tipo de material de construcción
     * @param cochera si la vivienda tiene cochera
     * @param cantHabitac cantidad de habitaciones
     * @param cantBanios cantidad de baños (puede ser decimal)
     * @param carretera tipo de carretera de acceso
     * @param precioBase precio base de alquiler
     * @param depositoGarantia monto del depósito de garantía
     * @param propietario propietario dueño de la vivienda, debe existir previamente
     * @param estado estado actual de la vivienda
     */
    public Vivienda(String descripcion, String direccion, double mtsConstruc, double mtsLote, String materialConstruc, boolean cochera, int cantHabitac, double cantBanios, String carretera, double precioBase, double depositoGarantia, Propietario propietario, String estado) {
        this.idVivienda = generarConsecutivo();
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstruc = mtsConstruc;
        this.mtsLote = mtsLote;
        this.materialConstruc = materialConstruc;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }

    /**
     * Genera un número nuevo para la próxima vivienda, sin repetir.
     *
     * @return el número asignado a la vivienda
     */
    private static synchronized int generarConsecutivo() {
        return consecutivo++;
    }

    /**
     * Obtiene el identificador único de la vivienda.
     *
     * @return el idVivienda
     */
    public int getIdVivienda() {
        return idVivienda;
    }

    /**
     * Asigna el identificador único de la vivienda.
     *
     * @param idVivienda el idVivienda a asignar
     */
    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * Obtiene la descripción de la vivienda.
     *
     * @return la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción de la vivienda.
     *
     * @param descripcion la descripcion a asignar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la dirección de la vivienda.
     *
     * @return la direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna la dirección de la vivienda.
     *
     * @param direccion la direccion a asignar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene los metros cuadrados de construcción.
     *
     * @return los mtsConstruc
     */
    public double getMtsConstruc() {
        return mtsConstruc;
    }

    /**
     * Asigna los metros cuadrados de construcción.
     *
     * @param mtsConstruc los mtsConstruc a asignar
     */
    public void setMtsConstruc(double mtsConstruc) {
        this.mtsConstruc = mtsConstruc;
    }

    /**
     * Obtiene los metros cuadrados del lote.
     *
     * @return los mtsLote
     */
    public double getMtsLote() {
        return mtsLote;
    }

    /**
     * Asigna los metros cuadrados del lote.
     *
     * @param mtsLote los mtsLote a asignar
     */
    public void setMtsLote(double mtsLote) {
        this.mtsLote = mtsLote;
    }

    /**
     * Obtiene el tipo de material de construcción.
     *
     * @return el materialConstruc
     */
    public String getMaterialConstruc() {
        return materialConstruc;
    }

    /**
     * Asigna el tipo de material de construcción.
     *
     * @param materialConstruc el materialConstruc a asignar
     */
    public void setMaterialConstruc(String materialConstruc) {
        this.materialConstruc = materialConstruc;
    }

    /**
     * Indica si la vivienda tiene cochera.
     *
     * @return true si tiene cochera, false en caso contrario
     */
    public boolean isCochera() {
        return cochera;
    }

    /**
     * Asigna si la vivienda tiene cochera.
     *
     * @param cochera true si tiene cochera
     */
    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    /**
     * Obtiene la cantidad de habitaciones.
     *
     * @return los cantHabitac
     */
    public int getCantHabitac() {
        return cantHabitac;
    }

    /**
     * Asigna la cantidad de habitaciones.
     *
     * @param cantHabitac los cantHabitac a asignar
     */
    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    /**
     * Obtiene la cantidad de baños.
     *
     * @return los cantBanios
     */
    public double getCantBanios() {
        return cantBanios;
    }

    /**
     * Asigna la cantidad de baños.
     *
     * @param cantBanios los cantBanios a asignar
     */
    public void setCantBanios(double cantBanios) {
        this.cantBanios = cantBanios;
    }

    /**
     * Obtiene el tipo de carretera de acceso.
     *
     * @return la carretera
     */
    public String getCarretera() {
        return carretera;
    }

    /**
     * Asigna el tipo de carretera de acceso.
     *
     * @param carretera la carretera a asignar
     */
    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    /**
     * Obtiene el precio base de alquiler.
     *
     * @return el precioBase
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Asigna el precio base de alquiler.
     *
     * @param precioBase el precioBase a asignar
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el monto del depósito de garantía.
     *
     * @return el depositoGarantia
     */
    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    /**
     * Asigna el monto del depósito de garantía.
     *
     * @param depositoGarantia el depositoGarantia a asignar
     */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    /**
     * Obtiene el propietario dueño de la vivienda.
     *
     * @return el propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Asigna el propietario dueño de la vivienda.
     * Debe existir previamente en el registro de propietarios.
     *
     * @param propietario el propietario a asignar
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Obtiene el estado actual de la vivienda.
     *
     * @return el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado actual de la vivienda.
     *
     * @param estado el estado a asignar
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Texto que se muestra cuando se necesita ver la vivienda como String, por ejemplo en una lista desplegable.
     *
     * @return la descripción de la vivienda
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
