package ProjectoFacil;

import java.util.Scanner;

public class TesteProjecto {
public final int REGISTRARUMNOVOMENBRO = 1, ADICIONARUMLIVROAOACERVO = REGISTRARUMNOVOMENBRO+1;
public final int EMPRESTARUMLIVROAUMMEMBRO = ADICIONARUMLIVROAOACERVO+1, 
LISTARLIVROSDABIBLIOTECA = EMPRESTARUMLIVROAUMMEMBRO+1,
LISTARMEMBROSDABIBLIOTECA = LISTARLIVROSDABIBLIOTECA+1;
public final int LISTARLIVROSEMPRESTADOSDEUMMEMBRO = LISTARMEMBROSDABIBLIOTECA+1, 
DEVLOVERLIVRO = LISTARLIVROSEMPRESTADOSDEUMMEMBRO+1,
LIVROSDISPONIVEIS = DEVLOVERLIVRO+1;
Scanner leitor = new Scanner(System.in);


    public long adicionarISBNManual(){
        System.out.print("Digite o ISNB: ");
         long isbn =0;
        isbn = leitor.nextLong();
        leitor.nextLine();
        return isbn;
    }
    public String adcionarTituloDoLivro(){
        Scanner leitor1 = new Scanner(System.in);
        System.out.print("Digite o título: ");
        String str;
        str = leitor1.nextLine();
        leitor.nextLine();
        return str;
    }
     public String adcionarAutorDoLivro(){
        Scanner leitor1 = new Scanner(System.in);
        System.out.print("Digite o Autor: ");
        String str;
        str = leitor1.nextLine();
        return str; 
    }
    public void adicionarLivroAoAcervoOpcao(Estado estado, Biblioteca biblioteca){
        System.out.println("Adicionando livro ao acervo da Biblioteca...");
        String nome = adcionarTituloDoLivro(), autor= adcionarAutorDoLivro();
        Livro livro = new Livro(nome,autor , adicionarISBNManual(), estado);
        System.out.println();
        biblioteca.adicionarLivroAoAcervo(livro);
        System.out.println("Livro acionado ao acervo...");
        System.out.println();
    }


public void listarLivrosDeUmMembroOpcao(Biblioteca biblioteca){
    String nome;
    int numero;
    Scanner leScanner = new Scanner(System.in);
    System.out.print("Digite o nome do membro: ");
    nome= leScanner.nextLine();
    leitor.nextLine();
    System.out.print("Digite o numero do membro: ");
    numero= leScanner.nextInt();
    leitor.nextLine();

        if (biblioteca!=null) {
            for (int i = 0; i < biblioteca.getMembros().length; i++) {    
            if (nome.equalsIgnoreCase(biblioteca.getMembros()[i].getNome()) && numero== biblioteca.getMembros()[i].getNumeroDeMembro()) {
                biblioteca.getMembros()[i].listarLivrosDoMembro();
                return;
            }
            }
        }
}

public void devolverUmLivroOpcao(Biblioteca biblioteca){
    System.out.println(" Devolucão de livro ....");
    Scanner lScanner = new Scanner(System.in);
    long isbn;
    String nome;
    Livro livro = null;
    Membro membro = null;
    System.out.print("Digite o nome do membro: ");
    nome= lScanner.nextLine();
    System.out.print("Digite o ISBN: ");
    isbn = leitor.nextLong();
    lScanner.nextLine();

            if (biblioteca!= null) {
                for (int i = 0; i < biblioteca.getLivrosDaBiblioteca().length; i++) {
                        if (biblioteca.getLivrosDaBiblioteca()[i].getISBN()==isbn) {
                            livro = biblioteca.getLivrosDaBiblioteca()[i];
                            break;
                        }
                }

                for (int i = 0; i < biblioteca.getMembros().length; i++) {
                    if(biblioteca.getMembros()[i].getNome().equals(nome))
                        membro = biblioteca.getMembros()[i];
                    break;
                }

                biblioteca.devolverUmLivro(livro, membro);
            }
}

public void listarLivrosDisponiveisDaBiblioteca(Biblioteca biblioteca){
        System.out.println("Livros disponíveis...");
        if (biblioteca!= null) {
            biblioteca.livrosDisponiveis();
        }
}

public void emprestarUmLivroAUmMembroOpcao(Biblioteca biblioteca){
    System.out.println("Emprestando um livro...");
    int contador1 = 0, contador2 = 0;
        if (biblioteca==null) {
            System.out.println("Biblioteca vazia, precisa cadastrar antes membros e livros...");
            return;
        }else{
            Scanner lScanner = new Scanner(System.in);
            Livro livro = null;
            Membro membro = null;
            String titulo, nome;
            long isbn;
            int numero;
            System.out.print("Digite o título do livro: ");
            titulo = lScanner.nextLine();
            leitor.nextLine();
            System.out.print("International Standard Book Number: ");
            isbn= lScanner.nextLong();
            leitor.nextLine();
            
            for (int i = 0; i < biblioteca.getLivrosDaBiblioteca().length; i++) {
                
                if (titulo.equalsIgnoreCase(biblioteca.getLivrosDaBiblioteca()[i].getTitulo()) &&
                isbn == biblioteca.getLivrosDaBiblioteca()[i].getISBN()){ 
                livro = biblioteca.getLivrosDaBiblioteca()[i];
                break;
                }
                contador1+=1;
            }
            System.out.println("Títlo: "+livro.getTitulo());
            System.out.println(""+livro.getISBN());
            if(contador1 == biblioteca.getLivrosDaBiblioteca().length){
            System.out.println("Livro não encontrado no acervo da biblioteca...");
            return;
        }
        
            System.out.print("Digite o nome do membro: ");
            nome = leitor.nextLine();
            lScanner.nextLine();
            System.out.print("Digite o número de membro: ");
            numero = lScanner.nextInt();
            leitor.nextLine();
            
        for (int i = 0; i < biblioteca.getMembros().length; i++) {
                if (nome.equalsIgnoreCase(biblioteca.getMembros()[i].getNome()) && numero == biblioteca.getMembros()[i].getNumeroDeMembro()) {
                    membro = biblioteca.getMembros()[i];
                    break;
                }
                contador2+=1;
                }
                
        if(contador2 == biblioteca.getMembros().length){
            System.out.println(contador2);
            System.out.println("Membro não cadastrado na biblioteca...");
            return;
        }
            biblioteca.emprestarUmLivroAumMembro(livro, membro);
    }
}

public void listarLivrosDaBibliotecaOpcao(Biblioteca biblioteca){
        System.out.println("Listagem de livros da biblioteca...");
        biblioteca.listarLivrosDaBiblioteca();
}

public void listarMembrosDaBibliotecaOpcao(Biblioteca biblioteca){
    System.out.println("Listagem de Membros da biblioteca...");
       biblioteca.listarMembrosDaBiblioteca();
}

public int inserirNumeroDoMembro(){
    int numero;
    System.out.print("Digite o número: ");
    numero = leitor.nextInt();
    leitor.nextLine();
    return numero;
}
    public String adicionarNomeDeNovoMemmbro(){
        Scanner lScanner = new Scanner(System.in);
        String nome;
        System.out.print("Digite o nome: ");
        nome = lScanner.nextLine();
        leitor.nextLine();
        return nome ;
    }
    public void registrarUmNovoMembroOpcao(Biblioteca biblioteca){
            System.out.println(" Registrando um novo membro...");
            Membro membro = new Membro(adicionarNomeDeNovoMemmbro(), inserirNumeroDoMembro());
            biblioteca.registrarUmNovoMembro(membro);
            System.out.println("Membro adicionado com sucesso...");
    }
    public void apresetacao(){
        String str ="------- Projecto Biblioteca -------\n";
        str+="Olá!\n" +"Este mini projecto foi desenvolvido como um dos exercício de teste dos meus conhecimentos de POO.\n";
        str+="Autor: Francisco Sokisso."+" Data: 25/09/2026 \n";
        str+="Este é um pequeno programa que faz a gestão de livros de uma pequena biblioteca.\n"+"O sistema tem várias classes e métodos com funcionalidades adequados ao tema do projecto.\n";
        str+="Deseja testar o sistema?\n"+"Preciona s para sim e n para não.\n"; 
        System.out.println(str);
    }

