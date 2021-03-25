package iut2.legendal_carminav_edl.modele;

import java.util.ArrayList;
import java.util.List;

public class TableMultiplication {

    private int numero;
    private int nbMultiplications;
    private List<Multiplication> multiplications;

    public TableMultiplication(int numero, int nbMultiplications) {
        this.numero = numero;
        this.nbMultiplications = nbMultiplications;
        this.multiplications = new ArrayList<>();
        for (int i = 1; i <= this.nbMultiplications; ++i) {
            this.multiplications.add(new Multiplication(i, this.numero));
        }
    }

    public int getNbMultiplications() {
        return nbMultiplications;
    }

    public List<Multiplication> getMultiplications() {
        return multiplications;
    }
}
