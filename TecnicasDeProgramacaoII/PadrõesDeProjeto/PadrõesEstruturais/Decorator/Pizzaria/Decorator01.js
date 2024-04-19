// ESTRUTURA DO PROJETO #############################################################
// Interface Componente:
class Pizza{
    constructor(){
        this.descricao = 'Pizza';   
    }

    getDescricao(){
        return this.descricao;
    } 

    custo(){
        return 0;
    }
}

// Implementação concreta das interface Componente para pizzas personalizadas
class PizzaPersonalizada extends Pizza{
    constructor(sabor, tamanho, borda){
        super();
        this.descricao = `Pizza ${sabor} ${tamanho} com borda ${borda}`;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.borda = borda;
    }

    custo(){
        let precoBase = 0;
        if(this.tamanho === "Pequena"){
            precoBase = 15.00;
        } else if (this.tamanho === "Media"){
            precoBase = 20.00;
        } else if (this.tamanho === "Grande"){
            precoBase = 25.00;
        }
        return precoBase.toFixed(2);
    }
}

// Decorador Abstrato:
class Decorator extends Pizza{
    constructor(pizza){
        super();
        this.pizza = pizza;
    }

    getDescricao(){
        return this.pizza.getDescricao();
    }

    custo(){
        return this.pizza.custo();
    }
}

// Decorador Concretos para adicionar ingredientes extras:
class QueijoExtra extends Decorator{
    constructor(pizza){
        super(pizza);
    }

    getDescricao(){
        return `${this.pizza.getDescricao()},; Queijo Extra`;
    }

    custo(){
        return (parseFloat(this.pizza.custo()) + 2.00).toFixed(2);
    }
}

class BaconExtra extends Decorator{
    constructor(pizza){
        super(pizza);
    }

    getDescricao(){
        return `${this.pizza.getDescricao()}, Bacon Extra`;
    }

    custo(){
        return (parseFloat(this.pizza.custo()) + 3.00).toFixed(2);
    }
}

class PepperoniExtra extends Decorator{
    constructor(pizza){
        super(pizza);
    }

    getDescricao(){
        return `${this.pizza.getDescricao()}, Pepperoni Extra`;
    }

    custo(){
        return (parseFloat(this.pizza.custo()) + 4.00).toFixed(2);
    }
}

// Exemplo de Uso : #################################################################
// Simulação no index.html
function montarPizza(){
    // Obtendo Sabor Selecionado:
    let saborSelecionado = document.querySelector('input[name="sabor"]:checked');
    let sabor = saborSelecionado ? saborSelecionado.value : '';

    // Obtendo Tamanho Selecionado:
    let tamanhoSelecionado = document.querySelector('input[name="tamanho"]:checked');
    let tamanho = tamanhoSelecionado ? tamanhoSelecionado.value : '';

    // Obtendo Borda Selecionado:
    let bordaSelecionado = document.querySelector('input[name="tamanho"]:checked');
    let borda = tamanhoSelecionado ? tamanhoSelecionado.value : '';

    // Criando Objeto PizzaPersonalizada com base nas seleções do usuarios:
    let pizzaPersonalizada = new PizzaPersonalizada(sabor, tamanho, borda);

    // Aplicar decoradores para ingredientes extras, se selecionados
    let queijoExtraCheckbox = document.querySelector('input[name="queijo-extra"]:checked');
    if (queijoExtraCheckbox) {
        pizzaPersonalizada = new QueijoExtra(pizzaPersonalizada);
    }

    let baconExtraCheckbox = document.querySelector('input[name="bacon-extra"]:checked');
    if (baconExtraCheckbox) {
        pizzaPersonalizada = new BaconExtra(pizzaPersonalizada);
    }

    let pepperoniCheckbox = document.querySelector('input[name="pepperoni-extra"]:checked');
    if (pepperoniCheckbox) {
        pizzaPersonalizada = new PepperoniExtra(pizzaPersonalizada);
    }

    // Obter o custo total da pizza personalizada
    let custoTotal = parseFloat(pizzaPersonalizada.custo());

    // Exibir o custo total do pedido
    let totalPedidoElement = document.getElementById("total-pedido");
    totalPedidoElement.textContent = "R$ " + custoTotal.toFixed(2);
}
