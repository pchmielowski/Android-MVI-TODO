package net.chmielowski.mosbytest;

import android.view.View;
import android.widget.TextView;

class RendererImpl implements MainView.Renderer {
    private MainActivity activity;

    RendererImpl(final MainActivity activity) {
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