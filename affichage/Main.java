package affichage;

import serpent.Snake;
import terrain.Terrain;

public class Main {
    public static void main(String[] args) {
        Snake s = new Snake(30, 30);
        Terrain terrain = new Terrain(s);
        MaFenetre f = new MaFenetre(terrain);
    }
}
