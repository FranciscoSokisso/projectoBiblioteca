package ProjectoFacil;

import java.util.Scanner;

public class Membro {
    Scanner leitor = new Scanner(System.in);
    private String nome;
    private int numeroDeMembro;
    private Livro[] livrosEmprestados = new Livro[0];
    private Livro livro;
    int quant=-1;

    public Membro(String nome, int numeroDeMembro){
        this.nome = nome;
        this.numeroDeMembro = numeroDeMembro;
    }

    protected Membro(Livro livro){
        this.livro= livro;
    }
    

    public void adicionarLivroAoVectorDeLivrosEmprestados(Livro livro){
        
        livro.setEstado(Estado.EMPRESTADO);
        Livro[] livrosAuxi = new Livro[this.livrosEmprestados.length];
        livrosAuxi = livrosEmprestados;
        this.livrosEmprestados = new Livro[livrosAuxi.length+1];

        if (livrosEmprestados[0] == null && quant == -1){
         livrosEmprestados[0] = livro;
         quant=0;
        return;
        }
        else{
            for (int i = 0; i < livrosAuxi.length; i++) { 
                this.livrosEmprestados[i] = livrosAuxi[i];
        }              
                quant+=1;
                this.livrosEmprestados[quant]= livro;
                System.out.println("Livro adicionado: "+livrosEmprestados[quant].getTitulo());
                return;
        }
    }
  
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNumeroDeMembro(int numeroDeMembro){
        this.numeroDeMembro = numeroDeMembro;
    }

    public String getNome(){
        return this.nome;
    }

    public int getNumeroDeMembro(){
        return this.numeroDeMembro;
    }

    public void setLivrosEmprestados(Livro[] livros){
        this.livrosEmprestados = livros;
    }

    public Livro[] getLivrosEmprestados(){
        return this.livrosEmprestados;
    }


    public int getQuanr(){
        return this.quant;
    }

     public void setLivro(Livro livro){
        this.livro = livro;
    }

    public Livro getLivro(){
        return this.livro;
    }


    public void listarLivrosDoMembro(){
        if (livrosEmprestados!=null) {
            System.out.println("------- Livro de "+getNome()+" --------");
            for (int i = 0; i < livrosEmprestados.length; i++) {
                if (livrosEmprestados[i]==null) return;
                System.out.println("Título: "+livrosEmprestados[i].getTitulo());
                System.out.println("Autor: "+livrosEmprestados[i].getAutor());
                System.out.println("ISBN: "+livrosEmprestados[i].getISBN());
                System.out.println("Estado: "+livrosEmprestados[i].getEstado());
            }
        }
    }

}
