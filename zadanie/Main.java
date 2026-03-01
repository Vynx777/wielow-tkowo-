import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UzytkownikModel model = new UzytkownikModel();
                GlownyView view = new GlownyView();

                new GlownyController(view, model);

                view.setVisible(true);
            }
        });
    }
}
