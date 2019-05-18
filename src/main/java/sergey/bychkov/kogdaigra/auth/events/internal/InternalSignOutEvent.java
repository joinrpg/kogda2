package sergey.bychkov.kogdaigra.auth.events.internal;



import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import sergey.bychkov.kogdaigra.auth.GoogleSignin;

@DomEvent("google-signout-attempted")
public class InternalSignOutEvent extends ComponentEvent<GoogleSignin> {
    public InternalSignOutEvent(GoogleSignin source, boolean fromClient) {
        super(source, fromClient);
    }
}
