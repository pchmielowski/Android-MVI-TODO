package net.chmielowski.todo.main;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

class RendererImpl implements MainView.Renderer {
    private AppCompatActivity activity;

    @Inject
    RendererImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void render(final MainViewState viewState) {
        activity.findViewById(R.id.new_list_name)
                .setVisibility(toVisibility(viewState.enterNameVisible));
        activity.findViewById(R.id.add_new)
                .setVisibility(toVisibility(viewState.addNewVisible));
        ((TextView) activity.findViewById(R.id.result))
                .setText(viewState.allLists);
        activity.findViewById(R.id.confirm_adding)
                .setVisibility(toVisibility(viewState.confirmVisible));
    }

    private int toVisibility(final boolean asBoolean) {
        return asBoolean ? View.VISIBLE : View.GONE;
    }

}
