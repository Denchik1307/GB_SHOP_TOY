public class Main {
    public static void main(String[] args) {
        String[] ids = {"id1", "id2", "id3"};
        String[] names = {"Toy 1", "Toy 2", "Toy 3"};
        int[] weights = {20, 20, 60};

        ToyGame toyGame = new ToyGame(ids, names, weights);
        toyGame.saveResults();
    }
}
