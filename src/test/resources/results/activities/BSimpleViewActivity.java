import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class MainActivity extends Activity  {

    @Bind(R.id.password) View password;
    @Bind(R.id.login) View login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);

    }

}
