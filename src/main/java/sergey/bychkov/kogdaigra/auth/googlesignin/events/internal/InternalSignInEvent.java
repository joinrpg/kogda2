package sergey.bychkov.kogdaigra.auth.googlesignin.events.internal;



import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import sergey.bychkov.kogdaigra.auth.googlesignin.GoogleSignin;

/**
 * Custom event to capture (internally) google sign in events
 */
@DomEvent("google-signin-aware-success")
public class InternalSignInEvent extends ComponentEvent<GoogleSignin> {
    private String idToken;

    public InternalSignInEvent(GoogleSignin source, boolean fromClient,
            @EventData("event.detail.id_token") String idToken) {
        super(source, fromClient);
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
