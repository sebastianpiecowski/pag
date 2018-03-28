import java.nio.ByteBuffer;

public class Individual {
	private byte[] gen;
	private static int defaultGenLength = 8;
	private long valueFromBytes;
	private int valueInPattern;

	public Individual() {
		gen=new byte[defaultGenLength];
		generateIndividual();
		setValueFromBytes();
	}
	public void generateIndividual() {
		 for (int i = 0; i < defaultGenLength; i++) {
	            byte gene = (byte) Math.round(Math.random());
	            gen [i] = gene;
	        }
	}
	
	public void setValueFromBytes() {
		for (int i=0; i<gen.length; i++) {
			System.out.println(Math.pow((double)gen[i]*10,(double)i));
		}
		
	}
	public long getValueFromBytes() {
		return valueFromBytes;
	}
	public byte getGene(int index) {
		return gen[index];
	}

	public Individual getIndividual() {
		return this;
	}

	@Override
	public String toString() {
		String gens="";
		for (int i=0; i<gen.length; i++) {
			gens+=gen[i];
		}
		return gens;
	}
}
