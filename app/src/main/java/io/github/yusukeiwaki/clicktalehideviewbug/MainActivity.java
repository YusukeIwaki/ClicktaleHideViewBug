package io.github.yusukeiwaki.clicktalehideviewbug;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import bolts.Continuation;
import bolts.Task;
import io.github.yusukeiwaki.clicktalehideviewbug.model.Message;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefresh;
    private MessageListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefresh = findViewById(R.id.swipe_refresh);
        final RecyclerView messageList = findViewById(R.id.message_list);

        adapter = new MessageListAdapter();
        messageList.setAdapter(adapter);
        messageList.setLayoutManager(new LinearLayoutManager(this));

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestMessages();
            }
        });
        if (savedInstanceState == null) {
            requestMessages();
        }
    }

    private void requestMessages() {
        swipeRefresh.setRefreshing(true);
        new DummyMessageApi().fetch(50)
                .onSuccess(new Continuation<List<Message>, Object>() {
                    @Override
                    public Object then(Task<List<Message>> task) throws Exception {
                        onSuccess(task.getResult());
                        return null;
                    }
                }, Task.UI_THREAD_EXECUTOR)
                .continueWith(new Continuation<Object, Object>() {
                    @Override
                    public Object then(Task<Object> task) throws Exception {
                        if (task.isFaulted()) {
                            onError(task.getError());
                        }
                        swipeRefresh.setRefreshing(false);
                        return null;
                    }
                }, Task.UI_THREAD_EXECUTOR);
    }

    private void onSuccess(List<Message> messages) {
        adapter.updateData(messages);
    }

    private void onError(Exception error) {
        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
