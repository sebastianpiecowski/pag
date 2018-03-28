
public class Population {
	Individual[] individuals;
	
	public Population(int size) {
		individuals = new Individual[size];
		for (int i = 0; i < individuals.length; i++) {
			Individual newIndividual = new Individual();
			saveIndividual(i, newIndividual);
			
		}
		/*for (int i = 0; i < individuals.length; i++) {
			individuals[i].setValueFromBytes();
			
		}*/
	}

	public Individual getIndividual(int index) {
		return individuals[index];
	}
	//private void 
	@Override
	public String toString() {
		String populationString = "";
		for (int i = 0; i < individuals.length; i++) {
			populationString += individuals[i].toString() + "\n";

		}
		return populationString;
	}

	public void saveIndividual(int index, Individual indiv) {
		individuals[index] = indiv;
	}
}
