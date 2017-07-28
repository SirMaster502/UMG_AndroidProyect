package curso.umg.gt.umgappproject;

/**
 * Created by repre on 27/07/2017.
 */

public class RestService {
    private static final String URL = "http://servicioWebAp.azurewebsites.net/api";
    private retrofit.RestAdapter restAdapter;
    private InstituteServicio apiService;

    public RestService()
    {
        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        apiService = restAdapter.create(InstituteServicio.class);
    }

    public InstituteServicio getService()
    {
        return apiService;
    }
}
