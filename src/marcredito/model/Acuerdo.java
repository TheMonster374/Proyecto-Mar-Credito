package marcredito.model;

/**
 * Clase que representa las condiciones de un acuerdo financiero.
 */
public class Acuerdo {

    private final double interes;
    private final int plazoMeses;

    /**
     * Constructor básico.
     */
    public Acuerdo(double interes, int plazoMeses) {
        this.interes = interes;
        this.plazoMeses = plazoMeses;
    }

    public double getInteres() {
        return interes;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    @Override
    public String toString() {
        return "Acuerdo: interes=" + interes + "%, plazo=" + plazoMeses + " meses";
    }
}
