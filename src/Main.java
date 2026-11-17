import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorGastos gerenciador = new GerenciadorGastos();
        int op;

        do {
            System.out.println("=== CONTROLE DE GASTOS ===");
            System.out.println("1 - Adicionar gasto");
            System.out.println("2 - Listar gastos");
            System.out.println("3 - Resumo do mês");
            System.out.println("0 - Sair");
            op = lerInteiro(sc, "Escolha: ");

            switch (op) {
                case 1 -> {
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    BigDecimal valor = lerValor(sc);
                    LocalDate data = lerData(sc);
                    Categoria categoria = lerCategoria(sc);
                    try {
                        Gasto g = new Gasto(descricao, valor, data, categoria);
                        gerenciador.adicionar(g);
                        System.out.println("Gasto adicionado");
                    } catch (ValorInvalidoException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2 ->
                    gerenciador.listar();

                case 3 ->
                    System.out.println("Em breve");

                case 0 ->
                    System.out.println("Até breve");

                default -> System.out.println("Opção inválida");


            }
                } while (op !=0);

        sc.close();
    }
    private static int lerInteiro(Scanner sc, String mensagem) {
        while (true){
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válidas.");
            }
        }
    }

    private static BigDecimal lerValor(Scanner sc) {
        while (true) {
            System.out.print("Valor (ex: 32,50): ");
            String texto = sc.nextLine().replace(",", ".");
            try {
                return new BigDecimal(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido");
            }
        }

    }

    private static LocalDate lerData (Scanner sc) {
        while (true) {
            System.out.print("Data: (dd/MM/aaaa Enter = hoje): ");
            String texto = sc.nextLine();
            if (texto.isBlank()) {
                return LocalDate.now();
            } try {
                return LocalDate.parse(texto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Digite uma data válida");
            }
        }

    }

    private static Categoria lerCategoria (Scanner sc) {
        while (true) {
            Categoria[] categorias = Categoria.values();
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i+1) + " - " + categorias[i]);
            } try {
                int escolha = lerInteiro(sc, "Categoria: ");
                return categorias[escolha - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Escolha uma categoria vállida");
            }
        }
    }

}

