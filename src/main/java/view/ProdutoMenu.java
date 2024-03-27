package view;

import controller.ProdutoDAO;
import model.Produto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class ProdutoMenu {
    public static void main(String[] args)throws SQLException {





        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("MENU PRODUTO");
        System.out.print("[1]Listar\n[2]Buscar\n[3]Inserir\n[4]Atualizar\n[5]Remover\n[0]Sair\n\tOpcao: ");
        opcao = sc.nextInt();
        if (opcao == 1) {
            ArrayList<Produto> categorias = ProdutoDAO.listar();
            System.out.println("+-----------------------------+");
            System.out.printf("| %-4s | %-20s |%n", "ID", "NOME");
            System.out.println("+-----------------------------+");
            for (Produto categoria : categorias) {
                System.out.println(categoria.toString());
            }
            System.out.println("+-----------------------------+");
        } else if (opcao == 2) {
            System.out.print("\u001B[31m Informe o ID do Produto: ");
            int id = sc.nextInt();
            Produto produto = ProdutoDAO.bucarUm(id);
            System.out.println("\u001B[0m");
            System.out.println("+-----------------------------+");
            System.out.printf("| %-4s | %-20s |%n", "ID", "NOME");
            System.out.println("+-----------------------------+");
            System.out.println(produto);
            System.out.println("+-----------------------------+");

        } else if (opcao == 3) {
            System.out.print("\u001B[31m Informe o nome para Produto: ");
            String nome = sc.next();
            System.out.println("\u001B[0m");
            Produto novaProduto = new Produto();
            novaProduto.setNome(nome);
            ProdutoDAO.incluir(novaProduto);
        } else if (opcao == 4) {
            System.out.print("\u001B[31m Informe o ID da Produto: ");
            int id = sc.nextInt();
            System.out.print("\u001B[31m Informe o novo nome para Produto: ");
            String nome = sc.next();
            System.out.println("\u001B[31m Informe o nova descrição para Produto: ");
            String descricao = sc.next();
            System.out.println("\u001B[31m Informe o novo preço para Produto: ");
            Double preco = Double.valueOf(sc.next());
            System.out.println("\u001B[31m Informe o nova quantidade para Produto: ");
            Double quantidade = Double.valueOf(sc.next());
            System.out.println("\u001B[31m Informe o novo id_fornecedor Produto: ");
            Integer id_fornecedor = Integer.valueOf(sc.next());
            System.out.println("\u001B[31m Informe o novo ide_categoria Produto: ");
            Integer id_categoria = Integer.valueOf(sc.next());
            System.out.println("\u001B[31m Informe o nova marca para Produto: ");
            String marca = sc.next();
            System.out.println("\u001B[31m Informe o nova data de validade para Produto: ");
            LocalDate data_validade = LocalDate.parse(sc.next());
            System.out.println("\u001B[31m Informe o novo lote para Produto: ");
            String lote = sc.next();
            System.out.println("\u001B[0m");
            Produto novaProduto = new Produto( id, nome, descricao, preco, quantidade, id_fornecedor, id_categoria, marca, data_validade, lote);
            ProdutoDAO.atualizar(novaProduto);
        } else if (opcao == 5) {
            System.out.print("\u001B[31m Informe o ID da Produto: ");
            int id = sc.nextInt();
            System.out.println("\u001B[0m");
            ProdutoDAO.remover(id);
        }

    }


    public void lerdados(){
    }
}


