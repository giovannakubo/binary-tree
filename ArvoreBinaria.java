public class ArvoreBinaria {
    private No raiz;
    public ArvoreBinaria() {
        this.raiz = null;
    }
    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        No pai;
        if(raiz == null) {
            //System.out.println("A raiz foi criada com o conteúdo " + novoNo.getConteudo() + ".");
            raiz = novoNo;
        } else {
            //Verificar se ficara a esq ou direita
            No atual = raiz;
            while(true) {
                pai = atual;
                if(novoNo.getConteudo() <= atual.getConteudo()) {
                    //posicionar o nó à esq
                    atual = atual.getEsquerda();
                    if(atual == null) {
                        pai.setEsquerda(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                } else {
                    //posicionar o nó à dir
                    atual = atual.getDireita();
                    if(atual == null) {
                        pai.setDireita(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                }
            }

        }
    }
    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }
    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }
    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
    public No getRaiz() {
        return raiz;
    }


    public void remover(int conteudo){
        searchNo(conteudo);
        No noRemover = achado;

        if((noRemover.getEsquerda() == null)&&(noRemover.getDireita() == null)){ //REMOVER FOLHA
            if(paiRemover.getDireita() == noRemover){
                paiRemover.setDireita(null);
            }else{
                paiRemover.setEsquerda(null);
            }
        } else if((noRemover.getEsquerda() == null)&&(noRemover.getDireita() != null) || (noRemover.getEsquerda() != null)&&(noRemover.getDireita() == null)) {//REMOVER 1 FILHO
            //ACHANDO EM QUAL POSIÇÃO O PAI ESTÁ
            if(paiRemover.getDireita() == noRemover){//O NOREMOVER ESTA À DIREITA
                if (noRemover.getDireita() != null){//O FILHO ESTA A DIREITA
                    temp = noRemover.getDireita(); //SALVANDO O FILHO DO NOREMOVER
                    paiRemover.setDireita(null);//TIRANDO O NOREMOVER
                    paiRemover.setDireita(temp);//COLOCANDO O FILHO NO LUGAR
                }else{//O FILHO ESTA A ESQUERDA
                    temp = noRemover.getEsquerda(); //SALVANDO O FILHO DO NOREMOVER
                    paiRemover.setDireita(null);//TIRANDO O NOREMOVER
                    paiRemover.setDireita(temp);//COLOCANDO O FILHO NO LUGAR
                }
            }else{//NOREMOVER ESTA À ESQUERDA
                if(noRemover.getDireita() != null){//O FILHO ESTA A DIREITA
                    temp = noRemover.getDireita(); //SALVANDO O FILHO DO NOREMOVER
                    paiRemover.setEsquerda(null);//TIRANDO O NOREMOVER
                    paiRemover.setEsquerda(temp);//COLOCANDO O FILHO NO LUGAR
                }else{//O FILHO ESTA A ESQUERDA
                    temp = noRemover.getEsquerda(); //SALVANDO O FILHO DO NOREMOVER
                    paiRemover.setEsquerda(null);//TIRANDO O NOREMOVER
                    paiRemover.setEsquerda(temp);//COLOCANDO O FILHO NO LUGAR
                }
            }

        } else if ((noRemover.getEsquerda() != null)&&(noRemover.getDireita() != null)) {//REMOVER 2 FILHOS
            acharSucessor(noRemover);
            if(sucessor.getDireita() != null){//SE O SUCESSOR TIVER FILHO
                if(paiSucessor.getDireita() == sucessor){//SE O SUCESSOR ESTIVER A DIREITA DO PAI
                    novaEsquerda = noRemover.getEsquerda();
                    if(noRemover != raiz && paiRemover.getDireita() == noRemover){//SE O FILHO DO PAIREMOVER ESTIVER A DIREITA
                            paiSucessor.setDireita(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            paiRemover.setDireita(null);
                            paiRemover.setDireita(sucessor);
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    } else if (noRemover == raiz) { //SE TIVER REMOVENDO A RAIZ
                            paiSucessor.setDireita(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            raiz = null;
                            raiz = sucessor;
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    } else{//SE O FILHO DO PAIREMOVER ESTIVER A ESQUERDA
                            paiSucessor.setDireita(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            paiRemover.setEsquerda(null);
                            paiRemover.setEsquerda(sucessor);
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    }
                }else{//SE O SUCESSOR ESTIVER A ESQUERDA DO PAI
                    novaEsquerda = noRemover.getEsquerda();
                    if(noRemover != raiz &&  paiRemover.getDireita() == noRemover){//SE O FILHO DO PAIREMOVER ESTIVER A DIREITA
                            paiSucessor.setEsquerda(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            paiRemover.setDireita(null);
                            paiRemover.setDireita(sucessor);
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    } else if (noRemover == raiz) {
                            paiSucessor.setEsquerda(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            raiz = sucessor;
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    } else{//SE O FILHO DO PAI REMOVER ESTIVER A ESQUERDA
                            paiSucessor.setEsquerda(sucessor.getDireita());
                            novaDireita = noRemover.getDireita();
                            paiRemover.setEsquerda(null);
                            paiRemover.setEsquerda(sucessor);
                            sucessor.setEsquerda(novaEsquerda);
                            sucessor.setDireita(novaDireita);
                    }
                }
            }else{//SE NÃO TIVER
                novaEsquerda = noRemover.getEsquerda();
                if(paiSucessor.getDireita() == sucessor){//O SUCESSOR ESTA A DIREITA DE SEU PAI
                    if(noRemover!=raiz && paiRemover.getDireita() == noRemover){//O NO REMOVER ESTÁ A DIREITA DE SEU PAI
                        paiSucessor.setDireita(null);
                        paiRemover.setDireita(sucessor);
                        sucessor.setEsquerda(novaEsquerda);
                    } else if (noRemover == raiz) {//REMOVENDO A RAIZ
                        paiSucessor.setDireita(null);
                        novaDireita = raiz.getDireita();
                        raiz = null;
                        raiz.setDireita(novaDireita);
                        raiz.setEsquerda(novaEsquerda);
                    }else{//O NOREMOVER ESTÁ A ESQUERDA DE SEU PAI
                        paiSucessor.setDireita(null);
                        paiRemover.setEsquerda(sucessor);
                        sucessor.setEsquerda(novaEsquerda);
                    }
                }else{//O SUCESSOR ESTA À ESQUERDA DE SEU PAI
                    if(noRemover!= raiz && paiRemover.getDireita() == noRemover){//O NO REMOVER ESTÁ A DIREITA DE SEU PAI
                        paiSucessor.setEsquerda(null);
                        paiRemover.setDireita(sucessor);
                        sucessor.setEsquerda(novaEsquerda);
                    } else if (noRemover == raiz) {//REMOVENDO A RAIZ
                        paiSucessor.setEsquerda(null);
                        novaDireita = raiz.getDireita();
                        raiz = null;
                        raiz = sucessor;
                        raiz.setDireita(novaDireita);
                        raiz.setEsquerda(novaEsquerda);
                    }else{//O NOREMOVER ESTÁ A ESQUERDA DE SEU PAI
                        paiSucessor.setEsquerda(null);
                        paiRemover.setEsquerda(sucessor);
                        sucessor.setEsquerda(novaEsquerda);
                    }
                }

            }
        }

    }

    public No sucessor = null;
    public No paiSucessor = null;
    public No paiRemover = null;

    public No novaEsquerda = null;
    public No novaDireita = null;

    public No temp = null;
    public void acharSucessor(No atual2) {
            paiSucessor = atual2;
            if(atual2.getDireita()!=null){
                atual2 = atual2.getDireita();
                while(true){
                    if(atual2.getEsquerda() == null){
                        sucessor = atual2;
                        return;
                    }else{
                        paiSucessor = atual2;
                        atual2 = atual2.getEsquerda();
                    }
                }
            }else{
                atual2 = atual2.getEsquerda();
                while(true){
                    if(atual2.getDireita() == null){
                        sucessor = atual2;
                        return;
                    }else{
                        paiSucessor = atual2;
                        atual2 = atual2.getDireita();
                    }
                }
            }

    }

    public No achado = null;
    public void searchNo(int conteudo){
        No atual = raiz;
        while(true){
                if (conteudo == raiz.getConteudo()) {
                    achado = raiz;
                    System.out.println("Nó achado!");
                    System.out.println(achado.getConteudo());
                    System.out.println("É a raiz!");
                    return;
                }
                if(conteudo == atual.getConteudo()){
                    achado = atual;
                    System.out.println("Nó achado!");
                    System.out.println(achado.getConteudo());
                    return;
                }

                if (conteudo < atual.getConteudo()) {
                    paiRemover = atual;
                    atual = atual.getEsquerda();
                }

                if (conteudo > atual.getConteudo()) {
                    paiRemover = atual;
                    atual = atual.getDireita();
                }

        }
    }
}