package entity;

/**
 * This class was created to get to know what type of user
 * is logged in
 */
public class Button {
    private String buttonForNavbar;

    public Button() {
    }

    public String getButtonForNavbar() {
        return buttonForNavbar;
    }

    public void setButtonForNavbar(String buttonForNavbar) {
        this.buttonForNavbar = buttonForNavbar;
    }

    public Button(String buttonForNavbar) {
        this.buttonForNavbar = buttonForNavbar;
    }
}
