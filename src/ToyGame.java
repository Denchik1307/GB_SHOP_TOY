import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyGame {
    private String[] ids;
    private String[] names;
    private int[] weights;
    private PriorityQueue<Toy> queue;

    public ToyGame(String[] ids, String[] names, int[] weights) {
        this.ids = ids;
        this.names = names;
        this.weights = weights;
        this.queue = new PriorityQueue<>();

        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], weights[i]);
            queue.add(toy);
        }
    }

    public String get() {
        int randomValue = (int) (Math.random() * 100) + 1;

        for (Toy toy : queue) {
            if (randomValue <= toy.getWeight()) {
                return toy.getId();
            }
            randomValue -= toy.getWeight();
        }

        return null;
    }

    public void saveResults() {
        try {
            File file = new File("results.txt");
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < 10; i++) {
                writer.write(get() + "\n");
            }

            writer.close();
            System.out.println("Results saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}