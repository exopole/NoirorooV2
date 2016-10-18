package complement;
import java.util.Random;

public class De {
	private int type;
	private int number;
	private int result = 0;
	private boolean compute = false;
	
	public De(String de) {
		// TODO Auto-generated constructor stub
		String[]stringArray = new String[2];

		stringArray = de.split("D");
		type = Integer.parseInt(stringArray[1]);
		number = Integer.parseInt(stringArray[0]);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return number + "D" + type  ;
	}
	
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		if (isCompute() == true)
			return result;
		else
			return 0;
	}

	/**
	 * @return the compute
	 */
	public boolean isCompute() {
		return compute;
	}

	/**
	 * Compute the de value
	 */
	public void compute(){
		Random rand = new Random();
		
		for (int i = 0; i < number; i++) {
			result += rand.nextInt(type) + 1;
 		}
		compute = true;
	}
	
	
	
	
	
}
