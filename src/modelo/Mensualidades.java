/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Gunju
 */
public class Mensualidades {
    /**
     * Número único y consecutivo que identifica el recibo de mensualidad.
     */
    private int consecutivo;
    /**
     * Número del alquiler del cual se genera la cuota. Debe existir en el ArrayList de Alquileres.
     */
    private int numAlquiler;
    /**
     * Fecha en la que se generó la mensualidad. Se toma del sistema.
     */
    private LocalDate fechCreacion;
    /**
     * Nombre del inquilino responsable del alquiler, obtenido del registro de inquilino 
     */
    private String nomInquilino;
    /**
     * Mes que se cobra en el recibo
     */
    private int mesCobro;
    /**
     * Año en curso en el momento de generar la mensualidad
     */
    private int anioActual;
    /**
     * Porcentaje de descuento aplicado segun la temporada (0, 5 o 10)
     */
    private double descuento;
    /**
     * cuota mensual a pagar, ya con el descuento de temporada aplicado
     */
    private double montoMes;
    /** 
     * Estado actual de la mensualidad (Pendiente, Cancelado)
     */
    private String estado;
    /**
     * Lleva la cuenta para asignar un consecutivo unico a cada mensualidad
     */
    private static int consecutivoContador = 1;
    
    /**
     * crea una mensualidad vacia, con valores por defecto
     */
   public Mensualidades() {
    this.consecutivo = 0;
    this.numAlquiler = 0;
    this.fechCreacion = null;
    this.nomInquilino = "";
    this.mesCobro = 0;
    this.anioActual = 0;
    this.descuento = 0;
    this.montoMes = 0;
    this.estado = "";
}

    /**
     * Crea una mensualidad con todos sus datos. El consecutivo se genera automáticamente.
     *
     * @param numAlquiler número del alquiler al que pertenece la cuota
     * @param fechCreacion fecha en que se generó la mensualidad
     * @param nomInquilino nombre del inquilino responsable
     * @param mesCobro mes que se cobra (1 a 12)
     * @param anioActual año de la mensualidad
     * @param descuento porcentaje de descuento aplicado según temporada
     * @param montoMes cuota mensual a pagar
     * @param estado estado de la mensualidad (Pendiente, Cancelado)
     */
    
