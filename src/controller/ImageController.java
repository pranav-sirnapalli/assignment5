package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.image.Image;
import model.ImageModel;
import utils.ImageIOHelper;

/**
 * The ImageController class handles user commands for performing various image processing
 * operations. It interacts with the ImageModel to load, save, and apply transformations to images.
 * It supports both interactive commands and the execution of a script containing multiple
 * commands.
 */
public class ImageController {

  private ImageModel imageModel;
  private Map<String, Image> images = new HashMap<>();

  /**
   * Constructor of ImageController.
   */
  public ImageController() {
    this.imageModel = new ImageModel();
  }

  /**
   * Run the Controller logic.
   * @param scanner scanner of run.
   */
  public void run(Scanner scanner) {
    //System.out.println("Current working directory: " + System.getProperty("user.dir"));
    boolean running = true;
    while (running) {
      System.out.print("Enter command: ");
      String command = scanner.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        System.out.println("Exiting program...");
        running = false;
      } else {
        this.processCommand(command);
      }
    }

  }

  /**
   * Processes individual commands entered by the user. Each command corresponds to an image
   * operation such as loading, saving, flipping, or applying filters.
   *
   * @param command The command entered by the user.
   */
  public void processCommand(String command) {
    // Skip empty lines or comments
    if (command.isEmpty() || command.startsWith("#")) {
      return;
    }
    String[] tokens = command.split(" ");
    switch (tokens[0]) {
      case "load":
        if (tokens.length != 3) {
          System.out.println("Usage: load <input_file_path> <reference_name>");
        } else {
          Image image = ImageIOHelper.loadImage(tokens[1]);
          images.put(tokens[2], image);
        }
        break;
      case "save":
        if (tokens.length != 3) {
          System.out.println("Usage: save <save_path> <output_name>");
        } else {
          ImageIOHelper.saveImage(tokens[1], images.get(tokens[2]));
        }
        break;
      case "horizontal-flip":
        if (tokens.length != 3) {
          System.out.println("Usage: horizontal-flip <reference_name> <output_name>");
        } else {
          Image img = imageModel.flipHorizontal(images.get(tokens[1]));
          images.put(tokens[2], img);
        }
        break;
      case "vertical-flip":
        if (tokens.length != 3) {
          System.out.println("Usage: horizontal-flip <reference_name> <output_name>");
        } else {
          Image img = imageModel.flipVertical(images.get(tokens[1]));
          images.put(tokens[2], img);
        }
        break;
      case "brighten":
        int increment = Integer.parseInt(tokens[3]);
        Image img = imageModel.brighten(images.get(tokens[1]), increment);
        images.put(tokens[2], img);
        break;
      case "blur":
        Image blur = imageModel.blur(images.get(tokens[1]));
        images.put(tokens[2], blur);
        break;
      case "sepia":
        Image sepia = imageModel.sepia(images.get(tokens[1]));
        images.put(tokens[2], sepia);
        break;
      case "sharpen":
        Image sharpen = imageModel.sharpen(images.get(tokens[1]));
        images.put(tokens[2], sharpen);
        break;
      case "greyScale":
        Image greyScale = imageModel.toGreyscale(images.get(tokens[1]));
        images.put(tokens[2], greyScale);
        break;
      case "rgb-split":
        Image r = imageModel.redComponent(images.get(tokens[1]));
        Image g = imageModel.greenComponent(images.get(tokens[1]));
        Image b = imageModel.blueComponent(images.get(tokens[1]));
        images.put(tokens[2], r);
        images.put(tokens[3], g);
        images.put(tokens[4], b);
        break;
      case "rgb-combine":
        Image combined = imageModel.combineImage(images.get(tokens[2]), images.get(tokens[3]),
            images.get(tokens[4]));
        images.put(tokens[1], combined);
        break;
      case "red-component":
        Image redComponent = imageModel.redComponent(images.get(tokens[1]));
        images.put(tokens[2], redComponent);
        break;
      case "green-component":
        Image greenComponent = imageModel.greenComponent(images.get(tokens[1]));
        images.put(tokens[2], greenComponent);
        break;
      case "blue-component":
        Image blueComponent = imageModel.blueComponent(images.get(tokens[1]));
        images.put(tokens[2], blueComponent);
        break;
      case "value-component":
        Image value = imageModel.value(images.get(tokens[1]));
        images.put(tokens[2], value);
        break;
      case "luma-component":
        Image luma = imageModel.luma(images.get(tokens[1]));
        images.put(tokens[2], luma);
        break;
      case "intensity-component":
        Image intensity = imageModel.intensity(images.get(tokens[1]));
        images.put(tokens[2], intensity);
        break;
      case "run":
        runScript(tokens[1]);
        break;
      default:
        System.out.println("Invalid command!");
        break;
    }
  }


  /**
   * Reads and executes commands from a script file. Each line of the file is treated as a separate
   * command.
   *
   * @param scriptPath The file path to the script.
   */
  private void runScript(String scriptPath) {
    try {
      String path = "script.txt";
      BufferedReader reader = new BufferedReader(new FileReader(scriptPath));
      String line;
      while ((line = reader.readLine()) != null) {
        this.processCommand(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
