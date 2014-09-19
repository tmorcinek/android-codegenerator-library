import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

public class GameListItemFragment extends Fragment  {

    private TextView title;
    private TextView description;
    private TextView usersNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_list_item, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        usersNumber = (TextView) view.findViewById(R.id.users_number);
    }

}
