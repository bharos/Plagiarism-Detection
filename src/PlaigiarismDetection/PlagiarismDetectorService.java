package PlaigiarismDetection;

import PlaigiarismDetection.Types.NTuple;
import PlaigiarismDetection.Types.PlagiarismDetectorInputModel;
import PlaigiarismDetection.Types.Synonyms;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlagiarismDetectorService {

  public static Map<String, Synonyms> synonymsMap;

  private final PlagiarismDetectorInputModel input;

  public PlagiarismDetectorService(PlagiarismDetectorInputModel input) {
    this.input = input;
  }

  public float calculatePlagiarismRatio() {
    FileOperations fileOperations = new FileOperations();

    synonymsMap = fileOperations
        .getSynonymsFromFile(input.getSynonymFile());
    final List<NTuple> nTuples1 = fileOperations
        .getNTuplesFromFile(input.getInputFile1(), input.getN());
    final List<NTuple> nTuples2 = fileOperations
        .getNTuplesFromFile(input.getInputFile2(), input.getN());

    return calculateRatio(nTuples1, nTuples2);
  }

  private float calculateRatio(List<NTuple> nTuples1, List<NTuple> nTuples2) {
    Set<NTuple> set = new HashSet<>();
    if (nTuples1.size() == 0) {
      return 0;
    }
    float count = 0;
    set.addAll(nTuples2);
    for (NTuple t : nTuples1) {
      if (set.contains(t)) {
        System.out.println("Contains: " + t);
        count++;
      } else {
        System.out.println(t);
      }
    }

    System.out.println(count + "/" + nTuples1.size());
    return (count / nTuples1.size()) * 100;
  }


}
