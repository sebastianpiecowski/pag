import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteSelection {

	public static List<Individual> start(List<Individual> individuals) {
		List<Individual> selectedPopulation = new ArrayList<>();
		Random rand = new Random();
		int sumOfAdaptationValues = 0;
		for (Individual ind : individuals) {
			sumOfAdaptationValues += ind.getAdaptationValue();
		}
		for (int i = 0; i < individuals.size(); i++) {
			double randed = rand.nextDouble() * 100;
			double currentVal = 0;
			for (int j = 0; j < individuals.size();) {
				currentVal += ((double) individuals.get(j).getAdaptationValue() / (double) sumOfAdaptationValues) * 100;
				if (randed <= currentVal) {
					selectedPopulation.add(new Individual(individuals.get(j)));
					break;
				} else {
					j++;
				}
			}
		}
		return selectedPopulation;
	}

}
