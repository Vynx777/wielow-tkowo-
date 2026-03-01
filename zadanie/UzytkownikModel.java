public class UzytkownikModel {

    public boolean walidujLogowanie(String user, String pass) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        return "admin".equals(user) && "haslo123".equals(pass);
    }
}