import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button) void onClickButton() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onLongClickButton() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.imageButton) void onClickImageButton() {
        //TODO implement
    }

    @OnLongClick(R.id.imageButton) boolean onLongClickImageButton() {
        //TODO implement
        return true;
    }
}
