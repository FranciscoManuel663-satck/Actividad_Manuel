public class CalculadoraLogica {

    private double num1;
    private String operacion;

    public void setPrimerNumero(double num1) {
        this.num1 = num1;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void limpiar() {
        this.num1 = 0;
        this.operacion = "";
    }

    public double calcular(double num2) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("No se puede dividir entre 0");
                }
                return num1 / num2;
            default:
                throw new IllegalStateException("No hay operación seleccionada");
        }
    }
}
