package enums;

public enum OrderStatus {
    PENDING_PAYMENT(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(4);

    // Caso precise retornar algum valor numerico para o sistema
    private int valor;

    OrderStatus(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
