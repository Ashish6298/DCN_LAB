import java.util.Random;
import java.util.Scanner;

public class leaky {
    public static void main(String[] args) {
        int drop = 0, mini, orate, bsize, nsec, premain = 0;
        int[] packet = new int[100];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the bucket size: ");
        bsize = scanner.nextInt();
        System.out.print("Enter the output rate: ");
        orate = scanner.nextInt();
        System.out.print("Enter the number of seconds to simulate: ");
        nsec = scanner.nextInt();

        Random rand = new Random();
        for (int i = 0; i < nsec; i++) {
            packet[i] = (rand.nextInt(1000));
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Seconds  Packets_received  Packets_sent  Packets_left  Packets_dropped");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < nsec; i++) {
            premain += packet[i];
            if (premain > bsize) {
                drop = premain - bsize;
                premain = bsize;
                System.out.print((i + 1) + "        ");
                System.out.print(packet[i] + "        ");
                mini = Math.min(premain, orate);
                System.out.print(mini + "        ");
                premain -= mini;
                System.out.print(premain + "        ");
                System.out.println(drop + "        ");
                drop = 0;
            }
        }

        System.out.println("----------------------------------------------------------------------");

        while (premain != 0) {
            if (premain > bsize) {
                drop = premain - bsize;
            }
            mini = Math.min(premain, orate);
            System.out.print("        " + premain + "        " + mini);
            premain -= mini;
            System.out.println("        " + premain + "        " + drop);
            drop = 0;
        }
    }
}

