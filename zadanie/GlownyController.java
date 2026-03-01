import javax.swing.*;
import java.awt.Color;
import java.util.concurrent.ExecutionException;

public class GlownyController {
    private final GlownyView view;
    private final UzytkownikModel model;

    public GlownyController(GlownyView view, UzytkownikModel model) {
        this.view = view;
        this.model = model;
        this.view.addLoginListener(e -> wykonajLogowanie());
    }

    private void wykonajLogowanie() {
        String user = view.getUsername();
        String pass = view.getPassword();

        view.setLoginButtonEnabled(false);
        view.setStatusMessage("Trwa weryfikacja danych...", Color.BLUE);

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() {
                return model.walidujLogowanie(user, pass);
            }

            @Override
            protected void done() {
                try {
                    boolean czyZalogowano = get();
                    if (czyZalogowano) {
                        view.setStatusMessage("Logowanie pomyślne!", new Color(0, 150, 0));
                    } else {
                        view.setStatusMessage("Błędny login lub hasło!", Color.RED);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.setStatusMessage("Wystąpił błąd serwera.", Color.RED);
                    ex.printStackTrace();
                } finally {
                    view.setLoginButtonEnabled(true);
                }
            }
        };

        worker.execute();
    }
}