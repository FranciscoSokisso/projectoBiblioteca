package ProjectoFacil;


public class Biblioteca {
    private Livro[] livrosDaBiblioteca = new Livro[0];
    private Membro[] membrosDaBiblioteca = new Membro[0];
    private int quantidade=-1;
    private int quantidade2 = -1;

    public void setLivrosDaBiblioteca(Livro[] livros){
        this.livrosDaBiblioteca = livros;
    }


    public Livro[] getLivrosDaBiblioteca(){
        return this.livrosDaBiblioteca;
    }

    public Membro[] getMembros(){
        return this.membrosDaBiblioteca;
    } 
    
    public void emprestarUmLivroAumMembro(Livro livro, Membro membro){
            for (int i = 0; i < livrosDaBiblioteca.length; i++) {
                if (this.getLivrosDaBiblioteca()[i]==livro){membro.adicionarLivroAoVectorDeLivrosEmprestados(livro);
                    return ;
                }
                
                     else
                        continue;
            }    
            System.out.println("Livro não encontrado no acervo da biblioteca.");
                return ;
    }

    // métodos
    public void adicionarLivroAoAcervo(Livro livro){
        Livro[] livros = new Livro[livrosDaBiblioteca.length];
        livros = livrosDaBiblioteca;
        livrosDaBiblioteca = new Livro[livros.length+1];

        if (livrosDaBiblioteca[0] == null && quantidade==-1) {
            livrosDaBiblioteca[0] = livro;
            quantidade = 0;
        }else{
            if (livros!=null) 
            for (int i = 0; i < livros.length; i++) 
                livrosDaBiblioteca[i] = livros[i];
        quantidade+=1;
        livrosDaBiblioteca[quantidade] = livro;
        }
        
    }
    
    public void registrarUmNovoMembro(Membro membro){
        Membro[] membros1 = new Membro[membrosDaBiblioteca.length];
        membros1 = membrosDaBiblioteca;
        membrosDaBiblioteca = new Membro[membros1.length+1];

        if(membrosDaBiblioteca[0] == null && quantidade2==-1){
            membrosDaBiblioteca[0]= membro;
            quantidade2=0;
        }else{
             if (membros1!= null) 
            for (int i = 0; i < membros1.length; i++){
            membrosDaBiblioteca[i] = membros1[i];
        }
              
            quantidade2+=1;
            membrosDaBiblioteca[quantidade2] = membro;
        }

        
    }

    public void listarLivrosDaBiblioteca(){
            if (livrosDaBiblioteca!= null) 
                System.out.println("---- Listagem dos Livros da Biblioteca ----");
                for (int i = 0; i < livrosDaBiblioteca.length; i++) {
                    if (getLivrosDaBiblioteca()[i] == null) return;
                    System.out.println("-------------------------------");
                    System.out.println("Tilulo: "+getLivrosDaBiblioteca()[i].getTitulo());
                    System.out.println("Autor: "+getLivrosDaBiblioteca()[i].getAutor());
                    System.out.println("Estado:" +getLivrosDaBiblioteca()[i].getEstado());
                    System.out.println("ISBN: "+ getLivrosDaBiblioteca()[i].getISBN());
                }
    }

      public void listarMembrosDaBiblioteca(){
                if (membrosDaBiblioteca!=null)
                for (int i = 0; i < membrosDaBiblioteca.length; i++) {
                    if (getMembros()[i] == null) return;
                    System.out.println("-------------------------------------");
                    System.out.println("Nome: "+getMembros()[i].getNome());
                    System.out.println("Numero: " +getMembros()[i].getNumeroDeMembro());
                }
    }

    public void listarLivrosEmprestdosDeUmMembro(Membro membro){
        if (membro==null) {System.out.println("Membro não encontrado."); return;}
            int delimitador = membro.getQuanr();
            if (membro.getLivrosEmprestados()!= null && membro!=null) 
                for (int i = 0; i < delimitador+1; i++) {
                    System.out.println("Título: "+membro.getLivrosEmprestados()[i].getTitulo());
                    System.out.println("Estado: "+membro.getLivrosEmprestados()[i].getEstado());
                }  
    }

    public void devolverUmLivro(Livro livro, Membro membro){
            if (membro==null || livro == null){
                System.out.println("Actualize os seus dados.."+"\n");
                return;
            }
            if(membro!= null)
                for (int i = 0; i < membro.getLivrosEmprestados().length; i++) {
                    if (membro.getLivrosEmprestados()[i]==livro) {
                       for (int j = 0; j < livrosDaBiblioteca.length; j++) {
                            if (this.livrosDaBiblioteca[j]==livro) {
                                this.livrosDaBiblioteca[j].setEstado(Estado.DISPONIVEL);
                            }
                       }
                    }
                    membro.getLivrosEmprestados()[i] = null;
                    return;
                }
            
    }

    public void livrosDisponiveis(){
        if (this.livrosDaBiblioteca!=null) {
            System.out.println("--------- Livros disponíveis --------");
            for (int i = 0; i < this.livrosDaBiblioteca.length; i++) {
                if (livrosDaBiblioteca[i].getEstado() == Estado.DISPONIVEL) {
                    System.out.println("Títilo: "+this.livrosDaBiblioteca[i].getTitulo());
                    System.out.println("Estado: "+this.livrosDaBiblioteca[i].getEstado());
                }
            }
        }
    }
}
