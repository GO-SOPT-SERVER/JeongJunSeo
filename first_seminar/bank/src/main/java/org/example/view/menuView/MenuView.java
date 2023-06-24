package org.example.view.menuView;

public class MenuView {
    private MenuInputView inputView = new MenuInputView();
    private MenuOutputView outputView = new MenuOutputView();

    public int getMenuChoice() {
        outputView.showMenu();
        return inputView.inputAction();
    }


}
