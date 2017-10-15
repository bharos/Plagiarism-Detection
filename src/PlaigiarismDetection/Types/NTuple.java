package PlaigiarismDetection.Types;

import PlaigiarismDetection.PlagiarismDetectorService;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NTuple {

  private List<String> tuple;

  public NTuple(List<String> tuple) {
    this.tuple = tuple;
  }

  public List<String> getTuple() {
    return tuple;
  }

  public void setTuple(List<String> tuple) {
    this.tuple = tuple;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (String s : tuple) {
      sb.append(s + " ");
    }

    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }
    if (!(o instanceof NTuple)) {
      return false;
    }

    NTuple t = (NTuple) o;

    if (this.tuple.size() != t.tuple.size()) {
      return false;
    }

    Map<String, Synonyms> map = PlagiarismDetectorService.synonymsMap;

    for (int i = 0; i < this.tuple.size(); i++) {
      if (!this.tuple.get(i).equals(t.tuple.get(i))) {
        if (!map.containsKey(this.tuple.get(i))) {
          return false;
        }
        Set<String> synonyms = map.get(this.tuple.get(i)).getSynonyms();
        if (!synonyms.contains(t.tuple.get(i))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {

    Map<String, Synonyms> map = PlagiarismDetectorService.synonymsMap;
    Synonyms s;
    int hashCode = 1;
    for (String t : tuple) {
      if (map.containsKey(t)) {
        s = map.get(t);
        hashCode = 31 * hashCode + s.hashCode();
      } else {
        hashCode = 31 * hashCode + t.hashCode();
      }

    }
    return hashCode;
  }
}
