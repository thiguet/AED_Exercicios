//package model;
//
//public class Example {
//	class No {
//	    public int elemento; // Conteudo do no.
//	    public No esq; // No da esquerda.
//	    public No dir; // No da direita.
//	    public int nivel; // Numero de niveis abaixo do no
//	 
//	    No(int elemento) {
//	        this(elemento, null, null, 1);
//	    }
//	 
//	    No(int elemento, No esq, No dir, int nivel) {
//	        this.elemento = elemento;
//	        this.esq = esq;
//	        this.dir = dir;
//	        this.nivel = nivel;
//	    }
//	 
//	    public No setNivel() {
//	        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
//	        return this;
//	    }
//	 
//	    public static int getNivel(No no) {
//	        return (no == null) ? 0 : no.nivel;
//	    }
//	}
//	 
//	public class AVL {
//	    private No raiz; // Raiz da arvore.
//	 
//	    public AVL() {
//	        raiz = null;
//	    }
//	 
//	    public int getAltura() {
//	        return getAltura(raiz);
//	    }
//	     
//	    private int getAltura(No i){
//	        if(i == null)
//	            return 0;
//	        else return Math.max(getAltura(i.esq), getAltura(i.dir)) + 1;
//	    }
//	     
//	 
//	    public boolean pesquisar(int elemento) {
//	        return pesquisar(raiz, elemento);
//	    }
//	 
//	    private boolean pesquisar(No no, int x) {
//	        boolean resp;
//	        if (no == null) {
//	            resp = false;
//	 
//	        } else if (x == no.elemento) {
//	            resp = true;
//	 
//	        } else if (x < no.elemento) {
//	            resp = pesquisar(no.esq, x);
//	 
//	        } else {
//	            resp = pesquisar(no.dir, x);
//	        }
//	        return resp;
//	    }
//	 
//	    public void mostrarCentral() {
//	        System.out.print("[ ");
//	        mostrarCentral(raiz);
//	        System.out.println("]");
//	    }
//	 
//	    private void mostrarCentral(No no) {
//	        if (no != null) {
//	            mostrarCentral(no.esq); // Elementos da esquerda.
//	            System.out.print(no.elemento + " "); // Conteudo do no.
//	            mostrarCentral(no.dir); // Elementos da direita.
//	        }
//	    }
//	 
//	    public void mostrarPre() {
//	        System.out.print("[ ");
//	        mostrarPre(raiz);
//	        System.out.println("]");
//	    }
//	 
//	    private void mostrarPre(No no) {
//	        if (no != null) {
//	            System.out.print(no.elemento + "(fator " + (No.getNivel(no.dir) - no.getNivel(no.esq)) + ") ");
//	            mostrarPre(no.esq); // Elementos da esquerda.
//	            mostrarPre(no.dir); // Elementos da direita.
//	        }
//	    }
//	 
//	    public void mostrarPos() {
//	        System.out.print("[ ");
//	        mostrarPos(raiz);
//	        System.out.println("]");
//	    }
//	 
//	    private void mostrarPos(No no) {
//	        if (no != null) {
//	            mostrarPos(no.esq); // Elementos da esquerda.
//	            mostrarPos(no.dir); // Elementos da direita.
//	            System.out.print(no.elemento + " "); // Conteudo do no.
//	        }
//	    }
//	 
//	    public void inserirAVL(int x) throws Exception {
//	        raiz = inserirAVL(raiz, x);
//	    }
//	 
//	    private No inserirAVL(No no, int x) throws Exception {
//	        if (no == null) {
//	            System.out.println("Inserindo o " + x);
//	            no = new No(x);
//	 
//	        } else if (x < no.elemento) {
//	            System.out.println("-> esq");
//	            no.esq = inserirAVL(no.esq, x);
//	 
//	        } else if (x > no.elemento) {
//	            System.out.println("-> dir");
//	            no.dir = inserirAVL(no.dir, x);
//	 
//	        } else {
//	            throw new Exception("Erro ao inserir elemento (" + x + ")! ");
//	        }
//	 
//	        no = balancear(no);
//	        return no;
//	    }
//	     
//	    public void inserir(int x) throws Exception {
//	        raiz = inserir(raiz, x);
//	    }
//	 
//	    private No inserir(No no, int x) throws Exception {
//	        if (no == null) {
//	            System.out.println("Inserindo o " + x);
//	            no = new No(x);
//	 
//	        } else if (x < no.elemento) {
//	            System.out.println("-> esq");
//	            no.esq = inserir(no.esq, x);
//	 
//	        } else if (x > no.elemento) {
//	            System.out.println("-> dir");
//	            no.dir = inserir(no.dir, x);
//	 
//	        } else {
//	            throw new Exception("Erro ao inserir elemento (" + x + ")! ");
//	        }
//	         
//	        return no;
//	    }
//	 
//	    private No balancear(No no) throws Exception {
//	        if (no != null) {
//	            int fator = No.getNivel(no.dir) - no.getNivel(no.esq);
//	 
//	            // Se balanceada
//	            if (Math.abs(fator) <= 1) {
//	                no = no.setNivel();
//	 
//	                // Se desbalanceada para a direita
//	            } else if (fator == 2) {
//	 
//	                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
//	 
//	                // Se o filho a direita tambem estiver desbalanceado
//	                if (fatorFilhoDir == -1) {
//	                    no.dir = rotacionarDir(no.dir);
//	                }
//	                no = rotacionarEsq(no);
//	 
//	                // Se desbalanceada para a esquerda
//	            } else if (fator == -2) {
//	 
//	                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
//	 
//	                // Se o filho a esquerda tambem estiver desbalanceado
//	                if (fatorFilhoEsq == 1) {
//	                    no.esq = rotacionarEsq(no.esq);
//	                }
//	                no = rotacionarDir(no);
//	 
//	            } else {
//	                throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!");
//	            }
//	        }
//	 
//	        return no;
//	    }
//	 
//	    private No rotacionarDir(No no) {
//	        System.out.println("Rotacionar DIR(" + no.elemento + ")");
//	        No noEsq = no.esq;
//	        No noEsqDir = noEsq.dir;
//	 
//	        noEsq.dir = no;
//	        no.esq = noEsqDir;
//	 
//	        no.setNivel();
//	        noEsq.setNivel();
//	 
//	        return noEsq;
//	    }
//	 
//	    private No rotacionarEsq(No no) {
//	        System.out.println("Rotacionar ESQ(" + no.elemento + ")");
//	        No noDir = no.dir;
//	        No noDirEsq = noDir.esq;
//	 
//	        noDir.esq = no;
//	        no.dir = noDirEsq;
//	 
//	        no.setNivel();
//	        noDir.setNivel();
//	        return noDir;
//	    }
//	 
//	    public void remover(int x) throws Exception {
//	        raiz = remover(raiz, x);
//	    }
//	 
//	    private No remover(No no, int x) throws Exception {
//	 
//	        if (no == null) {
//	            throw new Exception("Erro ao remover!");
//	 
//	        } else if (x < no.elemento) {
//	            no.esq = remover(no.esq, x);
//	 
//	        } else if (x > no.elemento) {
//	            no.dir = remover(no.dir, x);
//	 
//	            // Sem no a direita.
//	        } else if (no.dir == null) {
//	            no = no.esq;
//	 
//	            // Sem no a esquerda.
//	        } else if (no.esq == null) {
//	            no = no.dir;
//	 
//	            // No a esquerda e no a direita.
//	        } else {
//	            no.esq = antecessor(no, no.esq);
//	        }
//	 
//	        no = balancear(no);
//	        return no;
//	    }
//	 
//	    private No antecessor(No n1, No n2) {
//	 
//	        // Existe no a direita.
//	        if (n2.dir != null) {
//	            // Caminha para direita.
//	            n2.dir = antecessor(n1, n2.dir);
//	 
//	            // Encontrou o maximo da subarvore esquerda.
//	        } else {
//	            n1.elemento = n2.elemento; // Substitui N1 por N2.
//	            n2 = n2.esq; // Substitui N2 por N2.ESQ.
//	        }
//	        return n2;
//	    }
//	}
//}
