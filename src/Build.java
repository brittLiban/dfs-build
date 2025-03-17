import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Build {

  /**
   * Prints words that are reachable from the given vertex and are strictly shorter than k characters.
   * If the vertex is null or no reachable words meet the criteria, prints nothing.
   *
   * @param vertex the starting vertex
   * @param k the maximum word length (exclusive)
   */
  public static void printShortWords(Vertex<String> vertex, int k) {
    if(vertex == null) return;

    Set<Vertex<String>> visited = new HashSet<>();

    StringBuilder shortestWord = new StringBuilder();
    printShortWordsHelper(vertex, k, visited, shortestWord);

    System.out.println(shortestWord.toString().trim());
  }

  public static StringBuilder printShortWordsHelper(Vertex<String> vertex, int k, Set<Vertex<String>> visited, StringBuilder shortestWord) {
    if(vertex == null|| visited.contains(vertex)) return shortestWord;

    visited.add(vertex);

    if(k > vertex.data.length()){
      shortestWord.append(vertex.data).append(" ");
      
    }


    for(var next : vertex.neighbors){

      printShortWordsHelper(next, k, visited, shortestWord);
    }

    


    return shortestWord;
  }


  /**
   * Returns the longest word reachable from the given vertex, including its own value.
   *
   * @param vertex the starting vertex
   * @return the longest reachable word, or an empty string if the vertex is null
   */
  public static String longestWord(Vertex<String> vertex) {
    if(vertex == null) return "";

    Set<Vertex<String>> visited = new HashSet<>();

    
    String longestWord = longestWordHelper(vertex, visited, "");

    return longestWord;

  }

  public static String longestWordHelper(Vertex<String> vertex, Set<Vertex<String>> visited, String longestWord) {
    if(vertex == null || visited.contains(vertex)) return longestWord;
    
    visited.add(vertex);


    if(vertex.data.length() > longestWord.length()){
      longestWord = vertex.data;
    }

    for (Vertex<String> next : vertex.neighbors) {
        String candidate = longestWordHelper(next, visited, longestWord);
        if (candidate.length() > longestWord.length()) {
            longestWord = candidate;
        }
    }

    return longestWord;

    


  }


  /**
   * Prints the values of all vertices that are reachable from the given vertex and 
   * have themself as a neighbor.
   *
   * @param vertex the starting vertex
   * @param <T> the type of values stored in the vertices
   */
  public static <T> void printSelfLoopers(Vertex<T> vertex) {
  }

  /**
   * Determines whether it is possible to reach the destination airport through a series of flights
   * starting from the given airport. If the start and destination airports are the same, returns true.
   *
   * @param start the starting airport
   * @param destination the destination airport
   * @return true if the destination is reachable from the start, false otherwise
   */
  public static boolean canReach(Airport start, Airport destination) {
    return false;
  }

  /**
   * Returns the set of all values in the graph that cannot be reached from the given starting value.
   * The graph is represented as a map where each vertex is associated with a list of its neighboring values.
   *
   * @param graph the graph represented as a map of vertices to neighbors
   * @param starting the starting value
   * @param <T> the type of values stored in the graph
   * @return a set of values that cannot be reached from the starting value
   */
  public static <T> Set<T> unreachable(Map<T, List<T>> graph, T starting) {
    return new HashSet<>();
  }
}
