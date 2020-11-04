import java.util.StringTokenizer;

class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";

  private int maxLineLength;
  private String finalText = "";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // constructor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // outlay
  // !align left is default
  public void print(String aText) {
    StringTokenizer separateEachWord = new StringTokenizer(text);
    String temp = "";
    while (separateEachWord.hasMoreTokens()) {
      String word = separateEachWord.nextToken();
      if (temp.length() >= (maxLineLength - word.length())) {
        // temp = format_right_aligned(temp);
        // temp = format_block(temp);
        
        finalText = finalText + temp + "\n";
        temp = word;
      } else if (temp.isEmpty()) {
          temp = word;
        } else {
          temp = temp + " " + word;
        }
    }
    // temp = format_right_aligned(temp);
    // temp = format_block(temp);

    finalText = finalText + temp;
    System.out.println(finalText);
  }

  //align right
  public String format_right_aligned(String line) {
    String temp = line;
    for (int i = 0; i < (maxLineLength - line.length()); i++) {
      temp = " " + temp;
    }
    return (temp);
  }

  //align block
  public String format_block(String line) {
    String temp = line;
    int freeSpaces = maxLineLength - line.length();
    int i = 0;
    // how many space chars we need to add
    while(freeSpaces != 0 && returnAvailableSpaces(line) > 1) {
      i++;
      if (temp.charAt(i) == ' ') {
        temp = addChar(temp, ' ', i);
        freeSpaces--;
        i++;
      }
      if(i >= temp.length() - 1) {
          i = 0;
      }
    }
    return (temp);
  }

  public int returnAvailableSpaces(String line) {
    int availableSpaces = 0;
    for (int i = 0; i < line.length() - 1; i++) {
      if (line.charAt(i) == ' ') {
        availableSpaces++;
      }
    }
    return (availableSpaces);
  }

  // https://www.baeldung.com/java-add-character-to-string
  public String addChar(String str, char ch, int position) {
    return str.substring(0, position) + ch + str.substring(position);
  }
}