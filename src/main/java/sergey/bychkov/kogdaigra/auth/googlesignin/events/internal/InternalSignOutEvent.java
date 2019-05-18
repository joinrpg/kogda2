package sergey.bychkov.kogdaigra.auth.googlesignin.events.internal;


import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import sergey.bychkov.kogdaigra.auth.googlesignin.GoogleSignin;

@DomEvent("google-signout-attempted")
public class InternalSignOutEvent extends ComponentEvent<GoogleSignin> {
    public InternalSignOutEvent(GoogleSignin source, boolean fromClient) {
        super(source, fromClient);
    }
}
