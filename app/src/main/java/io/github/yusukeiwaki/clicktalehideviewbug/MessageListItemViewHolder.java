package io.github.yusukeiwaki.clicktalehideviewbug;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clicktale.clicktalesdk.Clicktale;

import io.github.yusukeiwaki.clicktalehideviewbug.model.Message;
import io.github.yusukeiwaki.clicktalehideviewbug.static_array_list.StaticArrayListViewHolder;

public class MessageListItemViewHolder extends StaticArrayListViewHolder<Message> {
    private final @Nullable ImageView avatar;
    private final @NonNull ViewGroup messageBodyContainer;

    public MessageListItemViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.user_avatar);
        messageBodyContainer = itemView.findViewById(R.id.message_body_container);
    }

    @Override
    public void bind(Message message) {
        if (avatar != null) {
            Glide.with(avatar.getContext())
                    .load(message.sender.avatarUrl)
                    .into(avatar);
        }
        messageBodyContainer.removeAllViews();
        messageBodyContainer.addView(createMessageTextView(message.body));
        Clicktale.hideView(messageBodyContainer);
    }

    private View createMessageTextView(String body) {
        TextView textView = new TextView(messageBodyContainer.getContext());
        textView.setText(body);
        return textView;
    }
}
