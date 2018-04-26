import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Individual> lastPopulation=GA.start(20, 90, 50);
		toString(lastPopulation);
	}
	private static void toString(List<Individual> population) {
		String result = "";
		for (Individual ind : population) {
			result+=ind.getGens()+"\n";	
		}
		System.out.println(result);
	}

}
