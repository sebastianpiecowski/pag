
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Population pop=new Population(50);
		System.out.println(pop.toString());
		System.out.println(pop.getIndividual(0).getValueFromBytes());
		System.out.println(pop.getIndividual(5).getValueFromBytes());
	}

}
