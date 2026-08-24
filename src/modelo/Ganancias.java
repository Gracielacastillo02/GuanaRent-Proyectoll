package modelo;

import java.util.ArrayList;

/**
 * Clase de utilidad que calcula las ganancias de la empresa GuanaRent.
 * GuanaRent gana la mitad del depósito de garantía de cada alquiler
 * y un 7% de cada mensualidad de las casas con alquiler activo (Vigente).
 *
 * @author Anais
 */
public class Ganancias {

    /**
     * Porcentaje que gana GuanaRent de cada mensualidad cobrada.
     */
    private static final double PORC_GANANCIA_MENSUALIDAD = 7.0;

    /**
     * Constructor privado: esta clase es de utilidad y no debe instanciarse.
     */
    private Ganancias() {
        // Clase de utilidad, no se debe instanciar
    }

    /**
     * Calcula la ganancia por depósitos de garantía (la mitad de cada uno)
     * de los alquileres firmados en el año indicado.
     *
     * @param listaAlquileres ArrayList con todos los alquileres registrados
     * @param anio año a consultar
     * @param mes mes a consultar (1 a 12), o null para considerar el año completo
     * @return la ganancia total por depósitos en ese periodo
     */
    public static double calcularGananciaDepositos(ArrayList<Alquileres> listaAlquileres, int anio, Integer mes) {
        double total = 0;
        for (Alquileres alq : listaAlquileres) {
            if (alq.getFechaContrato().getYear() == anio) {
                if (mes == null || alq.getFechaContrato().getMonthValue() == mes) {
                    total += alq.getDepositoGarantia() / 2.0;
                }
            }
        }
        return total;
    }

    /**
     * Calcula la ganancia por el 7% de cada mensualidad cobrada en el periodo indicado,
     * considerando solo las mensualidades de alquileres con estado "Vigente".
     *
     * @param listaMensualidades ArrayList con todas las mensualidades registradas
     * @param listaAlquileres ArrayList con todos los alquileres registrados
     * @param anio año a consultar
     * @param mes mes a consultar (1 a 12), o null para considerar el año completo
     * @return la ganancia total por mensualidades en ese periodo
     */
    public static double calcularGananciaMensualidades(ArrayList<Mensualidades> listaMensualidades,
            ArrayList<Alquileres> listaAlquileres, int anio, Integer mes) {
        double total = 0;
        for (Mensualidades m : listaMensualidades) {
            if (m.getAnioActual() == anio) {
                if (mes == null || m.getMesCobro() == mes) {
                    if (alquilerEstaVigente(listaAlquileres, m.getNumAlquiler())) {
                        total += m.getMontoMes() * (PORC_GANANCIA_MENSUALIDAD / 100.0);
                    }
                }
            }
        }
        return total;
    }

    /**
     * Busca un alquiler por su número y verifica si su estado es "Vigente".
     *
     * @param listaAlquileres ArrayList con todos los alquileres registrados
     * @param numAlquiler número del alquiler a verificar
     * @return true si el alquiler existe y está en estado Vigente
     */
    private static boolean alquilerEstaVigente(ArrayList<Alquileres> listaAlquileres, int numAlquiler) {
        for (Alquileres alq : listaAlquileres) {
            if (alq.getNumAlquiler() == numAlquiler) {
                return alq.getEstado().equalsIgnoreCase("Vigente");
            }
        }
        return false;
    }

    /**
     * Calcula la ganancia total (depósitos + mensualidades) de todo un año.
     *
     * @param listaAlquileres ArrayList con todos los alquileres registrados
     * @param listaMensualidades ArrayList con todas las mensualidades registradas
     * @param anio año a consultar
     * @return la ganancia total de ese año
     */
    public static double calcularGananciaPorAnio(ArrayList<Alquileres> listaAlquileres,
            ArrayList<Mensualidades> listaMensualidades, int anio) {
        double gananciaDepositos = calcularGananciaDepositos(listaAlquileres, anio, null);
        double gananciaMensualidades = calcularGananciaMensualidades(listaMensualidades, listaAlquileres, anio, null);
        return gananciaDepositos + gananciaMensualidades;
    }

    /**
     * Calcula la ganancia total (depósitos + mensualidades) de un mes específico.
     *
     * @param listaAlquileres ArrayList con todos los alquileres registrados
     * @param listaMensualidades ArrayList con todas las mensualidades registradas
     * @param anio año a consultar
     * @param mes mes a consultar (1 a 12)
     * @return la ganancia total de ese mes
     */
    public static double calcularGananciaPorMes(ArrayList<Alquileres> listaAlquileres,
            ArrayList<Mensualidades> listaMensualidades, int anio, int mes) {
        double gananciaDepositos = calcularGananciaDepositos(listaAlquileres, anio, mes);
        double gananciaMensualidades = calcularGananciaMensualidades(listaMensualidades, listaAlquileres, anio, mes);
        return gananciaDepositos + gananciaMensualidades;
    }
}