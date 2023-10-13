import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * reads lines of input from the file
 * firewall.log.txt using the Scanner class and inserts each sighting as a single
 * Probe object into ProbeList
 */
public class PSDB {
    public static void main(String[] args) throws FileNotFoundException {

        ProbeLList probes = new ProbeLList();

        /*The File and Scanner goes here*/
        File in = new File("firewall.log.txt");
        Scanner s = new Scanner(in);

    }

}

