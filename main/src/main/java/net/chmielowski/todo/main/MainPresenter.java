package net.chmielowski.todo.main;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import net.chmielowski.todo.common.MviBasePresenterHelper;

import io.reactivex.Observable;

@AutoFactory
final class MainPresenter extends MviBasePresenterHelper<MainView, MainViewState> {
    private final Delegate delegate;

    MainPresenter(final @Provided Delegate delegate) {
        this.delegate = delegate;
    }

    @NonNull
    @Override
    protected Observable<MainViewState> intentStream() {
        return delegate.createStream(
                intent(MainView::confirmAddingClicked),
                intent(MainView::addNewClicked),
                intent(MainView::textChanged));
    }

    @Override
    protected ViewStateConsumer<MainView, MainViewState> renderer() {
        return MainView::render;
    }

}

