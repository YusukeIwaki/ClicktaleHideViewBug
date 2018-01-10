package io.github.yusukeiwaki.clicktalehideviewbug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.yusukeiwaki.clicktalehideviewbug.model.Message;
import io.github.yusukeiwaki.clicktalehideviewbug.model.User;
import io.github.yusukeiwaki.clicktalehideviewbug.static_array_list.StaticArrayListAdapter;

public class MessageListAdapter extends StaticArrayListAdapter<Message, MessageListItemViewHolder> {

    private static final int VIEW_TYPE_ME = 0;

    @Override
    protected int getItemViewTypeOf(Message message) {
        return message.sender == User.ME ? 0 : 1;
    }

    @Override
    public MessageListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ME) {
            View itemView = inflater.inflate(R.layout.list_item_message_me, parent, false);
            return new MessageListItemViewHolder(itemView);
        } else {
            View itemView = inflater.inflate(R.layout.list_item_message_others, parent, false);
            return new MessageListItemViewHolder(itemView);
        }
    }
}
