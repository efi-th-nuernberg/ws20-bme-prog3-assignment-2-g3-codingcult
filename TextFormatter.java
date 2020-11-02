import java.util.StringTokenizer; 

class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  private int maxLineLength;
  private String finalText = "";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
    StringTokenizer separateEachWord = new StringTokenizer(text);
    String temp = "";
    while (separateEachWord.hasMoreTokens()) {
      String word = separateEachWord.nextToken();
      if (temp.length() >= (maxLineLength - word.length())) {
        finalText = finalText + temp + "\n";
        temp = "";
      }
      temp = temp + word + " ";
    }
    finalText = finalText + temp;
    System.out.println(finalText);
  }
}