import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.List;

public class FormActivity extends Activity implements OnClickListener {

    private TextView headerText;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        headerText = (TextView) findViewById(R.id.header_text);
        list = (List) findViewById(android.R.id.list);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton:
                //TODO implement
                break;
            case R.id.button:
                //TODO implement
                break;
        }
    }

    private EditText getEditTextName(){
        return (EditText) findViewById(R.id.edit_text_name);
    }

    private EditText getEditTextCity(){
        return (EditText) findViewById(R.id.edit_text_city);
    }
}
