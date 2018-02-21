package net.chmielowski.todo.main;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

final class RxUtils {
    private RxUtils() {
    }

    static Observable<NoValue> clicks(final View view) {
        return RxView.clicks(view)
                .map(__ -> NoValue.INSTANCE);
    }
}
