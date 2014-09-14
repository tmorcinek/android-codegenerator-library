package ;


public class ViewPagerActivity extends Activity  {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        pager = (ViewPager) findViewById(R.id.pager);

    }


}
