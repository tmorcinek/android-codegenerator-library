import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.List;

public class FormActivity extends Activity  {

    @Bind(R.id.edit_text_name) EditText editTextName;
    @Bind(R.id.edit_text_city) EditText editTextCity;
    @Bind(R.id.header_text) TextView headerText;
    @Bind(android.R.id.list) List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.imageButton) void onClickImageButton() {
        //TODO implement
    }

    @OnLongClick(R.id.imageButton) boolean onLongClickImageButton() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button) void onClickButton() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onLongClickButton() {
        //TODO implement
        return true;
    }

    @OnItemClick(android.R.id.list) void onItemClick(int position) {
        //TODO implement
    }
}
