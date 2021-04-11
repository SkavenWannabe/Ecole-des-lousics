package iut2.legendal_carminav_edl.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableMultiplication {

    private int numero;
    private int nbMultiplications;
    private List<Multiplication> multiplications;

    public TableMultiplication(int nbMultiplications) {
        Random rand = new Random();
        this.numero = rand.nextInt(12) + 1;
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

    public int getNumero() {
        return numero;
    }
}
