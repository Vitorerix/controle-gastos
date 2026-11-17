import java.util.ArrayList;
import java.util.List;

public class GerenciadorGastos {
    private List<Gasto> gastos = new ArrayList<>();

    public void adicionar(Gasto gasto) {
        gastos.add(gasto);
    }

    public void listar() {
        if (gastos.isEmpty()) {
            System.out.println("Lista de gastos vazia");
        } else {
            gastos.forEach(System.out::println);
        }

    }


}
