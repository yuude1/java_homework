public class Button {
    private int clickCount;

    public Button() {
        this.clickCount = 0;
    }

    public void click() {
        clickCount++;
        System.out.println("Количество нажатий: " + clickCount);
    }

    public int getClickCount() {
        return clickCount;
    }


}
