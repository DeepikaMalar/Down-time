import java.util.Scanner;

public class SellSoftware{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			int cases = Integer.parseInt(sc.nextLine());
			if (cases >= 1 && cases <= 100) {
				// String array[] = new String[cases + 1];
				for (int i = 0; i < cases; i++) {
					String[] advAnalyst = sc.nextLine().split(" ");
					String profitResult = null;
					int revenueWithoutAdv_r = Integer.parseInt(advAnalyst[0]);
					int revenueWithAdv_e = Integer.parseInt(advAnalyst[1]);
					int advCost_c = Integer.parseInt(advAnalyst[2]);
					if (revenueWithoutAdv_r >= -1000000 && revenueWithAdv_e <= 1000000 && advCost_c <= 1000000) {
						if (revenueWithoutAdv_r > (revenueWithAdv_e - advCost_c)) {
							profitResult = "do not advertise";
						} else if ((revenueWithoutAdv_r == (revenueWithAdv_e - advCost_c))) {
							profitResult = "does not matter";
						} else{
							profitResult = "advertise";
						}
						System.out.println(profitResult);
					} else {
						System.out.println("Invalid data");
					}
				}

			}
		} catch (Exception exception) {

		}
	}

}
