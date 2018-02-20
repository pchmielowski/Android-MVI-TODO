package net.chmielowski.lib;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

class RxUtils {
    static Observable<NoValue> clicks(View view) {
        return RxView.clicks(view)
                .map(__ -> NoValue.INSTANCE);
    }
}
