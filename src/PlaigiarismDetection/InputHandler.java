package PlaigiarismDetection;

import PlaigiarismDetection.Types.PlagiarismDetectorInputModel;

public class InputHandler {

  private String[] args;
  private static final String USAGE_FORMAT = "Usage: java <synonym_filename> <input_filename_1> <input_filename_2> <Optional_N>";
  private static final int NUM_ARGS = 4;

  public InputHandler(String[] args) {
    this.args = args;
  }

  public boolean checkArguments() {
    if (args == null || args.length < NUM_ARGS - 1) {
      System.out.println("Fewer arguments provided. Expected : " + USAGE_FORMAT);
      return false;
    }
    if (args.length > NUM_ARGS) {
      System.out.println("More arguments provided. Expected : " + USAGE_FORMAT);
      return false;
    }
    if (args.length == NUM_ARGS && !isInteger(args[3])) {
      System.out.println("Optional argument should be Integer. Expected : " + USAGE_FORMAT);
      return false;
    }
    return true;
  }

  private boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  public PlagiarismDetectorInputModel extractArguments() {
    PlagiarismDetectorInputModel m = new PlagiarismDetectorInputModel();
    m.setSynonymFile(args[0]);
    m.setInputFile1(args[1]);
    m.setInputFile2(args[2]);

    if (args.length == 4) {
      m.setN(Integer.parseInt(args[3]));
    }
    return m;
  }
}
