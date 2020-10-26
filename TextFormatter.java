import java.util.StringTokenizer; 

class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";
  String temp = " ";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
  
    for(int i = 0; i < (text.length()/maxLineLength); i++){

//line 1
     if(i == 0) {
        temp = temp + (text.substring(i, maxLineLength) + "\n");
      } else {
       temp = temp + (text.substring(i*maxLineLength, i*maxLineLength+maxLineLength) + "\n");
     }
    }
  }

  // Ausgabe
  public void print(String aText) {
    System.out.println(temp);
  }
}