package streamTask2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static int getClosedValueToZero(int[] mass) {
		return  Arrays.stream(mass)
				.mapToObj(n -> n)
				.collect(Collectors.minBy((a, b) -> {
					int dif = (Math.abs(a) - Math.abs(b));
					if(dif == 0 && (a < b)) {
						return 1;
					}
					return dif;
				}))
				.get().intValue();
	}
	
	public static void main(String[] args) {
		int[] mass = {2, -61, 8, 9, -14, 5, 540, 1, -1};
		System.out.println(getClosedValueToZero(mass));
	}

}