    public char respostaParaTestarPrograma(){
        char opcao;
        System.out.print("Digite a sua escolha: ");
        opcao = leitor.nextLine().charAt(0);
        return opcao;
    }
     
    public int escolherOperacao(){
        int ocpcao;
        String str = "---------- Escolha uma operação ----------\n";
        str+="1- Registrar um novo membro.\n";
        str+="2- Adicionar um novo livro ao acervo.\n";
        str+="3- Emprestar um livro a um membro.\n";
        str+="4- Listar livros da biblioteca.\n";
        str+="5- Listar membros da biblioteca.\n";
        str+="6- Listar livros emprestados de um membro.\n";
        str+="7- Devolver um livro.\n";
        str+="8- Listar livros disponíveis.\n";

        System.out.println(str);
        ocpcao= leitor.nextInt();
        return ocpcao;
    }

    public int enserrarOpcao(){
        int opcao;
        System.out.println("Deseja continuar?");
        System.out.println("Preciona 1 para sim");
        System.out.println("Preciona 0 para não.");
        opcao= leitor.nextInt();
        leitor.nextLine();
        return opcao;
    }

    public void testarProgram(char opcao){
            if (opcao != 's' && opcao!= 'S') {
                System.out.println("Obrigado pela sua disponibidade. Até a próxima oportunidade!");
            }else{
                Scanner leitor = new Scanner(System.in);
                Biblioteca biblioteca = new Biblioteca();
                Estado estado = Estado.DISPONIVEL;
                int opcao1=1;
                
                while (opcao1==1) {
                 
                switch (escolherOperacao()) {
                    case REGISTRARUMNOVOMENBRO:
                            registrarUmNovoMembroOpcao(biblioteca);
                            opcao1=enserrarOpcao();
                        break;
                    case ADICIONARUMLIVROAOACERVO:
                    adicionarLivroAoAcervoOpcao(estado, biblioteca);
                    opcao1=enserrarOpcao();
                    break;
                    case EMPRESTARUMLIVROAUMMEMBRO:
                        emprestarUmLivroAUmMembroOpcao(biblioteca);
                        opcao1=enserrarOpcao();
                    break;

                    case LISTARLIVROSDABIBLIOTECA:
                        listarLivrosDaBibliotecaOpcao(biblioteca);
                        opcao1=enserrarOpcao();
                    break;

                     case LISTARMEMBROSDABIBLIOTECA:
                        listarMembrosDaBibliotecaOpcao(biblioteca);
                        opcao1=enserrarOpcao();
                    break;

                    case LISTARLIVROSEMPRESTADOSDEUMMEMBRO:
                        listarLivrosDeUmMembroOpcao(biblioteca);
                        opcao1=enserrarOpcao();
                    break;

                    case DEVLOVERLIVRO:
                        devolverUmLivroOpcao(biblioteca);
                        opcao1=enserrarOpcao();
                    break;

                    case LIVROSDISPONIVEIS:
                        listarLivrosDisponiveisDaBiblioteca(biblioteca);
                    opcao1=enserrarOpcao();
                    break;
                    default:
                        break;
                }
                }
                
            }
    }
    public static void main(String[] args) { 
        TesteProjecto t = new TesteProjecto();
        t.apresetacao();
        t.testarProgram(t.respostaParaTestarPrograma());
    }
}
