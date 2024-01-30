package DCN_LAB;
import java.math.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class leaky {

	public static void main(String[] args) {
		int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0;
		int packet[]=new int[100];
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the bucket size:");;
		b_size=in.nextInt();
		System.out.print("Enter the output rate:");
		o_rate=in.nextInt();
		System.out.print("Enter the number of seconds in simulate:");
		nsec=in.nextInt();
		Random rand=new Random();
		for(i=0;i<nsec;i++)
			packet[i]=(rand.nextInt(1000));
		System.out.println("Seconds   packet received   packet sent   packet left   packet dropped");
		System.out.println("-----------------------------------------------------------------------");
		for(i=0;i<nsec;i++) {
			p_remain+=packet[i];
			if(p_remain>b_size) {
				drop=p_remain-b_size;
				p_remain=b_size;
				System.out.print(i+1+"            ");
				System.out.print(packet[i]+"             ");
				mini=Math.min(p_remain,o_rate);
				System.out.print(mini+"             ");
				p_remain=p_remain-mini;
				System.out.print(p_remain+"              ");
				System.out.println(drop+" ");
				System.out.print("");
				drop=0;
			}
		}
		while(p_remain!=0) {
			if(p_remain>b_size) {
				drop=p_remain-b_size;
			}
			mini=Math.min(p_remain, o_rate);
			System.out.print("              "+p_remain+"              "+mini);
			p_remain=p_remain-mini;
			System.out.println("              "+p_remain+"              "+drop);
			drop=0;
		}

	}

}


// OUTPUT:
// Enter the bucket size:10
// Enter the output rate:4
// Enter the number of seconds in simulate:10
// Seconds   packet received   packet sent   packet left   packet dropped
// -----------------------------------------------------------------------
// 1            638             4             6              628
// 2            405             4             6              401
// 3            895             4             6              891
// 4            321             4             6              317
// 5            683             4             6              679
// 6            537             4             6              533
// 7            661             4             6              657
// 8            189             4             6              185
// 9            556             4             6              552
// 10            835             4             6              831
//               6              4              2              0
//               2              2              0              0
