package PlaigiarismDetection;

import PlaigiarismDetection.Types.NTuple;
import PlaigiarismDetection.Types.Synonyms;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperations {


  private List<NTuple> convertWordsToNTuples(List<String> words, int N) {
    List<NTuple> nTuples = new ArrayList<>();
    for (int i = 0; i <= words.size() - N; i++) {
      List<String> tuple = new ArrayList<>();
      for (int j = i; j < i + N; j++) {
        tuple.add(words.get(j));
      }
      nTuples.add(new NTuple(tuple));
    }
    return nTuples;
  }

  private List<String> convertLinesToWords(List<String> lines) {
    List<String> words = new ArrayList<>();
    Pattern p = Pattern.compile("[\\w']+");

    for (String line : lines) {
      Matcher m = p.matcher(line);
      while (m.find()) {
        words.add(m.group());
      }
    }
    return words;
  }

  private Map<String, Synonyms> mapSynonyms(List<String> lines) {
    Map<String, Synonyms> synonymsMap = new HashMap<>();

    for (String line : lines) {
      Synonyms synonyms = new Synonyms(line);
      String[] words = line.split(" ");
      for (String word : words) {
        synonymsMap.put(word, synonyms);
      }

    }
    return synonymsMap;
  }

  public List<NTuple> getNTuplesFromFile(String fileName, int N) {
    List<String> lines = readFile(fileName);
    List<String> words = convertLinesToWords(lines);
    return convertWordsToNTuples(words, N);
  }

  public Map<String, Synonyms> getSynonymsFromFile(String filename) {
    List<String> lines = readFile(filename);
    return mapSynonyms(lines);
  }


  private List<String> readFile(String fileName) {

    List<String> lines = new ArrayList<>();
    String line = null;

    FileReader fileReader = null;
    try {
      fileReader = new FileReader(fileName);
      BufferedReader bufferedReader =
          new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
      }
      bufferedReader.close();
    } catch (FileNotFoundException e) {
      System.out.println(
          "Unable to open file '" +
              fileName + "'");
    } catch (IOException e) {
      System.out.println(
          "Error reading file '"
              + fileName + "'");
    }
    return lines;
  }

}