import java.util.Random;

public class Individual {
	private String gens;
	private int value;
	private int adaptationValue;
	public Individual() {
		generateValue();
		createGens();
		calculateAdaptationValue();
	}
	public Individual(Individual individual) {
		this.gens=individual.getGens();
		this.value=individual.getValue();
		this.adaptationValue=individual.getAdaptationValue();
	}
	private void calculateAdaptationValue() {
		adaptationValue=(int) (2+(Math.pow(value, 2)+1));
	}
	private void generateValue() {
		Random rand=new Random();
		this.value=rand.nextInt(127);
	}
	private void createGens() {
		this.gens=Integer.toBinaryString(value);
		while(gens.length()<7) {
			gens="0"+gens;
		}
	}
	public int getAdaptationValue() {
		return adaptationValue;
	}
	public String getGens() {
		return gens;
	}
	public int getValue() {
		return value;
	}
	public static void swapGens(Individual ind1, Individual ind2, int lopus) {
		String temp1=ind1.getGens().substring(lopus);
		String temp2=ind2.getGens().substring(lopus);
		ind1.setGens(ind1.getGens().substring(0, lopus)+temp2);
		ind2.setGens(ind2.getGens().substring(0, lopus)+temp1);
	}
	public void setGens(String gens) {
		this.gens = gens;
	}
	private void mutate(int mutationIndex, char gen) {
		StringBuilder builder = new StringBuilder(gens);
        builder.setCharAt(mutationIndex, gen);
        gens=builder.toString();
        value = Integer.parseInt(gens, 2);
        calculateAdaptationValue();
	}
	public void inverseGens(int mutationIndex) {
		char gen=gens.charAt(mutationIndex);
		if(gen==0) {
			mutate(mutationIndex, '1');
		}
		else if(gen==1) {
			mutate(mutationIndex, '0');
		}
	}
}
