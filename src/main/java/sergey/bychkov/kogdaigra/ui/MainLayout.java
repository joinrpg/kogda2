/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import sergey.bychkov.kogdaigra.auth.GoogleSignin;
import sergey.bychkov.kogdaigra.auth.events.UserLoginEvent;
import sergey.bychkov.kogdaigra.backend.IDataService;
import sergey.bychkov.kogdaigra.model.old.User;

/**
 *
 * @author bychkov-sy
 */
@HtmlImport("frontend://bower_components/vaadin-lumo-styles/presets/compact.html")
@Theme(value = Lumo.class)
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@PWA(name = "Project Kogda Igra", shortName = "KogdaIgra", enableInstallPrompt = false)
public class MainLayout extends AppLayout implements RouterLayout {

    private Div header;
    private final Label userName;
    @Autowired
    private IDataService data;
    private final Button controlPanel;
    private static final Logger LOG = Logger.getLogger(MainLayout.class.getName());

    public MainLayout() {
        LOG.info("MainLayout created");
        AppLayoutMenu menu = createMenu();
        menu.addMenuItem(new AppLayoutMenuItem("Календарь", ""));
        menu.addMenuItem(new AppLayoutMenuItem("О нас", "about"));
        menu.addMenuItem(new AppLayoutMenuItem("Рецензии", "review"));
        menu.addMenuItem(new AppLayoutMenuItem("Фото", "photo"));

        Anchor anchor = new Anchor("http://rpg.ru/newb", "Новичку");

        menu.addMenuItem(anchor);
        GoogleSignin signin = new GoogleSignin("374072031709-6jhstubu88736naq8ahs8iimcfg5prpm.apps.googleusercontent.com");
        controlPanel = new Button("Панель управления", event -> {
            UI.getCurrent().navigate("controlpanel");
        });
        controlPanel.setVisible(false);
        userName = new Label();
        signin.setAutoLogout(false);
        signin.addLoginListener(this::login);
        userName.getStyle().set("left-margin", "auto");
        signin.getElement().getStyle().set("left-margin", "auto");
        signin.addLogoutListener(this::logout);
        HorizontalLayout hl = new HorizontalLayout(controlPanel, userName, signin);
        VerticalLayout vl = new VerticalLayout();
        vl.add(hl);
        setContent(vl);
    }

    private void login(UserLoginEvent event) {
        //Notification.show("Welcome, " + event.getFirstName());
        LOG.info("Logged in as " + event.getName());
        userName.setText(event.getName());
        String userId = event.getUserId();
        VaadinSession session = VaadinSession.getCurrent();
        session.access(() -> session.setAttribute("user", event));
        List<User> userByEmail = data.getUserByEmail(event.getEmail());

        if (userByEmail != null && !userByEmail.isEmpty()) {
            User usr = userByEmail.get(0);
            usr.setLastvisit(new Date());
            data.updateUser(usr);
            List<GrantedAuthority> ga = new ArrayList<>();
            usr.getPriveleges().stream().filter(Objects::nonNull).anyMatch(p -> {
                LOG.info("User " + usr.getName() + " has privelege " + p.getName());
                ga.add(new SimpleGrantedAuthority(p.getName()));
                return p.getName().contains("EDIT");
            });
            Authentication auth = new PreAuthenticatedAuthenticationToken(usr, event, ga);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
            controlPanel.setVisible(usr.getPriveleges().stream().filter(Objects::nonNull).anyMatch(p -> {
                return p.getName().contains("EDIT");
            }));
        }
    }

    private void logout() {
        userName.setText("");
        VaadinSession.getCurrent().setAttribute("user", null);
        VaadinSession.getCurrent().getSession().invalidate();
        controlPanel.setVisible(false);
    }

    ;
    @PostConstruct
    public void register() {

        RouteConfiguration routeCfg = RouteConfiguration.forApplicationScope();
          if (!routeCfg.isPathRegistered("")) {
              routeCfg.setRoute("", MainView.class, MainLayout.class);
          }
        data.getYears().stream().filter(year -> !routeCfg.isPathRegistered(String.valueOf(year)))
                .forEach(year -> routeCfg.setRoute(String.valueOf(year), ByYearView.class, MainLayout.class));
        data.getRegions(null).stream().filter(region -> {
            return !routeCfg.isPathRegistered(region.getShortName());
        }).forEach(region -> {
            routeCfg.setRoute(region.getShortName(), ByRegionView.class, MainLayout.class);
        });

    }

}
