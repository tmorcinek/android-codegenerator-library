import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.List;

public class MainActivity extends Activity  {

    @Bind(R.id.list) List list;

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

    @OnItemClick(R.id.list) void onItemClick(int position) {
        //TODO implement
    }
}
