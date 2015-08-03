package zenika.jbehave.calculator;

public class CalculatriceContext {

    private static ThreadLocal<CalculatriceContext> threadContext = new ThreadLocal<CalculatriceContext>();
    private final Calculatrice calculatrice;
    private Exception lastError;

    public CalculatriceContext() {
        calculatrice = new Calculatrice();
    }

    public static CalculatriceContext context() {
        return threadContext.get();
    }

    public static Calculatrice calculator() {
        return context().getCalculatrice();
    }

    public static void initialize() {
        // one does not rely on ThreadLocal#initialValue()
        // so that one is sure only initialize create a new instance
        threadContext.set(new CalculatriceContext());
    }

    public static void dispose() {
        threadContext.remove();
    }

    public Calculatrice getCalculatrice() {
        return calculatrice;
    }

    public Exception getLastError() {
        return lastError;
    }

    public void setLastError(Exception lastError) {
        this.lastError = lastError;
    }
}
