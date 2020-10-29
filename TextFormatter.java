import java.util.StringTokenizer; 

class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  private String finalText = " ";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    StringTokenizer st = new StringTokenizer(text);
    String temp = " ";
    while (st.hasMoreTokens()) {
      // keeps going as long as there are words
      temp = temp + st.nextToken() + " ";
      if (temp.length() > maxLineLength) {
        finalText = finalText + temp + "\n";
        temp = " ";
      }
    }
    finalText = finalText + temp;
  }

  // Ausgabe
  public void print(String aText) {
    System.out.println(finalText);
  }
}