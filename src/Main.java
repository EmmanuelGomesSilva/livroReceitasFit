import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pasta atual do programa: " + System.getProperty("user.dir"));


        LivroReceitas livroReceitas = new LivroReceitas();
        livroReceitas.carregarReceitasDeArquivo("receitas.txt");




        int opcao;
        do {

            System.out.println("=== MENU DE OPÇÕES ===");
            System.out.println("1 - Adicionar receita");
            System.out.println("2 - Listar receitas");
            System.out.println("3 - Atualizar receita");
            System.out.println("4 - Remover receita");
            System.out.println("5 - Buscar receita por nome");
            System.out.println("6 - Salvar receita em arquivo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:{

                    System.out.println("Informe o nome da receita a ser adicionada: ");
                    String nome = scanner.nextLine();

                    System.out.println("Informe os ingredientes:");
                    String ingredientes = scanner.nextLine();

                    System.out.println("Informe o mode de preparo: ");
                    String modoPreparo = scanner.nextLine();

                    System.out.println("Informe a categoria (Fit, Low Carb, Sem glutén, Sem lactose, Vegana");
                    String categoria= scanner.nextLine();

                    System.out.println("Informe o tempo de preparo: ");
                    int tempoPreparo = scanner.nextByte();

                    System.out.println("Informe a quantidade rendimento (Porções): ");
                    int porcoes = scanner.nextInt();
                    scanner.nextLine();

                    Receita receita = new Receita(nome, ingredientes, modoPreparo,categoria, tempoPreparo, porcoes);
                    livroReceitas.adicionarReceita(receita);
                    break;
                }

                case 2: {
                    livroReceitas.listarReceitas();
                    break;
                }
                case 3:{

                    System.out.println("Informe o ID da receita que será atualizada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (id < 0 || id >= livroReceitas.getReceitas().size()){
                        System.out.println("ID inválido! Nenhuma receita foi atualizada.");
                        break;
                    }

                    System.out.println("informe o novo nome da receita: ");
                    String novoNome = scanner.nextLine();

                    System.out.println("Informe os novos ingredientes: ");
                    String novoIngrediente = scanner.nextLine();

                    System.out.println("Informe o modo de preparo: ");
                    String novoModo = scanner.nextLine();

                    System.out.println("Informe a nova categoria (Fit, Low Carb, Sem glutén, Sem lactose, Vegana");
                    String novaCategoria = scanner.nextLine();

                    System.out.println("Informe o tempo de preparo: ");
                    int novoTempo = scanner.nextInt();

                    System.out.println("Informe a quantidade de rendimento (Porções)");
                    int novaQtd = scanner.nextInt();

                    Receita novaReceita = new Receita(novoNome, novoIngrediente, novoModo, novaCategoria, novoTempo, novaQtd);
                    livroReceitas.atualizarReceita(id, novaReceita);

                    break;
                }
                case 4:{

                    System.out.println("Informe o ID da receita que deseja remover: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Você escolheu remover a seguinte receita: ");
                    System.out.println(livroReceitas.getReceitas().get(id));

                    System.out.println("Tem certeza que deseja excluir a receita? (S/N):  ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("s")){
                        livroReceitas.removerReceita(id);
                    }else {
                        System.out.println("Exclusão cancelada.");
                    }
                    break;

                }
                case 5:{
                    System.out.println("Informe o nome da receita que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();
                    livroReceitas.buscarPorNome(nomeBusca);
                    break;
                }
                case 6:
                    livroReceitas.salvarReceitasEmArquivo("receitas.txt");
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! ");
                    break;
            }

        } while (opcao != 0);
    }
}
//teste de commmit via intellij