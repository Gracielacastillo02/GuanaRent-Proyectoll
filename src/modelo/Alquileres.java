/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 * Representa un contrato de alquiler entre un inquilino y una vivienda de GuanaRent, incluyendo los alquileres ya vencidos. 
 * El inquilino y la vivienda deben existir previamente en el sistema.
 *
 * @author Erick
 */
public class Alquileres {

    /**
     * Número consecutivo y único que identifica el alquiler. Es como el id del alquiler.
     */
    private int numAlquiler;

    /**
     * Fecha en la que se firmó el contrato de alquiler.
     */
    private LocalDate fechaContrato;

    /**
     * Vigencia en meses del contrato.
     */
    private int cantMeses;

    /**
     * Cantidad de personas adultas que vivirán en la vivienda alquilada.
     */
    private int numAdultos;

    /**
     * Cantidad de niños que vivirán en la vivienda alquilada.
     */
    private int numNinios;

    /**
     * Monto pagado por adelantado por el inquilino como garantía.
     */
    private double depositoGarantia;

    /**
     * Precio de alquiler mensual pactado entre propietario e inquilino.
     */
    private double precioAlquiler;

    /**
     * Porcentaje de incremento anual del precio de alquiler (de 1 a 30%).
     */
    private double porcIncremAnual; //de 1 a 30%

    /**
     * Cédula del inquilino que arrienda la vivienda; debe existir en el ArrayList de Inquilinos.
     */
    private int cedInqui;

    /**
     * Id de la vivienda alquilada; debe existir en el ArrayList de Viviendas.
     */
    private int idVivienda;

    /**
     * Estado del contrato de alquiler (vigente, vencido, cancelado).
     */
    private String estado; // vigente, vencido, cancelado

    /**
     * Lleva la cuenta para asignar un número único a cada alquiler nuevo.
     */
    private static int consecutivo = 1;

    /**
     * Crea un alquiler vacío, con valores por defecto.
     */
    public Alquileres() {
        this.numAlquiler = 0;
        this.fechaContrato = null;
        this.cantMeses = 0;
        this.numAdultos = 0;
        this.numNinios = 0;
        this.depositoGarantia = 0;
        this.precioAlquiler = 0;
        this.porcIncremAnual = 0;
        this.cedInqui = 0;
        this.idVivienda = 0;
        this.estado = "";
    }

    /**
     * Crea un alquiler con todos sus datos. El numAlquiler se genera automáticamente mediante un consecutivo único.
     *
     * @param fechaContrato fecha en que se firmó el contrato
     * @param cantMeses vigencia en meses del contrato
     * @param numAdultos cantidad de adultos que vivirán en la vivienda
     * @param numNinios cantidad de niños que vivirán en la vivienda
     * @param depositoGarantia monto pagado por adelantado como garantía
     * @param precioAlquiler precio de alquiler mensual pactado
     * @param porcIncremAnual porcentaje de incremento anual (1 a 30)
     * @param cedInqui cédula del inquilino, debe existir previamente
     * @param idVivienda id de la vivienda, debe existir previamente
     * @param estado estado del contrato (vigente, vencido, cancelado)
     */
    public Alquileres(LocalDate fechaContrato, int cantMeses, int numAdultos, int numNinios, double depositoGarantia,
            double precioAlquiler, double porcIncremAnual, int cedInqui, int idVivienda, String estado) {

        this.numAlquiler = generarConsecutivo();
        this.fechaContrato = fechaContrato;
        this.cantMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinios = numNinios;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.cedInqui = cedInqui;
        this.idVivienda = idVivienda;
        this.estado = estado;
    }

    /**
     * Genera un número nuevo para el próximo alquiler, sin repetir.
     *
     * @return el número asignado al alquiler
     */
    private static synchronized int generarConsecutivo() {
        return consecutivo++;
    }

    /**
     * Obtiene el número identificador del alquiler.
     *
     * @return el numAlquiler
     */
    public int getNumAlquiler() {
        return numAlquiler;
    }

    /**
     * Asigna el número identificador del alquiler.
     *
     * @param numAlquiler el numAlquiler a asignar
     */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    /**
     * Obtiene la fecha del contrato.
     *
     * @return la fechaContrato
     */
    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    /**
     * Asigna la fecha del contrato.
     *
     * @param fechaContrato la fechaContrato a asignar
     */
    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    /**
     * Obtiene la cantidad de meses de vigencia del contrato.
     *
     * @return los cantMeses
     */
    public int getCantMeses() {
        return cantMeses;
    }

    /**
     * Asigna la cantidad de meses de vigencia del contrato.
     *
     * @param cantMeses los cantMeses a asignar
     */
    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }

    /**
     * Obtiene la cantidad de adultos que vivirán en la vivienda.
     *
     * @return los numAdultos
     */
    public int getNumAdultos() {
        return numAdultos;
    }

    /**
     * Asigna la cantidad de adultos que vivirán en la vivienda.
     *
     * @param numAdultos los numAdultos a asignar
     */
    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    /**
     * Obtiene la cantidad de niños que vivirán en la vivienda.
     *
     * @return los numNinios
     */
    public int getNumNinios() {
        return numNinios;
    }

    /**
     * Asigna la cantidad de niños que vivirán en la vivienda.
     *
     * @param numNinios los numNinios a asignar
     */
    public void setNumNinios(int numNinios) {
        this.numNinios = numNinios;
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
     * Obtiene el precio de alquiler mensual pactado.
     *
     * @return el precioAlquiler
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    /**
     * Asigna el precio de alquiler mensual pactado.
     *
     * @param precioAlquiler el precioAlquiler a asignar
     */
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    /**
     * Obtiene el porcentaje de incremento anual.
     *
     * @return el porcIncremAnual
     */
    public double getPorcIncremAnual() {
        return porcIncremAnual;
    }

    /**
     * Asigna el porcentaje de incremento anual. Debe estar entre 1 y 30.
     *
     * @param porcIncremAnual el porcIncremAnual a asignar
     */
    public void setPorcIncremAnual(double porcIncremAnual) {
        this.porcIncremAnual = porcIncremAnual;
    }

    /**
     * Obtiene la cédula del inquilino.
     *
     * @return la cedInqui
     */
    public int getCedInquilino() {
        return cedInqui;
    }

    /**
     * Asigna la cédula del inquilino. Debe existir previamente en el registro de inquilinos.
     *
     * @param cedInqui la cedInqui a asignar
     */
    public void setCedInquilino(int cedInqui) {
        this.cedInqui = cedInqui;
    }

    /**
     * Obtiene el id de la vivienda alquilada.
     *
     * @return el idVivienda
     */
    public int getIdVivienda() {
        return idVivienda;
    }

    /**
     * Asigna el id de la vivienda alquilada. Debe existir previamente en el registro de viviendas.
     *
     * @param idVivienda el idVivienda a asignar
     */
    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * Obtiene el estado del contrato de alquiler.
     *
     * @return el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado del contrato de alquiler.
     *
     * @param estado el estado a asignar
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Texto que se muestra cuando se necesita ver el alquiler como String, por ejemplo en una lista desplegable.
     *
     * @return el texto "Alquiler #" seguido del número
     */
    @Override
    public String toString() {
        return "Alquiler #" + numAlquiler;
    }
}
