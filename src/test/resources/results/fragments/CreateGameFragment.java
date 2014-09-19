import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.EditText;

public class CreateGameFragment extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_game, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private EditText getGameName(){
        return (EditText) getView().findViewById(R.id.game_name);
    }

    private EditText getGameDescription(){
        return (EditText) getView().findViewById(R.id.game_description);
    }

    private EditText getGameUsersNumber(){
        return (EditText) getView().findViewById(R.id.game_users_number);
    }
}
