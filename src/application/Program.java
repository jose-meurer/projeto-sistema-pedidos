package application;

import entities.Order;
import enums.OrderStatus;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Order> list = new ArrayList<>();

        System.out.print("Quantos pedidos deseja cadastrar: ");
        Integer n = sc.nextInt();

        do {
            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.println("Dados do pedido: ");

                System.out.print("Id: ");
                Integer id = sc.nextInt();
                while (hasId(list, id)) {
                    System.out.println("Id existente, tente novamente: ");
                    id = sc.nextInt();
                }

                System.out.print("Nome do cliente: ");
                sc.nextLine();
                String name = sc.nextLine().toUpperCase();

                System.out.print("Valor do pedido: ");
                Double price = sc.nextDouble();

                Date date = new Date();

                System.out.printf("Pagamento pendente [1], %nProcessando [2], %nEnviado [3], %nEntregue [4] %n");
                System.out.print("Selecione o numero que corresponde ao estado do pedido: ");
                int status = sc.nextInt();

                OrderStatus orderStatus = Program.statusOrder(status);

                list.add(new Order(id, name, price, date, orderStatus));
            }

            System.out.println();
            System.out.print("Deseja cadastrar mais pedidos? s/n ");
            sc.nextLine();
            char reply = sc.next().charAt(0);
            if (reply == 's' || reply == 'S') {
                n = 1;
            } else {
                n = null;
            }
        } while (n != null);

        Program.showList(list); //Imprime a lista order

        System.out.println();
        System.out.print("Deseja alterar os dados de um pedido? s/n ");
        char changeStatus = sc.next().charAt(0);

        do {
            if (changeStatus == 's' || changeStatus == 'S') {
                System.out.print("Digite o id do pedido: ");
                int id = sc.nextInt();
                while (!hasId(list, id)) {
                    System.out.print("Id invalido, tente novamente: ");
                    id = sc.nextInt();
                }

                int buscaId = id;
                Order order = list.stream().filter(x -> x.getId() == buscaId).findFirst().orElse(null); //Erro ao usar a variavel id anterior
                System.out.printf("Qual campo deseja alterar? %nName [1], %nValor [2], %nStatus [3] %nSelecione o numero correspondente: ");
                int numberChangeStatus = sc.nextInt();

                switch (numberChangeStatus) {
                    case 1:
                        System.out.print("Novo nome: ");
                        sc.nextLine();
                        String changeName = sc.nextLine().toUpperCase();
                        order.setName(changeName);
                        break;
                    case 2:
                        System.out.print("Novo valor: ");
                        Double price = sc.nextDouble();
                        order.setPrice(price);
                        break;
                    case 3:
                        System.out.printf("Pagamento pendente [1], %nProcessando [2], %nEnviado [3], %nEntregue [4] %n");
                        System.out.print("Novo status: ");
                        int status = sc.nextInt();
                        order.setStatus(Program.statusOrder(status));
                        break;
                    default:
                        System.out.println("Valor invalido");
                        break;
                }

                Program.showList(list);

                System.out.println();
                System.out.print("Deseja alterar os dados de outro pedido? s/n ");
                changeStatus = sc.next().charAt(0);
            }
        } while (changeStatus == 's' || changeStatus == 'S');

        System.out.println();
        System.out.println("Programa Finalizado!");

        sc.close();
    }

    private static boolean hasId(List<Order> list, int id) { //Verificacao de id duplicado
        Order order = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return order != null;
    }

    private static void showList(List<Order> list) {
        System.out.println();
        System.out.println("Lista de pedidos: ");
        for (Order x : list) {
            System.out.println(x);
        }
    }

    private static OrderStatus statusOrder(int status) {
        Scanner sc = new Scanner(System.in);
        OrderStatus orderStatus = null;

        do {
            switch (status) {
                case 1:
                    orderStatus = OrderStatus.PENDING_PAYMENT;
                    break;
                case 2:
                    orderStatus = OrderStatus.PROCESSING;
                    break;
                case 3:
                    orderStatus = OrderStatus.SHIPPED;
                    break;
                case 4:
                    orderStatus = OrderStatus.DELIVERED;
                    break;
                default:
                    System.out.print("Valor invalido, tente novamente: ");
                    status = sc.nextInt();
                    break;
            }
        } while (status > 4);

        return orderStatus;
    }
}
