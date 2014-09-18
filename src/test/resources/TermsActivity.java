import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;


public class TermsActivity extends Activity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms);

        findViewById(R.id.button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                //TODO implement
                break;

        }
    }

    private CheckBox getAcceptsTerms(){
        return (CheckBox) findViewById(R.id.accepts_terms);
    }


}
