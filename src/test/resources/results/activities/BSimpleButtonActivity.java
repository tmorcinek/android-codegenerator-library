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

    @OnClick(R.id.button) void onButtonClick() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onButtonLongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.imageButton) void onImageButtonClick() {
        //TODO implement
    }

    @OnLongClick(R.id.imageButton) boolean onImageButtonLongClick() {
        //TODO implement
        return true;
    }
}
