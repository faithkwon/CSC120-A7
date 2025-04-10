import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  // House attributes
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;

  /**
   * Constructor for House class
   * @param name name of the house
   * @param address location of the house
   * @param nFloors number of floors in the house
   * @param hasDiningRoom whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for hasDiningRoom
   * @return T/F depending on if the house has a dining room or not
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Accessor for nResidents
   * @return number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds a new student to the list of residents
   * @param s student that is moving in
   */
  public void moveIn(Student s) {
    residents.add(s);
  }

  /**
   * Removes a student from the list of residents
   * @param s student that is moving out
   * @return student that is moving out
   */
  public Student moveOut(Student s) {
    if (isResident(s)) {
      residents.remove(s);
      return s;
    } else {
      throw new RuntimeException("Student " + s + " is not a resident of " + this.name + ". Please try again with a resident.");
    }
  }
  
  /**
   * Checks if a given student lives in a house
   * @param s student being checked
   * @return T/F depending on if the student lives in that house
   */
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /**
   * House class-specific toString
   * @return nicely formatted summary of House
   */
  public String toString() {
    return this.name + "'s residents are " + residents.toString();
  }

  // Main method
  public static void main(String[] args) {
    House kingHouse = new House("King House", "180 Elm", 4, true);
    Student faith = new Student("Faith", "99XXXX", 2027);

    if (kingHouse.hasDiningRoom()) {
      System.out.println(kingHouse.getName() + " has a dining room.");
    } else {
      System.out.println("No dining room.");
    }

    System.out.println(kingHouse.getName() + " has " + kingHouse.nResidents() + " residents.");
    kingHouse.moveIn(faith);
    System.out.println(kingHouse);

    System.out.println(kingHouse.getName() + " has " + kingHouse.nResidents() + " residents.");

    kingHouse.moveOut(faith);
    System.out.println(kingHouse);
  }

}