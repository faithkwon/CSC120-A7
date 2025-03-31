import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  // Library attributes
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for the Library class
   * @param name name of the library
   * @param address location of the library
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the collection
   * @param title name of the book
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**
   * Removes a title from the collection
   * @param title name of the book
   */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
   * Checks out a title
   * @param title name of the book
   */
  public void checkOut(String title) {
    collection.replace(title, true, false);
  }

  /**
   * Returns a title
   * @param title name of the book
   */
  public void returnBook(String title) {
    collection.replace(title, false, true);
  }

  /**
   * Checks if the collection has a specific title
   * @param title name of the book
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * Checks if a specific title is available
   * @param title name of the book
   */
  public boolean isAvailable(String title) {
    return collection.get(title) == true;
  }

  // Prints out the library's collection
  public void printCollection() {
    System.out.println(collection.toString());
  }
  
  // Main method
  public static void main(String[] args) {
    Library lib = new Library("Neilson", "Smith College", 4);
    
    lib.addTitle("book1"); 
    lib.addTitle("book2");

    lib.printCollection();

    if (lib.containsTitle("book2")) {
      System.out.println(lib.getName() + " has book2 in its collection.");
    } else {
      System.out.println("Book2 not in collection.");
    }

    lib.removeTitle("book2");
    lib.checkOut("book1");

    if (lib.isAvailable("book1")) {
      System.out.println("Book1 is currently available.");
    } else {
      System.out.println("Book1 is currently checked out.");
    }

    lib.printCollection();

    lib.returnBook("book1");

    lib.printCollection();
  }

}