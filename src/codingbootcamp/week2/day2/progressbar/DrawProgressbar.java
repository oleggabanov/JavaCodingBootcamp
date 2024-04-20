package codingbootcamp.week2.day2.progressbar;

public class DrawProgressbar {
  private static final String TEMPLATE = "%d%% [%-100s] %d/%d \r";

  private DrawProgressbar() {
  }

  private static String line(int percent) {
    String rep = "=".repeat(percent);
    return percent != 100 ? rep + ">" : rep;
  }

  public static void show(Progressbar progressbar) {
    String line = line(progressbar.getPercent());
    System.out.printf(TEMPLATE, progressbar.getPercent(), line, progressbar.getCurrentParts(), progressbar.getMaxParts());
  }
}
