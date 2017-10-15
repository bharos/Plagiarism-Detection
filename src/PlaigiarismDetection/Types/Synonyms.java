package PlaigiarismDetection.Types;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Synonyms {

  private Set<String> synonyms;

  public Synonyms(Set<String> s) {
    this.synonyms = s;
  }

  public Synonyms(String line) {

    synonyms = new HashSet<String>(Arrays.asList(line.split(" ")));
  }

  public Set<String> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(Set<String> synonyms) {
    this.synonyms = synonyms;
  }
}
