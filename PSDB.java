import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * CINETH MARAKAWATTE - OCT 21
 * Represents a database interface for querying port scans.
 */
public class PSDB {

    /**
     * Handles queries related to IP addresses.
     *
     *  list    The list containing probe data.
     *  scanner The scanner object to read user input.
     */
    public static void handleIPQuery(ProbeLList list, Scanner scanner) {
        System.out.println("For which IP do you wish to retrieve statistics?");
        String ip = scanner.nextLine().trim();

        while (!ip.equalsIgnoreCase("END")) {
            int count = list.countProbes(ip);
            if (count > 0) {
                System.out.println("There were " + count + " probes from " + ip + ".");
            } else {
                System.out.println("There were no probes from that IP address.");
            }

            System.out.println("For which IP do you wish to retrieve statistics?");
            ip = scanner.nextLine().trim();
        }
    }

    /**
     * Handles queries related to a list of ports that an IP address has scanned.
     *
     *  list    The list containing probe data.
     *  scanner The scanner object to read user input.
     */
    public static void handlePLQuery(ProbeLList list, Scanner scanner) {
        while (true) {
            System.out.println("Enter a source IP address to see a list of ports that it scanned");
            String ip = scanner.nextLine();
            if (ip.equals("END")) {
                break;
            }
            List<Integer> ports = list.getPortsScannedByIP(ip);
            for (Integer port : ports) {
                System.out.println("IP " + ip + " sent a packet to port " + port);
            }
        }
    }
    /**
     * Handles queries related to statistics for a specific destination port.
     *
     *  list    The list containing probe data.
     *  scanner The scanner object to read user input.
     */
    public static void handleDPQuery(ProbeLList list, Scanner scanner) {
        System.out.println("For which port do you wish to retrieve statistics? (Enter -1 to exit)");
        while (true) {
            try {
                int port = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (port == -1) { // Using -1 as the sentinel value for "END"
                    break;
                }

                int count = list.countProbes(port);
                if (count == 0) {
                    System.out.println("There were no probes of port " + port + ".");
                } else {
                    System.out.println("There were " + count + " probes of port " + port + ".");
                }
                System.out.println("Enter another port or -1 to exit:");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid port number.");
                scanner.next(); // discard invalid token
            }
        }
    }
    /**
     * Handles queries to get the list of IPs that have probed a specific port.
     *
     *  list    The list containing probe data.
     *  scanner The scanner object to read user input.
     */
    public static void handleILQuery(ProbeLList list, Scanner scanner) {
        System.out.print("Enter port number: ");
        int port = scanner.nextInt();

        ArrayList<String> probers = list.getProbers(port);

        if (probers.isEmpty()) {
            System.out.println("No IPs have probed port " + port);
        } else {
            System.out.println("The following IPs have probed port " + port + ":");
            for (String ip : probers) {
                System.out.println(ip);
            }
        }
    }
    /**
     * Main method to drive the program.
     */
    public static void main(String[] args) {
        ProbeLList list = new ProbeLList();

        try {
            File file = new File("firewall.log.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String time = parts[0];
                String[] originParts = parts[1].split(":");
                String[] destParts = parts[2].split(":");
                list.insertProbe(new Probe(Integer.parseInt(destParts[1]), originParts[0], Integer.parseInt(originParts[1]), time));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Welcome to the Port Scan Database.");
        Scanner inputScanner = new Scanner(System.in);
        String choice = "";
        while (true) {
            System.out.println("Enter IP/DP/PL/IL/END (IP address/Destination Port/Port List/IP List/END):");
            choice = inputScanner.nextLine().toUpperCase();
            switch (choice) {
                case "IP":
                    handleIPQuery(list, inputScanner);
                    break;
                case "DP":
                    handleDPQuery(list, inputScanner);
                    break;
                case "PL":
                    handlePLQuery(list, inputScanner);
                    break;
                case "IL":
                    handleILQuery(list, inputScanner);
                    break;
                case "END":
                    System.out.println("Goodbye.");
                    inputScanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    }






}