//FATEC Diadema - Luigi Papaiz
//Curso Desenvolvimento de Sorftware Multiplataforma - DSM
// Diciplina Tecinicas de programação II
//Nome: Dandara Silva Melo data:
//Nome: Mariana Julia Macedo Da Silva  
//data: 23/02/2024
//Descrição: Aplicação de padrão GoF - Atividade - Pizzaria
 
const prompt = require('prompt-sync')();
 
//Itens da Pizza
 
class Tamanho{
    constructor(tipoTamanho){
        this.tipoTamanho = tipoTamanho;
    }
}
 
class Massa{
    constructor(tipoMassa){
        this.tipoMassa = tipoMassa;
    }
}
 
class Molho{
    constructor(tipoMolho){
        this.tipoMolho = tipoMolho;
    }
}
 
class Proteina{
    constructor(tipoProteina){
        this.tipoProteina = tipoProteina;
    }
}
 
class Queijo{
    constructor(tipoQueijo){
        this.tipoQueijo = tipoQueijo;
    }
}
 
class Complemento{
    constructor(tipoComplemento){
        this.tipoComplemento = tipoComplemento;
    }
}
 
//Produto
// Na classe PizzaBuilder, os atributos são inicializados com null no
//construtor porque inicialmente ainda não há valores definidos para esses atributos.
 
class PizzaBuilder{
    constructor(){
        this.tamanho = null;
        this.massa = null;
        this.molho = null;
        this.proteina = null;
        this.queijo = null;
        this.complemento = null;
    }
 
    //default
    reset(){
        this.tamanho = null;
        this.massa = null;
        this.molho = null;
        this.proteina = null;
        this.queijo = null;
        this.complemento = null;
        return this;
    }
 
    //Builder
 
    escolherTamanho(tipo){
        this.tamanho = new  Tamanho(tipo)
        return this;
    }
 
    escolherMassa(tipo){
        this.massa = new Massa(tipo)
        return this;
    }
 
    adicionarMolho(tipo){
        this.molho = new Molho(tipo)
        return this;
    }
 
    adicionarProteina(tipo){
        this.proteina = new Proteina(tipo)
        return this;
    }
 
    adicionarQueijo(tipo){
        this.queijo = new Queijo(tipo)
        return this;
    }
 
    adicionarComplemento(tipo){
        this.complemento = new Complemento(tipo)
        return this;
    }
 
    montarPizza(){
        return new Pizza(this.tamanho, this.massa, this.molho, this.proteina, this.queijo, this.complemento)
 
    }
}
 
//Director
class Pizza{
    constructor(tamanho, massa, molho, proteina, queijo, complemento){
        this.tamanho = tamanho;
        this.massa = massa;
        this.molho = molho;
        this.proteina = proteina;
        this.queijo = queijo;
        this.complemento = complemento;
    }
 
    mostrarPizza(){
        console.log(`Tamanho: ${this.tamanho.tipoTamanho}`)
        console.log(`Massa: ${this.massa.tipoMassa}`)
        console.log(`Molho: ${this.molho.tipoMolho}`)
        console.log(`Proteina: ${this.proteina.tipoProteina}`)
        console.log(`Queijo: ${this.queijo.tipoQueijo}`)
        console.log(`Complemento: ${this.complemento.tipoComplemento}`)
    }
 
}
 
//Interface do Cliente
 
const builder = new PizzaBuilder();
 
console.log ("Tamanho (Grande, Padrão e Pequeno)")
console.log ("Massa (Tradicional, Integral e Fitness)")
console.log ("Molho (Molho Tomate, Molho Temperado e Molho Ervas)")
console.log ("Proteina (Calabrasa, Frango, Presunto, Atum)")
console.log ("Queijos (Mussarela, Catupiry, Cheddar)")
console.log ("Complemento (Azeitona, Oregano, Tomate, Cebola, Bacon)")
console.log("\n")
 
let tamanhoInput = prompt('Tamanho: ');
let massaInput = prompt('Massa: ');
let molhoInput = prompt('Molho: ');
let proteinaInput = prompt('Proteina: ');
let queijoInput = prompt('Queijo: ');
let complementoInput = prompt('Complemento: ')
console.log("\n")
 
const pizzapedida = builder
.escolherTamanho(tamanhoInput)
.escolherMassa(massaInput)
.adicionarMolho(molhoInput)
.adicionarProteina(proteinaInput)
.adicionarQueijo(queijoInput)
.adicionarComplemento(complementoInput)
.montarPizza()
 
console.log("Seu Pedido")
console.log("-------------------")
pizzapedida.mostrarPizza()
console.log("\n")
builder.reset()