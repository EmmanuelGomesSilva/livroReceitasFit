
public class Receita {
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private String categoria;
    private int tempoPreparo;
    private int porcoes;


    public Receita(String nome, String ingredientes, String modoPreparo, String categoria, int tempoPreparo, int porcoes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
        this.porcoes = porcoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public int getPorcoes() {
        return porcoes;
    }

    public void setPorcoes(int porcoes) {
        this.porcoes = porcoes;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nIngredientes: " + ingredientes +
                "\nModo de Preparo: " + modoPreparo +
                "\nCategoria: " + categoria +
                "\nTempo de Preparo: " + tempoPreparo + " min" +
                "\nPorções: " + porcoes;
    }

}
