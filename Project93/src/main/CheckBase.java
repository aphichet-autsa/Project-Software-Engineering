package main;

abstract class CheckBase {
    protected String message;

    public CheckBase(String message) {
        this.message = message;
    }

    public abstract void showMessage();
}
