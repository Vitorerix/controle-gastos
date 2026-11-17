import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gasto {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private Categoria categoria;


    public Gasto(String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        if  (valor.compareTo(BigDecimal.ZERO)<=0) {
            throw new ValorInvalidoException("Valor deve ser maior que zero");
        }
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(fmt) +  " | " +  descricao +  " | " +  valor + " | " + categoria;
    }
}