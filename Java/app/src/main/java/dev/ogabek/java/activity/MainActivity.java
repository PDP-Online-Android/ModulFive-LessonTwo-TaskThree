package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import dev.ogabek.java.R;
import dev.ogabek.java.adapter.ChatAdapter;
import dev.ogabek.java.model.Chat;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        refreshAdapter(getAllChats());
    }

    private void refreshAdapter(ArrayList<Chat> chats) {
        ChatAdapter adapter = new ChatAdapter(chats);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Chat> getAllChats() {
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(new Chat(R.drawable.user, "Ogabek Matyakubov", true));
        chats.add(new Chat(R.drawable.user2, "OgabekDev", true));
        chats.add(new Chat(R.drawable.user3, "Ogabek", false));
        chats.add(new Chat(R.drawable.user4, "Android Bootcamp B13", false));
        chats.add(new Chat(R.drawable.user, "Ogabek Matyakubov", false));
        chats.add(new Chat(R.drawable.user2, "OgabekDev", true));
        chats.add(new Chat(R.drawable.user3, "Ogabek", false));
        chats.add(new Chat(R.drawable.user4, "Android Bootcamp B13", false));
        chats.add(new Chat(R.drawable.user, "Ogabek Matyakubov", true));
        chats.add(new Chat(R.drawable.user2, "OgabekDev", false));
        chats.add(new Chat(R.drawable.user3, "Ogabek", true));
        chats.add(new Chat(R.drawable.user4, "Android Bootcamp B13", false));
        chats.add(new Chat(R.drawable.user, "Ogabek Matyakubov", true));
        chats.add(new Chat(R.drawable.user2, "OgabekDev", false));
        chats.add(new Chat(R.drawable.user3, "Ogabek", false));
        chats.add(new Chat(R.drawable.user4, "Android Bootcamp B13", false));
        return chats;
    }
}