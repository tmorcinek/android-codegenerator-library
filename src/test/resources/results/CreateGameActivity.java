public class CreateGameActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_game);


    }

    private EditText getGameName(){
        return (EditText) findViewById(R.id.game_name);
    }

    private EditText getGameDescription(){
        return (EditText) findViewById(R.id.game_description);
    }

    private EditText getGameUsersNumber(){
        return (EditText) findViewById(R.id.game_users_number);
    }


}
