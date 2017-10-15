package PlaigiarismDetection;

import static java.lang.System.exit;

import PlaigiarismDetection.Types.PlagiarismDetectorInputModel;

public class PlaigiarismDetector {

  public static void main(String[] args) {

    for (String a : args) {
      System.out.println(a);
    }
    InputHandler handler = new InputHandler(args);
    if (!handler.checkArguments()) {
      exit(0);
    }
    final PlagiarismDetectorInputModel input = handler.extractArguments();
    PlagiarismDetectorService service = new PlagiarismDetectorService(input);
    System.out.println(service.calculatePlagiarismRatio());

  }

}
