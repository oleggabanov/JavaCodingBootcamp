package codingbootcamp.week2.day2.progressbar;

public class Progressbar {

  private final int maxParts;
  private int currentParts;

  public Progressbar(int maxParts, int currentParts) {
    this.maxParts = maxParts;
    this.currentParts = currentParts;
  }

  public Progressbar(int maxParts) {
    this(maxParts, 0);
  }

  public void update() {
    if (currentParts < maxParts) {
      currentParts++;
    }
  }

  public int getPercent() {
    int percent = 100 / maxParts * currentParts;
    if (maxParts == currentParts) {
      percent = 100;
    }
    return percent;
  }

  public int getMaxParts() {
    return maxParts;
  }

  public int getCurrentParts() {
    return currentParts;
  }
}
