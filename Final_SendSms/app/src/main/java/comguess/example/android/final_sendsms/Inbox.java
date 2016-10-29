package comguess.example.android.final_sendsms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Inbox extends AppCompatActivity {
ListView list;
    SimpleCursorAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        list = (ListView)findViewById(R.id.list);
        inbox_Data();
    }
    public void inbox_Data() {
            Uri inboxURI = Uri.parse("content://sms/inbox");
            String[] reqCols = new String[]{"_id", "address", "body"};
            ContentResolver cr = getContentResolver();
            Cursor c = cr.query(inboxURI, reqCols, null, null, null);

            adapter = new SimpleCursorAdapter(this, R.layout.list, c,
                    new String[]{"body", "address"}, new int[]{
                    R.id.lblMsg, R.id.lblNumber}, 0);

            list.setAdapter(adapter);

    }
}
