package net.chmielowski.todo.main;

class MainViewState {
    final String allLists;
    final boolean addNewVisible;
    final boolean confirmVisible;
    final boolean enterNameVisible;

    MainViewState(final String allLists, final boolean addNewVisible, final boolean confirmVisible, final boolean enterNameVisible) {

        this.allLists = allLists;
        this.addNewVisible = addNewVisible;
        this.confirmVisible = confirmVisible;
        this.enterNameVisible = enterNameVisible;
    }

    static MainViewState initial() {
        return new MainViewState("", true, false, false);
    }
}
