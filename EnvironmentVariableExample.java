public class EnvironmentVariableExample {
  public static void main(String[] args) {
    String environmentVariable = System.getenv("DB_HOST");
    System.out.println("Env Var: "+ environmentVariable);
  }
}

