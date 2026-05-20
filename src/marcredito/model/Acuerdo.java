package marcredito.model;

import java.io.Serializable;

public class Acuerdo implements Serializable {
    private final double interes;
    private final int plazoMeses;

    /**
     * Crea un acuerdo con interés y plazo.
     *
     * @param interes interés en porcentaje
     * @param plazoMeses plazo en meses
     */
    public Acuerdo(double interes, int plazoMeses) {
        this.interes = interes;
        this.plazoMeses = plazoMeses;
    }

    /**
     * Obtiene el interés.
     *
     * @return interés en porcentaje
     */
    public double getInteres() {
        return interes;
    }

    /**
     * Obtiene el plazo.
     *
     * @return plazo en meses
     */
    public int getPlazoMeses() {
        return plazoMeses;
    }

    @Override
    public String toString() {
        return "Acuerdo: interes=" + interes + "%, plazo=" + plazoMeses + " meses";
    }
}