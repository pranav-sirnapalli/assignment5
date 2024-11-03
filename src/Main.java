import controller.ImageController;
import java.util.Scanner;

/**
 * The entrance of the program.
 */
public class Main {

  /**
   * The entrance of the program.
   * @param args the arguments to use.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java Main -file <script.txt>");
      return;
    }
    Scanner scanner = new Scanner(System.in);
    ImageController controller = new ImageController();
    controller.run(scanner);
  }
}
