package PlaigiarismDetection;

import static java.lang.System.exit;

import PlaigiarismDetection.Types.PlagiarismDetectorInputModel;

public class PlagiarismDetector {

  public static void main(String[] args) {

    InputHandler handler = new InputHandler(args);
    if (!handler.checkArguments()) {
      exit(0);
    }
    final PlagiarismDetectorInputModel input = handler.extractArguments();
    PlagiarismDetectorService service = new PlagiarismDetectorService(input);
    System.out.println("Plagiarism ratio : Number of NTuples of file1 in file2 is :");
    System.out.println(service.calculatePlagiarismRatio() + "%");

  }

}
