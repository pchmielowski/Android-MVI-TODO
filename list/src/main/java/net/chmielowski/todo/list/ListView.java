package net.chmielowski.todo.list;

import com.hannesdorfmann.mosby3.mvp.MvpView;

interface ListView extends MvpView {

    void render(ListViewState viewState);
}
