public class Sapato {
    private String marca;
    private int tamanho;
    private double preco;

    public Sapato(String marca, int tamanho, double preco) {
        this.marca = marca;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }
}
