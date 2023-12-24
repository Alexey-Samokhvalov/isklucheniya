public class Main {
    public static void main(String[] args) {
        String login = "user123";
        String password = "password123";
        String confirmPassword = "password123";
        boolean check = checkLoginAndPassword(login, password, confirmPassword);
        System.out.println(check);
    }

    public static boolean checkLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            if (login.matches("[a-zA-Z0-9_]+") && login.length() < 20) {
                if (password.matches("[a-zA-Z0-9_]+") && password.length() < 20 && password.equals(confirmPassword)) {
                    return true;
                } else {
                    throw new WrongPasswordException("Неверный пароль");
                }
            } else {
                throw new WrongLoginException("Неверный логин");
            }
        } catch (WrongPasswordException | WrongLoginException var4) {
            System.out.println(var4.getMessage());
            return false;
        }
    }
}