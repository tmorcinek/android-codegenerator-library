import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;

public class ButterknifeSimpleActivity extends Activity  {

    @Bind(R.id.password) EditText password;
    @Bind(R.id.username) EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.butterknife_simple);
        ButterKnife.bind(this);

    }

}