   public Mensualidades(int numAlquiler, LocalDate fechCreacion, String nomInquilino, 
        int mesCobro, int anioActual, double descuento, double montoMes, String estado) {
    this.consecutivo = generarConsecutivo();
    this.numAlquiler = numAlquiler;
    this.fechCreacion = fechCreacion;
    this.nomInquilino = nomInquilino;
    this.mesCobro = mesCobro;
    this.anioActual = anioActual;
    this.descuento = descuento;
    this.montoMes = montoMes;
    this.estado = estado;
}
    private static synchronized int generarConsecutivo() {
        return consecutivoContador++;
    }
    
    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getNomInquilino() {
        return nomInquilino;
    }

    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino;
    }

    public int getMesCobro() {
        return mesCobro;
    }

    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    public int getAnioActual() {
        return anioActual;
    }

    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontoMes() {
        return montoMes;
    }

    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Determina la temporada turistica segun el mes indicado.
     * Baja: Agosto, Septiembre, Octubre.
     * Media: Marzo, Abril, Mayo, Junio, Julio
     * Alta: Noviembre, Diciembre, Enero, Febrero
     * @param mes mes del año (1 a 12)
     * @return "Baja", "Media" o "Alta"
     */
    
    public static String obtenerTemporada(int mes){
        if (mes == 8 || mes == 9 || mes == 10 ){
            return "Baja";
        }else if (mes == 3 || mes == 4 || mes == 5 || mes == 6 || mes == 7){
            return "Media";
        }else if (mes == 11 || mes == 12 || mes == 1 || mes == 2){
            return "Alta";
        }else{
            throw new IllegalArgumentException("EL mes debe estar entre 1 y 12");
        }
    }
    /**
     * Obtiene el porcentaje de descuento que corresponde segun la temporada del mes
     * 
     * @param mes mes del año (1 al 12)
     * @return 10.0 en temporada baja, 5.0 en media, 0.0 en alta
     */
    
    public static double obtenerPorcentajeDescuento(int mes) {
        switch (obtenerTemporada(mes)) {
            case "Baja" -> {
                
                return 10.0;
            }
            case "Media" -> {
                
                return 5.0;
            }
            default -> {
                return 0.0; // Alta
            }
        }
    }
    /**
     * Verifica si ya existe una mensualidad para el mismo alquiler en el mismo mes/año,
     * para evitar registros duplicados.
     *
     * @param listaMensualidades lista actual de mensualidades
     * @param numAlquiler número del alquiler a verificar
     * @param mesCobro mes a verificar
     * @param anioActual año a verificar
     * @return true si ya existe una mensualidad para ese alquiler en ese mes/año
     */
    
    public static boolean existeMensualidad(ArrayList<Mensualidades> listaMensualidades, int numAlquiler, int mesCobro, int anioActual){
        for (Mensualidades m : listaMensualidades){
            if (m.getNumAlquiler() == numAlquiler && m.getMesCobro() == mesCobro && m.getAnioActual() == anioActual){
               return true; 
            }
        }
        return false;
    }
    /**
     * Verifica que el mes/año indicado no sea anterior al mes/año actual del sistema.
     *
     * @param mesCobro mes a validar
     * @param anioActual año a validar
     * @return true si la fecha es válida (mes actual o futuro)
     */
    
    public static boolean esFechaValida(int mesCobro, int anioActual){
        LocalDate hoy = LocalDate.now();
        LocalDate fechaSolicitada= LocalDate.of(anioActual, mesCobro, 1);
        LocalDate mesActual = LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1);
        return !fechaSolicitada.isBefore(mesActual);
        
    }
    /**
     * Genera automáticamente 1 mensualidad por cada alquiler vigente para el mes/año indicado,
     * aplicando el descuento de temporada correspondiente, y las agrega al ArrayList de mensualidades.
     *
     * @param listaAlquileres ArrayList de todos los alquileres registrados
     * @param listaInquilinos ArrayList de todos los inquilinos registrados
     * @param listaMensualidades ArrayList de mensualidades donde se insertarán los nuevos registros
     * @param mesCobro mes a generar (1 a 12)
     * @param anioActual año a generar
     * @return ArrayList con las mensualidades recién generadas
     * @throws Exception si el mes/año es anterior al actual
     */
    
   public static ArrayList<Mensualidades> generarMensualidades(ArrayList<Alquileres> listaAlquileres,
            ArrayList<Inquilino> listaInquilinos, ArrayList<Mensualidades> listaMensualidades,
            int mesCobro, int anioActual) throws Exception {

        if (!esFechaValida(mesCobro, anioActual)) {
            throw new Exception("No se pueden generar mensualidades para un mes/año anterior al actual.");
        }

        ArrayList<Mensualidades> generadas = new ArrayList<>();

        for (Alquileres alq : listaAlquileres) {
            if (!alq.getEstado().equalsIgnoreCase("Vigente")) {
                continue; // solo alquileres vigentes generan cuota
            }

            if (existeMensualidad(listaMensualidades, alq.getNumAlquiler(), mesCobro, anioActual)) {
                continue; // ya existe, no se duplica
            }

            String nombreInquilino = buscarNombreInquilino(listaInquilinos, alq.getCedInquilino());
            double porcDescuento = obtenerPorcentajeDescuento(mesCobro);
            double monto = alq.getPrecioAlquiler() - (alq.getPrecioAlquiler() * porcDescuento / 100.0);

            Mensualidades nueva = new Mensualidades(alq.getNumAlquiler(), LocalDate.now(), nombreInquilino,
                    mesCobro, anioActual, porcDescuento, monto, "Pendiente");

            listaMensualidades.add(nueva);
            generadas.add(nueva);
        }

        return generadas;
    }

    /**
     * Busca el nombre del inquilino a partir de su cédula.
     * Nota: cedInquilino en Alquileres es int y cedInqui en Inquilino es String, por eso se convierte.
     *
     * @param listaInquilinos ArrayList de inquilinos registrados
     * @param cedInquilino cédula del inquilino a buscar
     * @return el nombre del inquilino, o "Desconocido" si no se encuentra
     */
    private static String buscarNombreInquilino(ArrayList<Inquilino> listaInquilinos, int cedInquilino) {
        String cedBuscada = String.valueOf(cedInquilino);
        for (Inquilino inq : listaInquilinos) {
            if (inq.getCedInqui().equals(cedBuscada)) {
                return inq.getNomInqui();
            }
        }
        return "Desconocido";
    }

    /**
     * Texto que se muestra cuando se necesita ver la mensualidad como String.
     *
     * @return "Mensualidad #" seguido del consecutivo
     */
    @Override
    public String toString() {
        return "Mensualidad #" + consecutivo;
    }
}
