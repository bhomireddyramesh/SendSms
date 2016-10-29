package comguess.example.android.final_sendsms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SentMessages extends AppCompatActivity {

    ListView list;
    SimpleCursorAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_messages);
        list = (ListView)findViewById(R.id.list);
        inbox_Data();
    }
    public void inbox_Data() {
        Toast.makeText(getApplicationContext(), "sent items ", Toast.LENGTH_LONG).show();
        Uri sentURI = Uri.parse("content://sms/sent");
        String[] reqCols = new String[]{"_id", "address", "body"};
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(sentURI, reqCols, null, null, null);

        adapter = new SimpleCursorAdapter(this, R.layout.list, c,
                new String[]{"body", "address"}, new int[]{
                R.id.lblMsg, R.id.lblNumber}, 0);
        list.setAdapter(adapter);

    }
}
