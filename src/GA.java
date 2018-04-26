import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA {
	private static List<Individual> population = new ArrayList<>();
	private static Random rand;

	public static List<Individual> start(int popSize, int cross, int mutation) {
		List<Individual> selectedPopulation;
		rand = new Random();
		generatePopulation(popSize);
		for (int i = 0; i < popSize; i++) {
			selectedPopulation = RouletteSelection.start(population);
			cross(selectedPopulation, cross);
			mutate(selectedPopulation, mutation);
			population=new ArrayList<>(selectedPopulation);
			/*population.clear();
			population.addAll(selectedPopulation);*/
		}
		return population;
	}

	private static void generatePopulation(int popSize) {
		for (int i = 0; i < popSize; i++) {
			population.add(new Individual());
		}
	}

	private static void cross(List<Individual> selectedPopulation, int cross) {
		int randed;
		for (int i = 0; i < selectedPopulation.size() - 1; i += 2) {
			randed = rand.nextInt(101);
			if (randed <= cross) {
				int lopus = rand.nextInt(7);
				Individual.swapGens(selectedPopulation.get(i), selectedPopulation.get(i + 1), lopus);
			}
		}
	}

	private static void mutate(List<Individual> selectedPopulation, int mutation) {
		int randed;
		for (int i=0; i<selectedPopulation.size(); i++) {
			randed= rand.nextInt(101);
			if (randed <= mutation) {
				int lopus=rand.nextInt(7);
				selectedPopulation.get(i).inverseGens(lopus);
			}
		}
	}
}
