import java.util.Scanner;

public class DownTime{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int serverRequestCount = 0;
		int nextProcessTime = 0;
		int totalReq = sc.nextInt();
		int maxServerReq = sc.nextInt();
		int requiredServer =1;
		int [] processTime = new int[totalReq];
		try {
		for (int i = 0; i < totalReq; i++) {
			processTime[i]= sc.nextInt();
		}
		for(int i=0;i<totalReq;i++) {
			serverRequestCount++;
			while(processTime[i]>=processTime[nextProcessTime]+1000) {
				serverRequestCount--;
				nextProcessTime++;
			}
			requiredServer=((serverRequestCount>requiredServer)?serverRequestCount:requiredServer);
		}
		System.out.println((int)Math.ceil((double)requiredServer/maxServerReq));

	}catch(Exception exception) {
		System.out.println(exception.getMessage());
	}
	}

}
