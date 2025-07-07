import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LivroReceitas {

    private ArrayList<Receita> receitas = new ArrayList<>();

    public void adicionarReceita(Receita receita) {
        receitas.add(receita);
        System.out.println("Receita adicionada com sucesso!");

    }

    public void listarReceitas() {
        if (receitas.isEmpty()) { //verifica se a lista está vazia.
            System.out.println("Nenhuma receita cadastrada.");
        } else {
            for (int i = 0; i < receitas.size(); i++) { //i é o índice (posição) da receita na lista, que usamos como "ID".
                System.out.println("ID: " + i);
                System.out.println(receitas.get(i)); //receitas.get(i) pega a receita naquela posição.
                System.out.println("------------------------");
            }
        }
    }

    public void atualizarReceita(int id, Receita receita) {
        if (id >= 0 && id < receitas.size()) { //Verifica se o ID é válido (não pode ser negativo e deve estar dentro do tamanho da lista).
            receitas.set(id, receita); //Se válido, substitui a receita antiga pela nova na posição id.
            System.out.println("Receita atualizada com sucesso!");
        } else {
            System.out.println("ID inválido");//Caso contrário, avisa que o ID é inválido.


        }

    }

    public void removerReceita(int id) {//Recebe o ID da receita a ser removida
        if (id >= 0 && id < receitas.size()) { //Verifica se o ID é válido.
            receitas.remove(id); //Se válido, remove a receita da lista naquela posição.
            System.out.println("Receita removida com sucesso!");
        } else {
            System.out.println("ID inválido.");
        }

    }

    public void buscarPorNome(String nome) {
        boolean encontrou = false;
        if (receitas.isEmpty()) {
            System.out.println("Nenhuma receita casdatrada!");
        } else {
            for (int i = 0; i < receitas.size(); i++) {
                Receita r = receitas.get(i);
                if (r.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println("ID: " + i);
                    System.out.println(r);
                    System.out.println("----------------------");
                    encontrou = true;
                }
            }
            if ((!encontrou)) {
                System.out.println("Nenhuma receita cadastrada com o nome informado. ");
            }
        }

    }

    public void salvarReceitasEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Receita r : receitas) {
                writer.write(r.getNome());
                writer.newLine();
                writer.write(r.getIngredientes());
                writer.newLine();
                writer.write(r.getModoPreparo());
                writer.newLine();
                writer.write(r.getCategoria());
                writer.newLine();
                writer.write(String.valueOf(r.getTempoPreparo()));
                writer.newLine();
                writer.write(String.valueOf(r.getPorcoes()));
                writer.newLine();
                writer.write("----");
                writer.newLine();
            }
            System.out.println("Receitas salvas com sucesso no arquivo: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void carregarReceitasDeArquivo(String nomeArquivo) {
        receitas.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String nome;
            while ((nome = reader.readLine()) != null) {
                String ingredientes = reader.readLine();
                String modoPreparo = reader.readLine();
                String categoria = reader.readLine();
                int tempoPreparo = Integer.parseInt(reader.readLine());
                int porcoes = Integer.parseInt(reader.readLine());
                reader.readLine();

                Receita receita = new Receita(nome, ingredientes, modoPreparo, categoria, tempoPreparo, porcoes);
                receitas.add(receita);
            }
            System.out.println("Receitas carregadas do arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado, começando com lista vazia.");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler números do arquivo.");
        }
    }


    public ArrayList<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(ArrayList<Receita> receitas) {
        this.receitas = receitas;
    }
}
