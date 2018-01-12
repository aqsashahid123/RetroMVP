package pf.aqsa.com.retromvp.Model;

/**
 * Created by Mahek on 1/12/2018.
 */

public class ServerEvent {


    private ServerResponse serverResponse;

    public ServerEvent(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }


}
