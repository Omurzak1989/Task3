public class Main {
    public static void main(String[] args) {

                String password = "TestPassword123";

                try {
                    checkPassword(password);
                    System.out.println("Пароль туура тузулду.");
                } catch (PasswordFormatException e) {
                    System.out.println(e.getMessage());
                }
            }

            public static void checkPassword(String password) throws PasswordFormatException {
                if (password.length() < 8) {
                    throw new PasswordFormatException("Парольдун көбүрөөк 8 символдуу болушу керек.");
                }

                boolean hasLowerCase = false;
                boolean hasUpperCase = false;
                boolean hasDigit = false;
                boolean hasSpecialChar = false;

                for (char ch : password.toCharArray()) {
                    if (Character.isLowerCase(ch)) {
                        hasLowerCase = true;
                    } else if (Character.isUpperCase(ch)) {
                        hasUpperCase = true;
                    } else if (Character.isDigit(ch)) {
                        hasDigit = true;
                    } else {
                        hasSpecialChar = true;
                    }
                }

                if (!hasLowerCase || !hasUpperCase || !hasDigit || !hasSpecialChar) {
                    throw new PasswordFormatException("Пароль LowerCase, UpperCase, цифра жана атайын символдордун бардык эрежелерин камтыш келтирүү керек.");
                }
            }
        }

        class PasswordFormatException extends Exception {
            public PasswordFormatException(String message) {
                super(message);
            }
        }


