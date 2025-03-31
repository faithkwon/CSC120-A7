public class Cafe extends Building implements CafeRequirements {

    // Cafe attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for the Cafe class
     * @param name name of the cafe
     * @param address location of the cafe
     * @param nFloors number of floors in the cafe
     * @param nCoffeeOunces how much coffee the cafe has in stock
     * @param nSugarPackets how much sugar the cafe has in stock
     * @param nCreams how much cream the cafe has in stock
     * @param nCups how many cups the cafe has in stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells coffee, removes from inventory
     * @param size size of the coffee ordered
     * @param nSugarPackets amount of sugar in coffee
     * @param nCreams amount of cream in coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces > size) {
            this.nCoffeeOunces -= size;
        } else {
            this.restock(size - this.nCoffeeOunces, 0, 0, 0);
            this.nCoffeeOunces -= size;
        }
        
        if (this.nSugarPackets > nSugarPackets) {
            this.nSugarPackets -= nSugarPackets;
        } else {
            this.restock(0, nSugarPackets - this.nSugarPackets, 0, 0);
            this.nSugarPackets -= nSugarPackets;
        }
        
        if (this.nCreams > nCreams) {
            this.nCreams -= nCreams;
        } else {
            this.restock(0, 0, nCreams - this.nCreams, 0);
            this.nCreams -= nCreams;
        }
        
        if (nCups > 0) {
            this.nCups -= 1;
        } else {
            this.restock(0, 0, 0, 1);
            this.nCups -= 1;
        }
    }

    /**
     * Restocks inventory
     * @param nCoffeeOunces amount you're restocking coffee by
     * @param nCreams amount you're restocking cream by
     * @param nCups amount you're restocking cups by
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    // toString method for Cafe
    public String toString() {
        return this.getName() + " has " + nCoffeeOunces + "oz of coffee, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups";
    }
    
    // Main method
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "Smith College", 2, 20, 10, 10, 10);

        System.out.println(compass);
        compass.sellCoffee(12, 5, 3);
        System.out.println(compass);
        compass.sellCoffee(16, 8, 1);
        System.out.println(compass);
    }
    
}
