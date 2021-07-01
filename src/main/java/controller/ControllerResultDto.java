package controller;

public class ControllerResultDto {
    private final String view;
    private boolean needRedirect;

    public ControllerResultDto(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public ControllerResultDto(String view, boolean needRedirect) {
        this.view = view;
        this.needRedirect = needRedirect;
    }

    public boolean isRedirect() {
        return needRedirect;
    }

}