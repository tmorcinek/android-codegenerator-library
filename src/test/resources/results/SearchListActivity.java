import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class SearchListActivity extends Activity  {

    private ListView list;
    private TextView empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list);

        list = (ListView) findViewById(android.R.id.list);
        empty = (TextView) findViewById(android.R.id.empty);

    }

    private EditText getSearchEditText(){
        return (EditText) findViewById(R.id.search_edit_text);
    }


}
