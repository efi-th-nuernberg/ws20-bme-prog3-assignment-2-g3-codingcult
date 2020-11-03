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
        // here we add method to align temp
        temp = format_left_aligned(temp);
        // temp = format_right_aligned(temp);
        // temp = format_block(temp);
        
        finalText = finalText + temp + "\n";
        temp = "";
      } else {
        temp = temp + word + " ";
      }
    }
    // here we add method to align the last word/sentecne of temp
    temp = format_left_aligned(temp);
    // temp = format_right_aligned(temp);
    // temp = format_block(temp);

    finalText = finalText + temp;
    System.out.println(finalText);
  }

  // default
  public String format_left_aligned(String line) {
    String temp = line;
    for(int i = 0; i < (maxLineLength - line.length()); i++) {
      temp = temp + " ";
    }
    return (temp);
  }

  public String format_right_aligned(String line) {
    String temp = line;
    for(int i = 0; i < (maxLineLength - line.length()); i++) {
      temp = " " + temp;
    }
    return (temp);
  }

  // does not work yet
  public String format_block(String line) {
    String temp = line;
    // how many space chars we need to add
    for(int i = 0; i < (maxLineLength - temp.length()); i++) {
      // searching for places in the string where we can add a space
      for(int j = 0; j < temp.length()-1; j++) {
        if(temp.charAt(j) == ' ') {
          addChar(temp, '!', j);
        }
      }
    }
    return (temp);
  }

  //https://www.baeldung.com/java-add-character-to-string
  public String addChar(String str, char ch, int position) {
    StringBuilder sb = new StringBuilder(str);
    sb.insert(position, ch);
    return sb.toString();
  }
}