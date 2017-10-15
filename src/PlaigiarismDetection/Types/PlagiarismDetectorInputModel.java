package PlaigiarismDetection.Types;

public class PlagiarismDetectorInputModel {

  private String synonymFile;
  private String inputFile1;
  private String inputFile2;
  private static final int DEFAULT_N = 3;
  private Integer N;

  public Integer getN() {
    if (N == null) {
      return DEFAULT_N;
    }
    return N;
  }

  public void setN(Integer n) {
    N = n;
  }

  public void setSynonymFile(String synonymFile) {
    this.synonymFile = synonymFile;
  }

  public void setInputFile1(String inputFile1) {
    this.inputFile1 = inputFile1;
  }

  public void setInputFile2(String inputFile2) {
    this.inputFile2 = inputFile2;
  }

  public String getSynonymFile() {
    return synonymFile;
  }

  public String getInputFile1() {
    return inputFile1;
  }

  public String getInputFile2() {
    return inputFile2;
  }
}
