/* ESCOPO: Programa que cria algumas frutas e uma caixa de fruta(container).
Adiciona as frutas na caixa, e a embalagem. Um método chamad obterPreco() da caixa deve percorrer todos os sub-elementos da árvore, somar os preços e de todos os componentes adicionais (composição), por fim retorna o preço total.
*/
 
//Classe Componentes
class Componente{
    constructor(nome){
        this.nome = nome;
    }
 
    adicionar(){}
 
    remover(){}
 
    obterNome(){}
}
 
//Classe Folha
class Folha extends Componente{
    constructor(nome, preco){
        super(nome);
        this.preco = preco;
    }
 
    obterNome(){
        return this.nome;
    }
 
    obterPreco(){
        return this.preco;
    }
}
 
//Classe container
class Container extends Componente{
    constructor(nome){
        super(nome);
        this.componentes = [];
    }
 
    adicionar(componente){
        this.componentes.push(componente);
    }
 
    remover(componente){
        const index = this.componentes.indexOf(componente);
        this.componentes.splice(index, 1);
    }
 
    obterNome(){
        return this.nome;
    }
 
    obterPreco(){
        let preco = 0;
        this.componentes.forEach(componente => {
            preco += componente.obterPreco();
        })
        return preco;
    }
}
 
//Interface de utilização ##################################
const maca = new Folha('Maçã', 8.99);
const laranja = new Folha('Laranja', 3.69);
const uva = new Folha('Uva', 9.98);
 
const frutas = new Container('Frutas');
frutas.adicionar(maca);
frutas.adicionar(laranja);
frutas.adicionar(uva);
 
const caixa = new Container('Caixa de Frutas');
caixa.adicionar(frutas);
caixa.adicionar(new Folha('Embalagem', 1.90));
 
console.log(`Preço Total: R$${caixa.obterPreco()}`);
