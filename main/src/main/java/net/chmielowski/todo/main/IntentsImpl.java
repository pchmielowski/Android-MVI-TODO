package net.chmielowski.todo.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.auto.factory.AutoFactory;
import com.jakewharton.rxbinding2.widget.RxTextView;

import javax.inject.Inject;

import io.reactivex.Observable;

class IntentsImpl implements MainView.Intents {
    private AppCompatActivity activity;

    @Inject
    IntentsImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public Observable<NoValue> addNewClicked() {
        return RxUtils.clicks(activity.findViewById(R.id.add_new));
    }

    @NonNull
    @Override
    public Observable<String> textChanged() {
        return RxTextView.textChanges(activity.findViewById(R.id.new_list_name))
                .map(CharSequence::toString);
    }

    @NonNull
    @Override
    public Observable<NoValue> confirmAddingClicked() {
        return RxUtils.clicks(activity.findViewById(R.id.confirm_adding));
    }
}
