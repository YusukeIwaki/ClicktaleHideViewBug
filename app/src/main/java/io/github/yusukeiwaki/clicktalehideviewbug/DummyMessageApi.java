package io.github.yusukeiwaki.clicktalehideviewbug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bolts.Task;
import bolts.TaskCompletionSource;
import io.github.yusukeiwaki.clicktalehideviewbug.model.Message;
import io.github.yusukeiwaki.clicktalehideviewbug.model.User;

public class DummyMessageApi {
    public interface Callback {
        void onSuccess(List<Message> messages);
        void onError(Exception error);
    }

    public Task<List<Message>> fetch(final int count) {
        final TaskCompletionSource<List<Message>> tcs = new TaskCompletionSource<>();
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3);
                    tcs.setResult(generateDummyResult(count));
                } catch (Exception e) {
                    tcs.setError(e);
                }
            }
        }.start();
        return tcs.getTask();
    }

    private List<Message> generateDummyResult(int count) {
        final ArrayList<Message> messageList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            User user = (i % 2 == 0 || i % 5 == 0) ? User.ME : User.OTHERS;
            messageList.add(generateDummyMessageOf(user));
        }
        return messageList;
    }

    private Message generateDummyMessageOf(User user) {
        Random random = new Random();
        int wordCount = 50 + (random.nextInt() % 30);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<wordCount; i++) {
            sb.append("secret");
            if (i % 2 == 0) {
                sb.append("_data!   ");
            } else {
                sb.append(" ");
            }
        }
        return new Message(System.currentTimeMillis(), sb.toString(), user);
    }
}
