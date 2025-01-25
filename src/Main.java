public class Main {
    public static void main(String[] args) {
        boolean hinata = Login.authenticate(
                "Hinata",
                "01234@"
        );
        System.out.println(hinata);
    }
}